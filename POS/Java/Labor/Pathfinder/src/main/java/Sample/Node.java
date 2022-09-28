package Sample;

import java.util.ArrayList;

public class Node {

    private int x;
    private int y;
    private Node[] adjacent;
    private boolean isCover;
    public static Node[][] nodeMap = new Node[100][100];


    public Node(int x, int y,Node[] adjacent, boolean isCover){
        this.x = x;
        this.y = y;
        this.adjacent = adjacent;
        this.isCover = isCover;
        addtoMap();
    }
    public  void addtoMap(){
        nodeMap[this.x][this.y] = this;
    }



}
