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
    private int resources;
    private int productivity;


    public LocationCell(String cellId) {
        super(cellId);

        //temporary default initialisation
        resources = 50;
        productivity = 5;

        team = Team.NEUTRAL;

        //This should be an image rather than a circle.
        double radius = 25;

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

    public void decreaseResources(int amount){
        this.resources -= amount;
        if(this.resources <= 0)
        {
            //change the team;
        }
    }

    public void decreaseProductivity(int amount){
        this.productivity -=amount;
        if(this.productivity < 0)
        {
            //decrease resources
        }
        else if(this.productivity > 0)
        {
            //increase resources
        }

    }


}
