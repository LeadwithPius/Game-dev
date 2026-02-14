import java.util.ArrayList;
import java.util.Iterator;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

public class Game {
    private Pane root;
    private Canvas canvas;
    private GraphicsContext gc;
    
    private Background background;
    private Player player; 
    private ArrayList<Particle> particles;
    private ArrayList<Game> game; 
    
    private int frameCount = 0;

    public Game() {
        root = new Pane();
        canvas = new Canvas(Config.WIDTH, Config.HEIGHT);
        gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        
        background = new Background();
        particles = new ArrayList<>();
        gameObjects = new ArrayList<>();
        
        player = new Player();
        root.getChildren().add(player.getNode());
    }

    public Player getPlayer() { return player; }
    public Pane getRoot() { return root; }

    public void startGame() {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
                render();
            }
        };
        timer.start();
    }

    private void update() {
        frameCount++;
        player.update();

        // Spawn a new Obstacle every 2 seconds
        if (frameCount % 120 == 0) { 
            Obstacle obs = new Obstacle(Config.WIDTH, Config.GROUND_Y);
            gameObjects.add(obs);
            root.getChildren().add(obs.getNode());
        }

        Iterator<GameObject> objIter = gameObjects.iterator();
        while (objIter.hasNext()) {
            GameObject obj = objIter.next();
            obj.update();

            // Collision Detection
            if (player.getNode().getBoundsInParent().intersects(obj.getNode().getBoundsInParent())) {
                addExplosion(player.getNode().getLayoutX(), player.getNode().getLayoutY());
            }

            if (obj.isOffScreen()) {
                root.getChildren().remove(obj.getNode());
                objIter.remove();
            }
        }

        particles.removeIf(Particle::isDead);
        for (Particle p : particles) { p.update(); }
    }

    private void render() {
        gc.clearRect(0, 0, Config.WIDTH, Config.HEIGHT);
        background.draw(gc);
        player.draw(gc);
        
        // Render custom shapes for Obstacles
        for (GameObject obj : gameObjects) {
            if (obj instanceof Obstacle) {
                ((Obstacle) obj).draw(gc);
            }
        }
        
        for (Particle p : particles) { p.draw(gc); }
    }

    public void addExplosion(double x, double y) {
        for (int i = 0; i < 15; i++) {
            particles.add(new Particle(x, y, javafx.scene.paint.Color.ORANGE));
        }
    }
}