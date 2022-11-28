public class Edge implements Comparable<Edge> {
    public int u;
    public int v;
    public double weight;

    public Edge(int u, int v, double weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge that) {
        return Double.compare(this.weight, that.weight);
    }

    public String toString() {
        String str = "";

        str += v + " " + weight + " ";
        
        return str;
    }
}