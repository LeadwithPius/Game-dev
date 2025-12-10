import javafx.scene.image.image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.color;
import javafx.scene.layout.Pane;

public class Player extends GameObject{
    private double yspeed = 0;
    private boolean onground = true;
    private boolean isjumping = false;

    public void applyGravity(){
        if(!onground){
            yspeed += 0.98; // gravity acceleration
            setY(getY() + yspeed);
        }
    }
    public void jump(){
        if(onground){
            yspeed = -15; // jump strength
            onground = false;
            isjumping = true;
        }
    }

    @Override
    public void draw(GraphicsContext gc) {
        // Draw Knight Body
        gc.setFill(Color.SILVER);
        gc.fillRect(x, y, width, height);

        // Helmet/Visor
        gc.setFill(Color.DARKSLATEGRAY);
        gc.fillRect(x + 5, y + 5, width - 10, 15);

        // Plumage/Feather
        gc.setFill(Color.RED);
        gc.fillOval(x + 10, y - 10, 20, 20);

        // Shield
        gc.setFill(Color.BLUE);
        gc.fillOval(x + width - 15, y + 20, 20, 25);
    }

}