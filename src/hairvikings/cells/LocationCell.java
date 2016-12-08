package hairvikings.cells;

import hairvikings.AbstractPlayer;
import hairvikings.Team;
import hairvikings.Level;
import hairvikings.graph.Cell;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Created by Quentin Gangler on 25/11/2016.
 *
 */
public class LocationCell  extends Cell{

    private int resources;
    private Team team;
    private Level level;
    private  ImageView imageView;
    private Label labelResources;

    public LocationCell(String cellId) {
        super(cellId);

        team = Team.NEUTRAL;

        resources = 0;//(int) (Math.random() * 151); for testing : display of cell resources
        level = Level.getLevelFromResources(resources);

        imageView = new ImageView(new Image(level.getImagePATH()));
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);

        labelResources = new Label(resources + "");
        labelResources.setTextFill(Color.CORAL);
        StackPane view = new StackPane();
        view.getChildren().addAll(imageView, labelResources);


        /*view.setStroke(Color.GRAY);
        view.setFill(Color.GRAY);

        view.setCenterX(radius);
        view.setCenterY(radius);
*/
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
        labelResources.setTextFill(Color.MEDIUMORCHID);
       /* ((Circle) getView()).setStroke(Color.GREEN);
        ((Circle) getView()).setFill(Color.GREEN);*/
    }

    public void unSelect() {
        labelResources.setTextFill(Color.CORAL);
       /* ((Circle) getView()).setStroke(Color.GRAY);
        ((Circle) getView()).setFill(Color.GRAY);*/
    }

    public void update(){
        updateCellView();
    }

    private void updateCellView(){
        level = Level.getLevelFromResources(resources);
        imageView.setImage(new Image(level.getImagePATH()));
        labelResources.setText(resources + "");
    }

    public void setResources(int resources){
        this.resources = resources;
        update();
    }
}
