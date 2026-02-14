import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Obstacle extends GameObject {

    public Obstacle(double x, double groundY) {
        super(x, groundY - 40, 40, 40, 5.0);
    }

    @Override
    public void update() {
        x -= speed;
    }

    @Override
    public void draw(GraphicsContext gc) {
        double[] xPoints = {x, x + width / 2, x + width};
        double[] yPoints = {y + height, y, y + height};

        gc.setFill(Color.CRIMSON);
        gc.fillPolygon(xPoints, yPoints, 3);
        gc.setStroke(Color.DARKRED);
        gc.setLineWidth(2);
        gc.strokePolygon(xPoints, yPoints, 3);
    }
}