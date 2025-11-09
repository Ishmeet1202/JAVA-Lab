
public class MatrixChainMultiplication {

    public static int tabuMCM(int[] d, int[][] P, int[][] M, int n) {
        for (int i = 0; i < n; i++) {
            M[i][i] = 0;
        }

        for (int diagonal = 1; diagonal < n; diagonal++) {
            for (int i = 0; i < n - diagonal; i++) {
                int j = i + diagonal;
                M[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = M[i][k] + M[k + 1][j] + d[i] * d[k + 1] * d[j + 1];
                    if (cost < M[i][j]) {
                        M[i][j] = cost;
                        P[i][j] = k;
                    }
                }
            }
        }
        return M[0][n - 1];
    }

    public static int memoMCM(int i, int j, int[] d, int[][] M, int[][] P) {
        if (i == j) {
            M[i][j] = 0;
            return 0;
        }

        if (M[i][j] != -1) return M[i][j];

        M[i][j] = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int cost = M[i][k] + M[k + 1][j] + d[i] * d[k + 1] * d[j + 1];
            if (cost < M[i][j]) {
                M[i][j] = cost;
            }
        }

        return M[i][j];
    }

    public static void order(int[][] P, int i, int j) {
        if (i == j) {
            System.out.print((char) ('A' + i));
        } else {
            int k = P[i][j];
            System.out.print('(');
            order(P, i, k);
            order(P, k + 1, j);
            System.out.print(')');
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[] d = {3, 2, 4, 2, 5};
        int[][] M = new int[n][n];
        int[][] P = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                M[i][j] = -1;
                P[i][j] = -1;
            }
        }

        int minMul = tabuMCM(d, P, M, n);
        System.out.println(minMul);
        order(P, 0, 3);

        System.out.println("\nMEMOIZATION");

        int memoResult = memoMCM(0, 3, d, M, P);
        System.out.println(memoResult);
        order(P, 0, 3);
    }
}
