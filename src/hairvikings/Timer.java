package hairvikings;

import hairvikings.cells.LocationCell;
import hairvikings.graph.Cell;
import hairvikings.graph.Graph;

import java.sql.Time;
import java.util.*;

/**
 * Created by antho_000 on 08/12/2016.
 */
public class Timer implements Runnable {

    private List<Cell> cellList = new ArrayList<Cell>();

    public Timer(Graph graph) {
        this.cellList = graph.getModel().getAllCells();
    }

    @Override
    public void run() {
        while(true){
            for(int i = 0; i<cellList.size();i++)
            {
                if((cellList.get(i) instanceof LocationCell))
                {
                    LocationCell cell =(LocationCell)cellList.get(i);
                    if(cell.getProductivity() < 0)
                    {
                        cell.decreaseResources(Math.abs(cell.getProductivity()));
                    }
                }
            }

            try { Thread.sleep(1000); }
            catch(InterruptedException e) {}
        }
    }
}
