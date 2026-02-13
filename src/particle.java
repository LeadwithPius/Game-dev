import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.Random;

public class Particle {
    private double x, y, vx, vy;
    private double life = 1.0;
    private Color color;
    private static final Random random = new Random();

    public Particle(double x, double y, Color c) {
        this.x = x;
        this.y = y;
        this.color = c;
        this.vx = (random.nextDouble() - 0.5) * 5;
        this.vy = (random.nextDouble() - 0.5) * 5;
    }

    public void update() {
        x += vx;
        y += vy;
        life -= 0.05;
    }

    public void draw(GraphicsContext gc) {
        gc.setGlobalAlpha(Math.max(0, life));
        gc.setFill(color);
        gc.fillOval(x, y, 5, 5);
        gc.setGlobalAlpha(1.0);
    }

    public boolean isDead() {
        return life <= 0;
    }
}