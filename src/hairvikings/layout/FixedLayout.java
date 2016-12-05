package hairvikings.layout;

import hairvikings.graph.Edge;
import hairvikings.graph.Graph;
import hairvikings.graph.Model;

/**
 * Created by Quentin Gangler on 25/11/2016.
 *
 */
public class FixedLayout extends Layout{

    private Graph graph;
    private double width;
    private double height;

    public FixedLayout(Graph graph, double width, double height) {
        this.graph = graph;
        this.width = width;
        this.height = height;
    }

    @Override
    public void execute() {
        double cutWidth = (width / 6) - 10;
        double cutHeight = (height / 4) - 10;

        Model model = graph.getModel();

        model.getCell("Player").relocate(cutWidth, cutHeight*2);
        model.getCell("Enemy").relocate(cutWidth * 5, cutHeight*2);
        model.getCell("Neutral 1").relocate(cutWidth * 2, cutHeight);
        model.getCell("Neutral 2").relocate(cutWidth * 2, cutHeight * 3);
        model.getCell("Neutral 3").relocate(cutWidth * 3, cutHeight * 2);
        model.getCell("Neutral 4").relocate(cutWidth * 4, cutHeight);
        model.getCell("Neutral 5").relocate(cutWidth * 4, cutHeight * 3);
    }

}
