import java.util.ArrayList;
public class Node implements Comparable<Node> {
    public int id; // index
    public ArrayList<Edge> edges;
    public double key; 
    public int parent;
    public boolean visited;
    
    public Node(int id, ArrayList<Edge> edges) {
        this.id = id; 
        this.edges = edges;
    }

    public Node(int id, double key) {
        this.id = id;
        this.key = key;
    }

    public Node(int id) {
        this.id = id; 
        this.edges = new ArrayList<Edge>();
    }

    @Override
    public int compareTo(Node that) {
        return Double.compare(this.key, that.key);
    }

    public String toString() {
        String str = "";

        str += id + " ";
        
        for (Edge edge : edges) {
            str += edge.toString();
        }
        
        return str;
    }
}