import java.util.ArrayList;

public class Path {
    public ArrayList<Edge> edges;
    public double capacity;

    public Path(ArrayList<Edge> edges, double capacity) {
        this.edges = edges;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        String str = "The augmenting path is ";
        for (Edge e : edges) {
            str += e + ", ";
        }
        str += "capacity = " + capacity;
        return str;
    }
}
