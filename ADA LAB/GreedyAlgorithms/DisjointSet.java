public class DisjointSet {
    int[] set;

    public DisjointSet(int size) {
        this.set = new int[size];
        for (int i = 0; i < set.length; i++) {
            set[i] = i;
        }
    }

    public int find(int u) {
        if (u == set[u]) {
            return u;
        }

        return find(set[u]);
    }

    public void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        if (rootU == rootV)
            return;

        if (rootU > rootV) {
            set[rootU] = rootV;
        } else {
            set[rootV] = rootU;
        }
    }

    public boolean equal(int u, int v) {
        return find(u) == find(v);
    }
}