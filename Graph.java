import java.util.ArrayList;

public class Graph {
    public ArrayList<Node> graph;

    public Graph(ArrayList<Node> graph) {
        this.graph = graph;
    }

    public void addEdge(int u, int v, double weight) {
        graph.get(u).edges.add(new Edge(u, v, weight));
    }

    public void changeEdge(Edge edge, double weight) {
        for (Edge e : graph.get(edge.u).edges) {
            if (e.u == edge.u && e.v == edge.v) {
                edge.weight -= weight;
            }
        }
        graph.get(edge.u).edges.removeIf(e -> e.weight == 0);
    }

    public double maxFlow(int s, int t) {
        double maxFlow = 0;
        Path path;
        while ((path = bfs(s, t)).capacity != Double.POSITIVE_INFINITY) {
            System.out.println(path);
            maxFlow += path.capacity;
            for (Edge e : path.edges) {
                addEdge(e.v, e.u, path.capacity);
                changeEdge(e, path.capacity);
            }
        }
        return maxFlow;
    }

    public Path bfs(int startNode, int endNode) {
        ArrayList<Integer> path = new ArrayList<Integer>();
        ArrayList<Node> queue = new ArrayList<Node>();

        Node s = graph.get(startNode);
        s.visited = true;
        queue.add(s);
        
        while (!queue.isEmpty()) {
            s = queue.remove(0);

            if (s.id == endNode) {
                // found the sink, now trace back to source
                while (s.parent != startNode) {
                    path.add(0, s.id);
                    s = graph.get(s.parent);
                }
                path.add(0, s.id);
                path.add(0, startNode);
            }

            for (Edge e : s.edges) {
                Node n = graph.get(e.v);
                if (!n.visited) {
                    queue.add(n);
                    n.visited = true;
                    n.parent = e.u;
                }
            }
        }

        double newFlow = Double.POSITIVE_INFINITY;
        ArrayList<Edge> pathEdges = new ArrayList<Edge>();
        int i = 0;
        for (Node n : graph) {
            for (Edge e: n.edges) {
                if (i < path.size() - 1 && e.u == path.get(i) && e.v == path.get(i + 1)) {
                    pathEdges.add(e);
                    i++;
                    newFlow = Math.min(e.weight, newFlow);
                }
            }
            n.visited = false;
        }
        return new Path(pathEdges, newFlow);
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