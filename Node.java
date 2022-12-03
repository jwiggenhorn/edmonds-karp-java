import java.util.ArrayList;

public class Node {
    public int id;
    public ArrayList<Edge> edges;
    public int parent;
    public boolean visited;
    
    public Node(int id, ArrayList<Edge> edges) {
        this.id = id; 
        this.edges = edges;
    }

    public Node(int id) {
        this.id = id; 
        this.edges = new ArrayList<Edge>();
    }

    public String toString() {
        String str = id + ": \n";        
        for (Edge edge : edges) {
            str += edge.toString() + " (" + edge.weight + ") \n";
        }
        return str;
    }
}