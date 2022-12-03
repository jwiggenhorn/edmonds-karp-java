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

    public void reverseEdge(Edge e) {
        //System.out.println(e);

    }

    public void augmentGraph(Path path) {
        for (int i = path.path.size() - 1; i >= 0; i--) {
            //if (path.path.get(i).id != path.path.get(i).parent) {
                //System.out.println(path.path.get(i).id + " " + path.path.get(i).parent);
                for (Edge e : path.path.get(i).edges) {
                    System.out.println(e);
                }
                
            //}
        }

        // for (Node n : path.path) {
        //     System.out.println(n.id);
        //     System.out.println(n.edges);
        //     for (Edge e : n.edges) {
        //         // System.out.println(e.u + " " + e.v);
        //         if (e.weight == n.key)
        //             reverseEdge(e);
        //     }
        // }
    }

    public double maxFlow(int s, int t) {
        double flow = 0, newFlow = 0;

        Path path = bfs(s, t);
        // while (path.capacity != 0) {
            newFlow = path.capacity;
            flow += newFlow;
            augmentGraph(path);
            //path = bfs(s, t);
        // }

        System.out.println(path);
        return flow;
    }

    public Path bfs(int startNode, int endNode) {
        ArrayList<Node> path = new ArrayList<Node>();
        ArrayList<Node> queue = new ArrayList<Node>();
        double newFlow = Double.POSITIVE_INFINITY;

        Node s = graph.get(startNode);
        s.visited = true;
        queue.add(s);
        
        while (!queue.isEmpty()) {
            s = queue.remove(0);
            
            if (s.id == endNode) {
                path.add(0, s);
                while (s.parent != startNode) {
                    s = graph.get(s.parent);
                    path.add(0, s);
                }
                path.add(0, graph.get(startNode));
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