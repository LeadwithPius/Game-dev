import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;

public class Background {
    
    public void draw(GraphicsContext gc) {
        // 1. Sky (Gradient)
        gc.setFill(LinearGradient.valueOf("from 0% 0% to 0% 100%, #87CEEB 0%, #E0F7FA 100%"));
        gc.fillRect(0, 0, Config.WIDTH, Config.HEIGHT);

        // 2. Ground
        gc.setFill(Color.FORESTGREEN);
        gc.fillRect(0, Config.GROUND_Y, Config.WIDTH, Config.HEIGHT - Config.GROUND_Y);

        // 3. Grass Line
        gc.setStroke(Color.DARKGREEN);
        gc.setLineWidth(5);
        gc.strokeLine(0, Config.GROUND_Y, Config.WIDTH, Config.GROUND_Y);

        // 4. Sun
        gc.setFill(Color.YELLOW);
        gc.fillOval(Config.WIDTH - 100, 50, 60, 60);
    }
}