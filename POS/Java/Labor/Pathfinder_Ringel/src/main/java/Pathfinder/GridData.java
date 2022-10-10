package Pathfinder;

import java.util.LinkedList;
import java.util.List;

public class GridData {

    private int maxX;
    private int maxY;
    private Node[][] nodeMap;
    private static List<Node> allNodes = new LinkedList<>();
    public static int nodesize = 5;

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
        allNodes.clear();
        for(int x = 0;x<this.maxX/nodesize;x+=1){
            for(int y = 0;y<this.maxY/nodesize;y+=1){
                System.out.println(new Node(x,y, Type.EMPTY));
                this.nodeMap[x][y] = new Node(x,y, Type.EMPTY);
                allNodes.add(new Node(x,y,Type.EMPTY));

            }
        }
        fillNeigbhours();
        System.out.println(nodeMap.length);
    }
    public void fillNeigbhours(){
        System.out.println(allNodes);
        for(Node nodi : allNodes) {
            LinkedList<Node> toadd = new LinkedList<>();
            for (int x = -1; x <= 1; x++) {
                for (int y = -1; y <= 1; y++) {
                    if (nodi.getX() + x < 0 || nodi.getY() + y < 0) continue;
                    if (nodi.getX() + x >= nodeMap.length || nodi.getY() + y >= nodeMap[nodi.getX()].length) continue;
                    if (nodi.getX() + x == nodi.getX() && nodi.getY() + y == nodi.getY()) continue;
                    else {

                        System.out.println("node added to " + nodi);
                        toadd.add(nodeMap[nodi.getX() + x][nodi.getY() + y]);
                    }


                }
            }
            nodeMap[nodi.getX()][nodi.getY()].setNeighbours(toadd);
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