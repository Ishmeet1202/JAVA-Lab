
import java.util.Arrays;

public class BinomialCoefficient {

    public static int binomialCoefficient1(int n, int r) {
        if (r == 0 || n == r) {
            return 1;
        }

        return binomialCoefficient1(n - 1, r - 1) + binomialCoefficient1(n - 1, r);
    }

    public static int binomialCoefficient2(int n, int r) {
        int[][] bin = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    bin[i][j] = 1;
                } else {
                    bin[i][j] = bin[i - 1][j - 1] + bin[i - 1][j];
                }
            }
        }

        printMatrix(bin);

        return bin[n][r];
    }

    public static int binomialCoefficient3(int n, int r) {
        int[][] bin = new int[n + 1][];

        for (int i = 0; i <= n; i++) {
            bin[i] = new int[i + 1];
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    bin[i][j] = 1;
                } else {
                    bin[i][j] = bin[i - 1][j - 1] + bin[i - 1][j];
                }
            }
        }

        printMatrix(bin);

        return bin[n][r];
    }

    public static int binomialCoefficient4(int n, int r) {
        int[][] bin = new int[n + 1][];

        for (int i = 0; i <= n; i++) {
            bin[i] = new int[i + 1];
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, r); j++) {
                if (j == 0 || i == j) {
                    bin[i][j] = 1;
                } else {
                    bin[i][j] = bin[i - 1][j - 1] + bin[i - 1][j];
                }
            }
        }

        printMatrix(bin);

        return bin[n][r];
    }

    public static int binomialCoefficient5(int n, int r) {
        int[] bin = new int[r + 1];

        bin[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = Math.min(i, r); j >= 1; j--) {
                if (j == 0 || j == i) {
                    bin[j] = 1;
                } else {
                    bin[j] = bin[j] + bin[j - 1];
                }

                System.out.println(Arrays.toString(bin));
            }
        }

        return bin[r];
    }

    public static void printMatrix(int[][] arr) {
        System.out.println();
        for (int[] arrEle : arr) {
            for (int ele : arrEle) {
                System.out.print(ele+" ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int bc1 = binomialCoefficient1(4, 2);
        int bc2 = binomialCoefficient2(4, 2);
        int bc3 = binomialCoefficient3(4, 2);
        int bc4 = binomialCoefficient4(4, 2);
        int bc5 = binomialCoefficient5(4, 2);

        System.out.println(bc1);
        System.out.println(bc2);
        System.out.println(bc3);
        System.out.println(bc4);
        System.out.println(bc5);
    }
}