
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloydWarshall {

    public static List<int[][]> floydWarshall(int[][] W, int n) {
        int[][] D = new int[W.length][];
        int[][] P = new int[n][n];

        for (int i = 0; i < W.length; i++) {
            D[i] = Arrays.copyOf(W[i], W[i].length);
        }

        for (int[] P1 : P) {
            for (int j = 0; j < P1.length; j++) {
                P1[j] = -1;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (D[i][k] != Integer.MAX_VALUE && D[k][j] != Integer.MAX_VALUE && D[i][j] > D[i][k] + D[k][j]) {
                        D[i][j] = D[i][k] + D[k][j];
                        P[i][j] = k;
                    }
                }
            }
            printMatrix(D);
            System.out.println();
            printMatrix(P);
            System.out.println();
        }

        List<int[][]> result = new ArrayList<>();
        result.add(D);
        result.add(P);

        return result;
    }

    public static void printPath(int q, int r, int[][] P) {
        System.out.print(q + " -> ");
        path(q, r, P);
        System.out.print(r);
    }

    public static void path(int q, int r, int[][] P) {
        if (P[q][r] != -1) {
            path(q, P[q][r], P);
            System.out.print(P[q][r] + " -> ");
            path(P[q][r], r, P);
        }
    }

    public static void printMatrix(int[][] arr) {
        for (int[] arr1 : arr) {
            for (int ele : arr1) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] W = {
            {0, 1, 6, 5},
            {2, 0, 2, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, 1, 0, 1},
            {3, Integer.MAX_VALUE, Integer.MAX_VALUE, 0}
        };
        int n = 4;

        List<int[][]> result = floydWarshall(W, n);
        int[][] P = result.get(1);

        printPath(0, 3, P);
    }
}
