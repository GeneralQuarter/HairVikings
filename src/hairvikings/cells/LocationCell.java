package hairvikings.cells;

import hairvikings.AbstractPlayer;
import hairvikings.Team;
import hairvikings.graph.Cell;
import javafx.geometry.Insets;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;


import java.util.List;

/**
 * Created by Quentin Gangler on 25/11/2016.
 *
 */
public class LocationCell extends Cell{

    private Team team;
    private int resources;
    private int productivity;




    public LocationCell(String cellId) {
        super(cellId);

        //temporary default initialisation
        resources = 50;
        productivity = 2;

        team = Team.NEUTRAL;

        //This should be an image rather than a circle.
        double radius = 25;

        Circle view = new Circle(radius);

        view.setStroke(Color.GRAY);
        view.setFill(Color.GRAY);

        view.setCenterX(radius);
        view.setCenterY(radius);

        setView(view);

        displayResourcesAndProductivityOnConsole();

    }



     private void displayResourcesAndProductivityOnConsole(){
         System.out.println(this.getCellId() +" R = "+resources);
         System.out.println(this.getCellId() +" P = "+productivity);

         System.out.println("\n");
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



    public void removeResourcesToEnemyChild(String cellID ,int amount){

        List<Cell> allChildren = this.getCellChildren();
        LocationCell enemyChild = null;

        for(int i= 0; i < allChildren.size();i++)
        {
            if(allChildren.get(i) instanceof LocationCell)
            {
                LocationCell child = (LocationCell)allChildren.get(i);

                if(child.getCellId().equals(cellID))
                {
                    enemyChild = child;
                    enemyChild.decreaseResources(amount);
                }
            }
        }
    }


    public void removeProductivityToEnemyChild(String cellID, int amount){
        List<Cell> allChildren = this.getCellChildren();
        LocationCell enemyChild = null;

        for(int i= 0; i < allChildren.size();i++)
        {
            if(allChildren.get(i) instanceof LocationCell)
            {
                LocationCell child = (LocationCell)allChildren.get(i);

                if(child.getCellId().equals(cellID))
                {
                    enemyChild = child;
                    enemyChild.decreaseProductivity(amount);
                }
            }
        }
    }



    public void decreaseResources(int amount/*, LocationCell cellCauseDecrease */){
        this.resources -= amount;
        if(this.resources <= 0)
        {

            //This is the UC18
            System.out.println("cell change of team");
            this.resources = 50;

        }

        displayResourcesAndProductivityOnConsole();
    }

    public void decreaseProductivity(int amount){
        this.productivity -=amount;

        displayResourcesAndProductivityOnConsole();

    }

    public int getResources() {
        return resources;
    }

    public void setResources(int resources) {
        this.resources = resources;
    }

    public int getProductivity() {
        return productivity;
    }

    public void setProductivity(int productivity) {
        this.productivity = productivity;
    }
}
