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
    private ArrayList<GameObject> gameObjects;
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
    }

    public Player getPlayer() { return player; }
    public Pane getRoot() { return root; }

    public void startGame() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
                render();
            }
        }.start();
    }

    private void update() {
        frameCount++;
        player.update();

        // Spawn a new Obstacle every 120 frames (~2 seconds)
        if (frameCount % 120 == 0) { 
            Obstacle obs = new Obstacle(Config.WIDTH, Config.GROUND_Y);
            gameObjects.add(obs);
        }

        Iterator<GameObject> objIter = gameObjects.iterator();
        while (objIter.hasNext()) {
            GameObject obj = objIter.next();
            obj.update();

            // Collision Detection using bounding boxes
            if (player.getBounds().intersects(obj.getBounds())) {
                addExplosion(player.getX(), player.getY());
                // Game Over logic can go here
            }

            if (obj.isOffScreen()) {
                objIter.remove();
            }
        }

        particles.removeIf(Particle::isDead);
        for (Particle p : particles) p.update();
    }

    private void render() {
        gc.clearRect(0, 0, Config.WIDTH, Config.HEIGHT);
        background.draw(gc);
        player.draw(gc); // Draws the Knight's custom shapes
        
        for (GameObject obj : gameObjects) {
            obj.draw(gc);
        }
        
        for (Particle p : particles) p.draw(gc);
    }

    public void addExplosion(double x, double y) {
        for (int i = 0; i < 15; i++) {
            particles.add(new Particle(x, y, javafx.scene.paint.Color.ORANGE));
        }
    }
}