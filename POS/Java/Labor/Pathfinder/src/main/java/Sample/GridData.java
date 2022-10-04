package Sample;

public class GridData {

    private int maxX;
    private int maxY;
    private Node[][] nodeMap;
    public static int nodesize = 10;

    public GridData(int maxX, int maxY){
        this.maxX = maxX;
        this.maxY = maxY;
        this.nodeMap = new Node[maxX][maxY];
    }

    public static void setNodesize(int nodesize) {
        GridData.nodesize = nodesize;
    }

    public void fillGrid(){
        for(int x = 0;x<this.maxX;x++){
            for(int y = 0;y<this.maxY;x++){
                this.nodeMap[x][y] = new Node(x,y, Type.EMPTY);
            }
        }
    }
}
