import java.util.*;

public class Universe {

    private final int WIDTH = 25;
    private final int HEIGHT = 25;
    
    private ArrayList<ArrayList<Cell>> cells;

    public Universe(){
        cells = new ArrayList<ArrayList<Cell>>(25);
        for(int i = 0; i < HEIGHT; i++){
            cells.add(new ArrayList<Cell>());
            for(int j = 0; j < WIDTH; j++){
                cells.get(i).add(new Cell(i, j)); 
            }
        }
    } 

}
