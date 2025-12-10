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

}