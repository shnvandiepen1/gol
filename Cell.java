public class Cell {
    
    private Location location;
    private boolean status;    

    public Cell(int x, int y){
        this.location = new Location(x, y);
        this.status = false;
    }

    public boolean getStatus(){
        return this.status;
    }

    public Location getLocation(){
        return this.location;
    }

    public void changeStatus(boolean newStatus){
        this.status = newStatus;
    }
}
