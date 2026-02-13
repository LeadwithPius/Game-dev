import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Totem extends GameObject {
    private double floatOffset = 0;

    public Totem(double x, double y) {
        super(x, y, 30, 30);
    }

    @Override
    public void update(double gameSpeed) {
        x -= gameSpeed;
        
        // Floating effect
        floatOffset += 0.1;
        y += Math.sin(floatOffset) * 0.5;
    }

    @Override
    public void draw(GraphicsContext gc) {
        // Glow effect
        gc.setGlobalAlpha(0.5);
        gc.setFill(Color.LIME);
        gc.fillOval(x - 5, y - 5, width + 10, height + 10);
        gc.setGlobalAlpha(1.0);

        // Cross Shape
        gc.setFill(Color.WHITE);
        gc.fillRect(x + 10, y, 10, 30); // Vertical
        gc.fillRect(x, y + 10, 30, 10); // Horizontal

        gc.setStroke(Color.GREEN);
        gc.setLineWidth(2);
        gc.strokeRect(x + 10, y, 10, 30);
        gc.strokeRect(x, y + 10, 30, 10);
    }
}