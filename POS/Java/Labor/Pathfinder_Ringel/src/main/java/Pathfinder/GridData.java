package Pathfinder;

public class GridData {

    private int maxX;
    private int maxY;
    private Node[][] nodeMap;
    public static int nodesize = 2;

    public GridData(int maxX, int maxY){
        this.maxX = maxX;
        this.maxY = maxY;
        this.nodeMap = new Node[(maxX/nodesize)][(maxY/nodesize)];
    }

    public static void setNodesize(int value) {
        if(value == 0) GridData.nodesize = 1;
        else GridData.nodesize = value;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public void fillGrid(){
        for(int x = 0;x<this.maxX/nodesize;x+=1){
            for(int y = 0;y<this.maxY/nodesize;y+=1){
                System.out.println(new Node(x,y, Type.EMPTY));
                this.nodeMap[x][y] = new Node(x,y, Type.EMPTY);

            }
        }
    }

    public void setNodeMap(int x , int y , Node add) {
        this.nodeMap[x][y] = add;
    }

    public Node getNode(int x , int y ){
        return this.nodeMap[x][y];
    }

    public Node[][] getNodeMap() {
        return nodeMap;
    }

}