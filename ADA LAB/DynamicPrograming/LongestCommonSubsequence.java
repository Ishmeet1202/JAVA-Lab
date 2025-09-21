
import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequence {

    public static List<int[][]> lcs(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int[][] C = new int[m + 1][n + 1];
        int[][] B = new int[m + 1][n + 1];
        List<int[][]> result = new ArrayList<>();

        for (int i = 0; i <= m; i++) {
            C[i][0] = 0;
        }
        for (int j = 1; j <= n; j++) {
            C[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    C[i][j] = C[i - 1][j - 1] + 1;
                    B[i][j] = 1;
                } else if (C[i - 1][j] >= C[i][j - 1]) {
                    C[i][j] = C[i - 1][j];
                    B[i][j] = -1;
                } else {
                    C[i][j] = C[i][j - 1];
                    B[i][j] = 0;
                }
            }
        }

        for (int[] arr : C) {
            for (int ele : arr) {
                System.out.print(ele+" ");
            }
            System.out.println();
        }
        System.out.println();

        result.add(B);
        result.add(C);

        return result;
    }

    public static void printLCSWithB(int[][] B, String X, int i, int j) {
        if (i == 0 || j == 0) {
            return;
        }

        if (B[i][j] == 1) {
            printLCSWithB(B, X, i - 1, j - 1);
            System.out.print(X.charAt(i - 1));
        } else if (B[i][j] == -1) {
            printLCSWithB(B, X, i - 1, j);
        } else {
            printLCSWithB(B, X, i, j - 1);
        }
    }

    public static void printLCSWithC(int[][] C, String X, String Y, int i, int j) {
        if (i == 0 || j == 0) {
            return;
        }

        if (X.charAt(i - 1) == Y.charAt(j - 1)) {
            printLCSWithC(C, X, Y,i - 1, j - 1);
            System.out.print(X.charAt(i - 1));
        } else if (C[i - 1][j] >= C[i][j - 1]) {
            printLCSWithC(C, X, Y, i - 1, j);
        } else {
            printLCSWithC(C, X, Y, i, j - 1);
        }
    }

    public static void main(String[] args) {
        String X ="ABCBDAB";
        String Y = "BDCABA";
        List<int[][]> ans = lcs(X,Y);

        System.out.print("LCS using length matrix (B): ");
        printLCSWithB(ans.get(0), X, X.length(), Y.length());
        System.out.println();

        System.out.print("LCS using length matrix (C): ");
        printLCSWithC(ans.get(1), X, Y, X.length(), Y.length());
        System.out.println();
    }
}