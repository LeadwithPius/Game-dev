import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Player extends GameObject {
    private double ySpeed = 0;
    private boolean onGround = false;

    public Player() {
        // We pass "null" or a dummy path because we are custom drawing, not using an image
        super("", 40, 60, 0); 
        this.sprite.setLayoutX(100); // Starting X position
        this.sprite.setLayoutY(Config.GROUND_Y - 60); // Start on the ground
    }

    public void applyGravity() {
        if (!onGround) {
            ySpeed += Config.GRAVITY; // Use your config value
            double newY = sprite.getLayoutY() + ySpeed;
            
            // Floor Collision Check
            if (newY >= Config.GROUND_Y - 60) {
                newY = Config.GROUND_Y - 60;
                ySpeed = 0;
                onGround = true;
            }
            sprite.setLayoutY(newY);
        }
    }

    public void jump() {
        if (onGround) {
            ySpeed = Config.JUMP_FORCE; // Use your config value
            onGround = false;
        }
    }

    @Override
    public void update() {
        applyGravity(); // Handle physics every frame
    }

    // Since Background and Particles use the Canvas, we keep this draw method
    public void draw(GraphicsContext gc) {
        double x = sprite.getLayoutX();
        double y = sprite.getLayoutY();
        double width = 40;
        double height = 60;

        gc.setFill(Color.SILVER);
        gc.fillRect(x, y, width, height);

        gc.setFill(Color.DARKSLATEGRAY);
        gc.fillRect(x + 5, y + 5, width - 10, 15);

        gc.setFill(Color.RED);
        gc.fillOval(x + 10, y - 10, 20, 20);
    }
}