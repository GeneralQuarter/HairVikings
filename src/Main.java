import hairvikings.GameController;
import hairvikings.graph.Graph;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created by t00191774 on 14/11/2016.
 * Made by Roland -> http://stackoverflow.com/questions/30679025/graph-visualisation-like-yfiles-in-javafx
 *
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        GameController gameController = new GameController();

        root.setCenter(gameController.getGraph().getScrollPane());

        Scene scene = new Scene(root, 1024, 768);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();

        gameController.initialize(scene.getWidth(), scene.getHeight());

    }

    public static void main(String[] args) {
        launch(args);
    }
}
