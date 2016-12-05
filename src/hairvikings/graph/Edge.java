package hairvikings.graph;

/**
 * Created by t00191774 on 14/11/2016.
 * Made by Roland -> http://stackoverflow.com/questions/30679025/graph-visualisation-like-yfiles-in-javafx
 */
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Edge extends Group {

    protected Cell source;
    protected Cell target;
    protected boolean shown;

    Line line;

    public Edge(Cell source, Cell target) {

        this.source = source;
        this.target = target;

        source.addCellChild(target);
        target.addCellParent(source);

        line = new Line();

        hide();

        line.startXProperty().bind( source.layoutXProperty().add(source.getBoundsInParent().getWidth() / 2.0));
        line.startYProperty().bind( source.layoutYProperty().add(source.getBoundsInParent().getHeight() / 2.0));

        line.endXProperty().bind( target.layoutXProperty().add( target.getBoundsInParent().getWidth() / 2.0));
        line.endYProperty().bind( target.layoutYProperty().add( target.getBoundsInParent().getHeight() / 2.0));

        getChildren().add( line);

    }

    public Cell getSource() {
        return source;
    }

    public Cell getTarget() {
        return target;
    }

    public boolean isShown() {
        return shown;
    }

    public void show() {
        line.setStroke(Color.BLACK);
        shown = true;
    }

    public void hide() {
        line.setStroke(Color.TRANSPARENT);
        shown = false;
    }
}
