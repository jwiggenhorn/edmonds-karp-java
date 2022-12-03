import java.util.ArrayList;

public class Path {
    public ArrayList<Node> path;
    public double capacity;

    public Path(ArrayList<Node> path, double capacity) {
        this.path = path;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        String str = "The augmenting path is ";
        for (Node n : path) {
            str += n.id + ", ";
        }
        str += "capacity = " + capacity;
        return str;
    }
}
