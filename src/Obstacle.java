import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Obstacle extends GameObject {
    // Define these so the draw method can access them
    private double width = 40;
    private double height = 40;

    public Obstacle(double x, double groundY) {
        // Must match GameObject constructor: (path, width, height, speed)
        super("", 40, 40, 5.0); 
        this.sprite.setLayoutX(x);
        this.sprite.setLayoutY(groundY - height);
    }

    @Override
    public void update() {
        // Moves the obstacle left based on the speed set in the constructor
        sprite.setLayoutX(sprite.getLayoutX() - speed);
    }

    public void draw(GraphicsContext gc) {
        // Sync drawing with the sprite's actual position
        double currentX = sprite.getLayoutX();
        double currentY = sprite.getLayoutY();

        double[] xPoints = {currentX, currentX + width / 2, currentX + width};
        double[] yPoints = {currentY + height, currentY, currentY + height};

        gc.setFill(Color.CRIMSON);
        gc.fillPolygon(xPoints, yPoints, 3);

        gc.setStroke(Color.DARKRED);
        gc.setLineWidth(2);
        gc.strokePolygon(xPoints, yPoints, 3);
    }
}