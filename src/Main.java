import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);   // THIS LINE IS REQUIRED
    }

    @Override
    public void start(Stage primaryStage) {

        Game game = new Game();

        Scene scene = new Scene(game.getRoot(), 800, 600);

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == javafx.scene.input.KeyCode.SPACE) {
                game.getPlayer().jump();
            }
        });

        primaryStage.setTitle("Knight Runner");
        primaryStage.setScene(scene);
        primaryStage.show();

        game.startGame();
    }
}
