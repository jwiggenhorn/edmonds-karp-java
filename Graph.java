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
        double flow, newFlow = 0;

        Path path = bfs(s, t);
        // while (path.capacity != 0) {

        // }

        System.out.println("The augmenting path is " + path.path + " capacity = " + path.capacity);
        return 0;
    }

    public Path bfs(int startNode, int endNode) {
        ArrayList<Integer> path = new ArrayList<Integer>();
        ArrayList<Node> queue = new ArrayList<Node>();
        double newFlow = Double.POSITIVE_INFINITY;

        Node s = graph.get(startNode);
        s.visited = true;
        queue.add(s);
        
        while (queue.size() != 0) {
            s = queue.remove(0);
            
            if (s.id == endNode) {
                path.add(0, s.id);
                while (s.parent != startNode) {
                    path.add(0, s.parent);
                    s = graph.get(s.parent);
                }
                path.add(0, startNode);
            }

            for (Edge e : s.edges) {
                Node n = graph.get(e.v);
                if (!n.visited) {
                    n.visited = true;
                    n.parent = e.u;
                    queue.add(n);
                    // might need to fix this next line
                    newFlow = Math.min(e.weight, newFlow);
                }

            }
        }
        return new Path(path, newFlow);
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