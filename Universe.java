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

    public boolean[][] getStatusArray(){
        boolean[][] result = new boolean[WIDTH][HEIGHT];
        for(int i = 0; i < WIDTH; i++){
            for(int j = 0; j < HEIGHT; j++){
                Location loopLocation = new Location(i, j);
                result[i][j] = this.getCell(loopLocation).getStatus();
            }
        }
        return result;
    }

    /**
     * @param location location of cell to be checked
     * @return if the given cell location should be alive next round
     */
    public boolean isAliveNR(Location location){
        ArrayList<Cell> currentNeighbors = getNeighbors(location);
        int aliveCellCount = 0;
        boolean currentCellStatus = getCell(location).getStatus();
        for(Cell cell : currentNeighbors){
            if(cell.getStatus()) aliveCellCount++; 
        }
        if(!currentCellStatus && aliveCellCount == 3) return true;
        if(currentCellStatus && (aliveCellCount == 2 || aliveCellCount == 3)) return true;
        return false;
    }

    public void changeCellStatus(Location location, boolean newStatus){
        this.cells.get(location.getX()).get(location.getY()).changeStatus(newStatus);
    }

    public Cell getCell(Location location){
        return this.cells.get(location.getX()).get(location.getY());
    }

    public ArrayList<Cell> getNeighbors(Location location) {
        int col = location.getX();
        int row = location.getY();
        ArrayList<Cell> neighbors = new ArrayList<Cell>();

        //find all surrounding cell by adding +/- 1 to col and row 
        for (int colNum = col - 1 ; colNum <= (col + 1) ; colNum +=1  ) {
            for (int rowNum = row - 1 ; rowNum <= (row + 1) ; rowNum +=1  ) {
                //if not the center cell 
                if(! ((colNum == col) && (rowNum == row))) {
                    //make sure it is within  grid
                    if(withinGrid (colNum, rowNum)) {
                        Location neighborsLocation = new Location(colNum, rowNum);
                        Cell neighborRef = this.getCell(neighborsLocation);
                        neighbors.add(neighborRef);
                    }
                }
            }
        }
        return neighbors;
    }

    private boolean withinGrid(int x, int y) {
        if((x < 0) || (y < 0) ) {
            return false;    //false if row or col are negative
        }
        if((x >= WIDTH) || (y >= HEIGHT)) {
            return false;    //false if row or col are > 75
        }
        return true;
    }

    public int getWidthAndHeight(){
        return this.WIDTH;
    }

}
