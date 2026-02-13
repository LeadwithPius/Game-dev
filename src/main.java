import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class Main extends Application{
    @Override
    public void start(Stage primaryStage) {
        Game game = new Game();
        Scene scene = new Scene(game.getRoot(), 800, 600);
        
        primaryStage.setTitle("Knight Runner");
        primaryStage.setScene(scene);
        primaryStage.show();

        game.startGame();
    }

    public static void main(String[] args) {
        launch(args);
    }
}