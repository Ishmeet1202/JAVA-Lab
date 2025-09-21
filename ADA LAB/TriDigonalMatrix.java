
import java.util.Scanner;

public class TriDigonalMatrix {
    double[] A;
    int n;

    public TriDigonalMatrix(int n) {
        this.n = n;
        this.A = new double[3 * n - 2];
    }

    private int rowMapping(int i, int j) {
        return 2*i + j;
    }

    public void read() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            for (int j = Math.max(0, i - 1); j <= Math.min(i + 1, n - 1); j++) {
                System.out.print("Enter the value of "+(i + 1)+", "+(j + 1)+" non zero element: ");
                A[rowMapping(i, j)] = sc.nextInt();
            }
        }
    }

    public void print() {
        System.out.println("Tridigonal Matrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.abs(i - j) <= 1) {
                    System.out.print(A[rowMapping(i, j)]+" ");
                } else {
                    System.out.print(0+" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public TriDigonalMatrix add(TriDigonalMatrix B) {
        TriDigonalMatrix C = new TriDigonalMatrix(n);

        for (int i = 0; i < n; i++) {
            for (int j = Math.max(0, i - 1); j <= Math.min(i + 1, n - 1); j++) {
                C.A[rowMapping(i, j)] = A[rowMapping(i, j)] + B.A[rowMapping(i, j)];
            }
        }

        return C;
    }

    public int[][] multiply(TriDigonalMatrix B) {
        if (n != B.n) {
            throw new IllegalStateException("Both matrix must be of same size");
        }

        int[][] C = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = Math.max(0, i - 2); j <= Math.min(i + 2, n - 1); j++) {
                C[i][j] = 0;
                for (int k = Math.max(0, Math.max(i - 1, j - 1)); k <= Math.min(i + 1, Math.min(j + 1, n - 1)); k++) {
                    C[i][j] += A[rowMapping(i, k)] * B.A[rowMapping(k, j)];
                }
            }
        }

        return C;
    }

    public double determinant() {
        TriDigonalMatrix B = new TriDigonalMatrix(n);
        for (int i = 0; i < A.length; i++) {
            B.A[i] = A[i];
        }

        B.print();

        for (int k = 0; k < n - 1; k++) {
            double x = B.A[rowMapping(k, k)];
            int i = k + 1;
            double y = B.A[rowMapping(i, k)];
            int m = Math.min(i + 1, n - 1);
            if (m == n - 1) {
                m++;
            }

            for (int j = Math.max(0, i - 1); j < m; j++) {
                B.A[rowMapping(i, j)] = B.A[rowMapping(i, j)] - (B.A[rowMapping(k, j)] * (y / x));
            }
        }

        double d = 1;

        for (int i = 0; i < n; i++) {
            d = d * B.A[rowMapping(i, i)];
        }

        return d;
    }

    public static void main(String[] args) {
        TriDigonalMatrix A = new TriDigonalMatrix(4);
        A.read();
        A.print();

        // TriDigonalMatrix B = new TriDigonalMatrix(4);
        // B.read();
        // B.print();

        // System.out.println("ADDITION: ");
        // TriDigonalMatrix C = A.add(B);
        // C.print();

        // System.out.println("MULTIPLICATION");
        // int[][] mulC = A.multiply(B);
        // for (int[] arr : mulC) {
        //     for (int ele : arr) {
        //         System.out.print(ele+" ");
        //     }
        //     System.out.println();
        // }

        double determinant = A.determinant();
        System.out.println("DETERMINANT: "+determinant);
    }
}
