import java.util.Arrays;

public class Updater {

    private Universe universe;
    private int SIZE;
    private boolean[][] nextUpdate;

    public Updater(Universe inputUniverse){
        this.universe = inputUniverse;
        this.SIZE = universe.getWidthAndHeight(); 
        this.nextUpdate = new boolean[SIZE][SIZE];
    }

    public void applyUpdates(){
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                Location loopLocation = new Location(i, j);
                universe.changeCellStatus(loopLocation, nextUpdate[i][j]);
            }
        }
    }

    public void tick(){

    }

    public void getUpdates(){
        for(int i = 0; i < this.SIZE; i++){
            for(int j = 0; j < this.SIZE; j++){
                Location loopLocation = new Location(i, j);
                nextUpdate[i][j] = universe.isAliveNR(loopLocation);
            }
        }
    }

    public boolean[][] getUpdatesArray(){
        return this.nextUpdate;
    }

}
