import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;

public abstract class GameObject {
    protected double x, y, width, height, speed;

    public GameObject(double x, double y, double width, double height, double speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
    }

    // Every object must know how to update its logic and draw itself
    public abstract void update();
    public abstract void draw(GraphicsContext gc);

    public boolean isOffScreen() {
        return x + width < 0;
    }

    // Creates an invisible math rectangle around the object for collision detection
    public Rectangle2D getBounds() {
        return new Rectangle2D(x, y, width, height);
    }

    // Getters for the Game engine to use (like for spawning explosions at the right spot)
    public double getX() { return x; }
    public double getY() { return y; }
    public double getWidth() { return width; }
    public double getHeight() { return height; }
}