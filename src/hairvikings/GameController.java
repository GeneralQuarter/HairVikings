package hairvikings;

import hairvikings.cells.LocationCell;
import hairvikings.graph.*;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import hairvikings.layout.FixedLayout;
import hairvikings.layout.Layout;

/**
 * Created by Quentin Gangler on 25/11/2016.
 *
 */
public class GameController {

    private Graph graph;
    private LocationCell firstCellClicked;
    private LocationCell secondCellClicked;

    private AbstractPlayer player;
    private AbstractPlayer enemy;

    public GameController() {
        graph = new Graph();
        player = new AbstractPlayer(Team.HAIRY);
        enemy = new AbstractPlayer(Team.BOLD);
    }

    public Graph getGraph() {
        return graph;
    }

    public void initialize(double width, double height) {

        addGraphComponents();

        clickCellEventHandlerInitialize();

        Layout layout = new FixedLayout(graph, width, height);
        layout.execute();
    }

    private void clickCellEventHandlerInitialize() {
        EventHandler<MouseEvent> mouseEventEventHandler = event -> {
            if (event.getSource() instanceof Cell) {
                LocationCell cellClicked = (LocationCell) event.getSource();
                if (firstCellClicked == null && cellClicked.isControlledBy(player)) {
                    firstCellClicked = cellClicked;
                } else {
                    secondCellClicked = cellClicked;
                    linkSelectionCells();
                }
            }
        };

        for (Cell cell : getGraph().getModel().getAllCells()) {
            cell.setOnMouseClicked(mouseEventEventHandler);
        }
    }

    private void linkSelectionCells() {
        if (firstCellClicked != null && secondCellClicked != null && !firstCellClicked.getCellId().equals(secondCellClicked.getCellId())) {
            Edge edge = getGraph().getModel().getEdge(firstCellClicked, secondCellClicked);
            if (edge != null) {
               edge.show();
               secondCellClicked.setTeam(player.getTeam());
            }
        }
        clearSelectionCells();
    }

    private void clearSelectionCells() {
        firstCellClicked = null;
        secondCellClicked = null;
    }

    private void addGraphComponents() {

        Model model = graph.getModel();

        graph.beginUpdate();

        LocationCell playerCell = new LocationCell("Player");
        playerCell.setTeam(Team.HAIRY);

        LocationCell enemyCell = new LocationCell("Enemy");
        enemyCell.setTeam(Team.BOLD);

        model.addCell(playerCell);
        model.addCell(enemyCell);

        model.addCell("Neutral 1", CellType.LOCATION);
        model.addCell("Neutral 2", CellType.LOCATION);
        model.addCell("Neutral 3", CellType.LOCATION);
        model.addCell("Neutral 4", CellType.LOCATION);
        model.addCell("Neutral 5", CellType.LOCATION);

        model.addEdge("Player", "Neutral 1");
        model.addEdge("Player", "Neutral 2");
        model.addEdge("Player", "Neutral 3");

        model.addEdge("Neutral 1", "Neutral 3");
        model.addEdge("Neutral 1", "Neutral 4");
        model.addEdge("Neutral 2", "Neutral 3");
        model.addEdge("Neutral 2", "Neutral 5");
        model.addEdge("Neutral 3", "Neutral 4");
        model.addEdge("Neutral 3", "Enemy");
        model.addEdge("Neutral 3", "Neutral 5");

        model.addEdge("Neutral 4", "Enemy");
        model.addEdge("Neutral 5", "Enemy");

        graph.endUpdate();

    }


}
