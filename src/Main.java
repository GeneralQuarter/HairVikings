import graph.CellType;
import graph.Graph;
import graph.Model;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import layout.Layout;
import layout.RandomLayout;

/**
 * Created by t00191774 on 14/11/2016.
 * Made by Roland -> http://stackoverflow.com/questions/30679025/graph-visualisation-like-yfiles-in-javafx
 *
 */
public class Main extends Application {

    Graph graph = new Graph();

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        graph = new Graph();

        root.setCenter(graph.getScrollPane());

        Scene scene = new Scene(root, 1024, 768);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();

        addGraphComponents();

        Layout layout = new RandomLayout(graph);
        layout.execute();

    }

    private void addGraphComponents() {

        Model model = graph.getModel();

        graph.beginUpdate();

        model.addCell("Enemy", CellType.TRIANGLE);
        model.addCell("Player", CellType.RECTANGLE);
        model.addCell("Neutral 1", CellType.CIRCLE);
        model.addCell("Neutral 2", CellType.CIRCLE);
        model.addCell("Neutral 3", CellType.CIRCLE);
        model.addCell("Neutral 4", CellType.CIRCLE);
        model.addCell("Neutral 5", CellType.CIRCLE);

        model.addEdge("Player", "Neutral 1");
        model.addEdge("Player", "Neutral 2");
        model.addEdge("Player", "Neutral 3");
        model.addEdge("Neutral 1", "Neutral 3");
        model.addEdge("Neutral 2", "Neutral 3");
        model.addEdge("Neutral 1", "Neutral 4");
        model.addEdge("Neutral 2", "Neutral 5");
        model.addEdge("Neutral 3", "Neutral 4");
        model.addEdge("Neutral 3", "Enemy");
        model.addEdge("Neutral 3", "Neutral 5");

        graph.endUpdate();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
