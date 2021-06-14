public class Updater {

    private Universe universe;
    private int SIZE;
    private boolean[][] nextUpdate;

    public Updater(Universe inputUniverse){
        this.universe = inputUniverse;
        this.SIZE = universe.getWidthAndHeight(); 
        this.nextUpdate = new boolean[SIZE][SIZE];
    }

    public void tick(){

    }

    public void getUpdates(){
        for(int i = 0; i < this.SIZE; i++){
            for(int j = 0; j < this.SIZE; j++){
                Location loopLocation = new Location(i, j);
                if(universe.isAliveNR(loopLocation)){
                    nextUpdate[i][j] = true;
                } else {
                    nextUpdate[i][j] = false;
                }
            }
        }
    }

}
