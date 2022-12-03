import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class EdmondsKarp {
    public static void main(String[] args) {
        try { 
            String inputFilename = args.length > 0 ? args[0] : "Project3Graph1.txt";
            Graph g = readGraph(inputFilename);
            double maxFlow = g.maxFlow(0, g.graph.size() - 1);
            System.out.println("The max flow is " + maxFlow); 
        } catch (FileNotFoundException e) { 
            System.err.println(e.getMessage()); 
        }
    }

    public static Graph readGraph(String filename) throws FileNotFoundException {
        try (Scanner fileInput = new Scanner(new File(filename))) {
            ArrayList<Node> nodes = new ArrayList<Node>();

            String[] tokens;
            int id, v;
            double edgeWeight;
            ArrayList<Edge> edges;

            while (fileInput.hasNextLine()) {
                String line = fileInput.nextLine();
                tokens = line.split(" ");

                id = Integer.parseInt(tokens[0]);

                edges = new ArrayList<Edge>();
                for (int i = 1; i < tokens.length; i+=2) {
                    v = Integer.parseInt(tokens[i]);
                    edgeWeight = Double.parseDouble(tokens[i+1]);
                    edges.add(new Edge(id, v, edgeWeight));
                }
                nodes.add(new Node(id, edges));
            }
            return new Graph(nodes);
        }
    }
}