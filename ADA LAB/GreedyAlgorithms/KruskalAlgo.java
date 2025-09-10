import java.util.*;

public class KruskalAlgo {

    static int kruskal(Edge[] edges, int n) {
        int minCost = 0;
        int edgeCount = 0;
        int edgeNo = 0;
        DisjointSet ds = new DisjointSet(n);

        while (edgeCount < (n - 1) && edgeNo < edges.length) {
            Edge edge = edges[edgeNo];
            int u = edge.u;
            int v = edge.v;
            int cost = edge.cost;

            if (!ds.equal(u, v)) {
                minCost += cost;
                edgeCount++;
                ds.union(u, v);
                System.out.println(edge);
            }
            edgeNo++;
        }

        if (edgeCount != (n - 1)) {
            return -1;
        }

        return minCost;
    }

    public static void main(String[] args) {
        Edge[] edges = {
            new Edge(0, 1, 10),
            new Edge(0, 2, 6),
            new Edge(0, 3, 5),
            new Edge(2, 3, 4),
            new Edge(1, 3, 15)
        };

        Arrays.sort(edges);

        int n = 5;

        int minCost = kruskal(edges, n);
        System.out.println("Total minCost: "+minCost);
    }
}

class Edge implements Comparable<Edge> {
    int u;
    int v;
    int cost;

    public Edge(int u, int v, int cost) {
        this.u = u;
        this.v = v;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }

    @Override
    public String toString() {
        return "Edge ["+u+","+v+"] with cost: "+cost;
    }
}