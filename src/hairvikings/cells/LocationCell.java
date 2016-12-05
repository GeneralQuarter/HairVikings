package hairvikings.cells;

import hairvikings.AbstractPlayer;
import hairvikings.Team;
import hairvikings.graph.Cell;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Created by Quentin Gangler on 25/11/2016.
 *
 */
public class LocationCell  extends Cell{

    private Team team;

    public LocationCell(String cellId) {
        super(cellId);

        double radius = 25;

        team = Team.NEUTRAL;

        Circle view = new Circle(radius);

        view.setStroke(Color.GRAY);
        view.setFill(Color.GRAY);

        view.setCenterX(radius);
        view.setCenterY(radius);

        setView(view);
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public boolean isControlledBy(AbstractPlayer abstractPlayer) {
        return team == abstractPlayer.getTeam();
    }

    public void select() {
        ((Circle) getView()).setStroke(Color.GREEN);
        ((Circle) getView()).setFill(Color.GREEN);
    }

    public void unSelect() {
        ((Circle) getView()).setStroke(Color.GRAY);
        ((Circle) getView()).setFill(Color.GRAY);
    }
}
