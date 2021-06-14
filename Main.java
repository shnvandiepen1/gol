import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args){
        Universe universe = new Universe();
        Renderer renderer = new Renderer(universe);

        Location loc1 = new Location(5,5);
        Location loc2 = new Location(6,5);
        Location loc3 = new Location(7,5);
        universe.changeCellStatus(loc1, true);
        universe.changeCellStatus(loc2, true);
        universe.changeCellStatus(loc3, true);

        renderer.drawCells();

        Updater updater = new Updater(universe);
        updater.getUpdates(); //store updates in updater
        updater.applyUpdates(); //give updates to universe

        renderer.updateRenderer(); //give renderer universe (updated)
        renderer.drawCells();
    }

}
