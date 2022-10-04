package Sample;

public class Node {

    private int x;
    private int y;
    private Type type;



    public Node(int x, int y, Type type){
        this.x = x;
        this.y = y;
        this.type = type;
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

    public int getY() {
        return y;
    }

    public Type getType() {
        return type;
    }
}
