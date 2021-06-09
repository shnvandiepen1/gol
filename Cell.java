public class Cell {
    
    private Location location;
    private boolean alive;    

    public Cell(int x, int y){
        this.location = new Location(x, y);
        this.alive = false;
    }

    public boolean getStatus(){
        return this.alive;
    }

    public Location getLocation(){
        return this.location;
    }
}
