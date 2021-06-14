public class Renderer {

    private boolean[][] cells;
    private Universe universe;

    public Renderer(Universe universe){
        this.universe = universe;
        this.updateRenderer();
    }

    public void updateRenderer(){
        this.cells = universe.getStatusArray();
    }

    public void drawCells(){
        for(int i = 0; i < 25; i++){
            System.out.println();
            for(int j = 0; j < 25; j++){
                if(this.cells[i][j]){
                    System.out.print(" 1 ");
                } else {
                    System.out.print(" - ");
                }
            }
        }
    }

}
