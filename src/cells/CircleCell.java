package cells;

import graph.Cell;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Created by t00191774 on 14/11/2016.
 *
 * *
 */
public class CircleCell extends Cell{

    public CircleCell(String id) {
        super(id);

        double radius = 25;

        Circle view = new Circle(radius);

        view.setStroke(Color.GRAY);
        view.setFill(Color.GRAY);

        view.setCenterX(radius);
        view.setCenterY(radius);

        setView(view);
    }
}
