import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Player extends GameObject {
    private double ySpeed = 0;
    private boolean onGround = false;

    public Player() {
        // Constructor matches GameObject: x, y, width, height, speed
        super(100, Config.GROUND_Y - 60, 40, 60, 0); 
    }

    public void applyGravity() {
        if (!onGround) {
            ySpeed += Config.GRAVITY; 
            y += ySpeed; // Directly update the y variable inherited from GameObject

            // Floor Collision Check
            if (y >= Config.GROUND_Y - 60) {
                y = Config.GROUND_Y - 60;
                ySpeed = 0;
                onGround = true;
            }
        }
    }

    public void jump() {
        if (onGround) {
            ySpeed = Config.JUMP_FORCE;
            onGround = false;
        }
    }

    @Override
    public void update() {
        applyGravity();
    }

    @Override
    public void draw(GraphicsContext gc) {
        // Draw Knight Body directly using x, y, width, and height
        gc.setFill(Color.SILVER);
        gc.fillRect(x, y, width, height);

        // Helmet/Visor
        gc.setFill(Color.DARKSLATEGRAY);
        gc.fillRect(x + 5, y + 5, width - 10, 15);

        // Plumage/Feather
        gc.setFill(Color.RED);
        gc.fillOval(x + 10, y - 10, 20, 20);
    }
}