import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Obstacle extends GameObject {

    public Obstacle(double x, double groundY) {
        super(x, groundY - 40, 40, 40);
    }

    @Override
    public void update(double gameSpeed) {
        x -= gameSpeed;
    }

    @Override
    public void draw(GraphicsContext gc) {
        // Draw Spikes
        gc.setFill(Color.CRIMSON);
        double[] xPoints = {x, x + width / 2, x + width};
        double[] yPoints = {y + height, y, y + height};
        gc.fillPolygon(xPoints, yPoints, 3);

        // Outline
        gc.setStroke(Color.DARKRED);
        gc.setLineWidth(2);
        gc.strokePolygon(xPoints, yPoints, 3);
    }
}