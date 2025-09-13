import java.util.Arrays;

public class PrintAllMST {

    static int treeCount = 0;

    public static void printAllMST(Edge[] E, int k, int kk, DisjointSet s, Edge[] F, int n, int m, int minLength) {
        if (k == n - 1 && getLength(F) == minLength) {
            print(F, ++treeCount);
        } else {
            boolean flag = true;

            while (flag) {
                kk++;
                if (kk >= m) {
                    break;
                }

                int currentLength = E[kk].cost;

                while (kk < m && E[kk].cost == currentLength) {
                    int u = E[kk].u;
                    int v = E[kk].v;

                    if (!s.equal(u, v)) {
                        flag = false;
                        DisjointSet ss = new DisjointSet(s);
                        Edge[] FF = Arrays.copyOf(F, F.length);
                        FF[k] = E[kk];
                        ss.union(u, v);
                        printAllMST(E, k + 1, kk, ss, FF, n, m, minLength);
                    }

                    kk++;
                }

                if (flag) {
                    kk--;
                }
            }
        }
    }

    public static int getLength(Edge[] F) {
        int weight = 0;

        for (Edge edge : F) {
            weight += edge.cost;
        }

        return weight;
    }

    public static void print(Edge[] F, int count) {
        System.out.println("\nMinimum spanning tree "+count+": ");
        for (Edge edge : F) {
            System.out.println(edge);
        }
    }

    public static void main(String[] args) {

        Edge[] E = {
            new Edge(0, 1, 1),
            new Edge(0, 2, 2),
            new Edge(1, 2, 2),
            new Edge(2, 3, 3),
            new Edge(1, 3, 4)
        };

        int n = 4;
        int m = E.length;

        Arrays.sort(E);

        int minLen = KruskalAlgo.kruskal(E, n);
        System.out.println("Total weight of Minimum Spanning Tree = " + minLen);

        DisjointSet s = new DisjointSet(n);
        Edge[] F = new Edge[n - 1];

        printAllMST(E, 0, -1, s, F, n, m, minLen);
    }
}
