import java.util.ArrayList;

public class Graph {
    public ArrayList<Node> graph;

    public Graph(ArrayList<Node> graph) {
        this.graph = graph;
    }

    public Graph(int size) {
        // create graph with predetermined size
        graph = new ArrayList<Node>();
        for (int i = 0; i < size; i++) {
            graph.add(new Node(i));
        }
    }

    public void addEdge(int u, int v, double weight) {
        graph.get(u).edges.add(new Edge(u, v, weight));
    }

    public void changeEdge(int u, int v, double weight) {
        // not implemented
    }

    public double maxFlow(int s, int t) {
        // not implemented
        return 0;
    }

    // return augmenting path (might make new type Path for this?)
    public String bfs(int startNode, int endNode) {
        // not implemented
        return "";
    }

    public String toString() {
        String str = "";

        for (Node node : graph) {
            str += node.toString();
            str += "\n";
        }

        return str;
    }
}