package Pathfinder;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Node {

    private int x;
    private int y;
    private List<Node> neighbours;
    private Type type;



    public Node(int x, int y, Type type){
        this.x = x;
        this.y = y;
        this.type = type;
        this.neighbours = new LinkedList<>();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setNeighbours(List<Node> neighbours) {
        this.neighbours = neighbours;
    }

    public List<Node> getNeighbours() {
        return neighbours;
    }

    public int getY() {
        return y;
    }

    public Type getType() {
        return type;
    }
    public void addNeighbour(Node add){
        this.neighbours.add(add);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return x == node.x && y == node.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +
                ", y=" + y +
                ", type=" + type +
                '}';
    }
}
