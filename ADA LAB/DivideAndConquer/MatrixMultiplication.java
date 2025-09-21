public class MatrixMultiplication {
    
    public static int[][] multiply1(int[][] A, int[][] B, int n) {
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C;
    }

    public static int[][] multiply2(int[][] A, int[][] B, int n) {

        int[][] C = new int[n][n];
        if (n == 2) {
            C[0][0] = A[0][0]*B[0][0] + A[0][1]*B[1][0];
            C[0][1] = A[0][0]*B[0][1] + A[0][1]*B[1][1];
            C[1][0] = A[1][0]*B[0][0] + A[1][1]*B[1][0];
            C[1][1] = A[1][0]*B[0][1] + A[1][1]*B[1][1];
            return C;
        }

        // Divide
        int[][] A11 = new int[n/2][n/2];
        int[][] A12 = new int[n/2][n/2];
        int[][] A21 = new int[n/2][n/2];
        int[][] A22 = new int[n/2][n/2]; 
        
        int[][] B11 = new int[n/2][n/2];
        int[][] B12 = new int[n/2][n/2];
        int[][] B21 = new int[n/2][n/2];
        int[][] B22 = new int[n/2][n/2];

        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n/2; j++) {
                A11[i][j] = A[i][j];
                A12[i][j] = A[i][j + n/2];
                A21[i][j] = A[i + n/2][j];
                A22[i][j] = A[i + n/2][j + n/2];
            }
        }

        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n/2; j++) {
                B11[i][j] = B[i][j];
                B12[i][j] = B[i][j + n/2];
                B21[i][j] = B[i + n/2][j];
                B22[i][j] = B[i + n/2][j + n/2];
            }
        }

        // Combine
        int[][] C11 = add(multiply1(A11, B11, n/2), multiply1(A12, B21, n/2), n/2);
        int[][] C12 = add(multiply1(A11, B12, n/2), multiply1(A12, B22, n/2), n/2);
        int[][] C21 = add(multiply1(A21, B11, n/2), multiply1(A22, B21, n/2), n/2);
        int[][] C22 = add(multiply1(A21, B12, n/2), multiply1(A22, B22, n/2), n/2);

        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n/2; j++) {
                C[i][j] = C11[i][j];
                C[i][j + n/2] = C12[i][j];
                C[i + n/2][j] = C21[i][j];
                C[i + n/2][j + n/2] = C22[i][j];
            }
        }

        return C;
    }

    public static int[][] multiply3(int[][] A, int[][] B, int n) {
        
        int[][] C = new int[n][n];
        if (n == 2) {
            C[0][0] = A[0][0]*B[0][0] + A[0][1]*B[1][0];
            C[0][1] = A[0][0]*B[0][1] + A[0][1]*B[1][1];
            C[1][0] = A[1][0]*B[0][0] + A[1][1]*B[1][0];
            C[1][1] = A[1][0]*B[0][1] + A[1][1]*B[1][1];
            return C;
        }

        // Divide
        int[][] A11 = new int[n/2][n/2];
        int[][] A12 = new int[n/2][n/2];
        int[][] A21 = new int[n/2][n/2];
        int[][] A22 = new int[n/2][n/2]; 
        
        int[][] B11 = new int[n/2][n/2];
        int[][] B12 = new int[n/2][n/2];
        int[][] B21 = new int[n/2][n/2];
        int[][] B22 = new int[n/2][n/2];

        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n/2; j++) {
                A11[i][j] = A[i][j];
                A12[i][j] = A[i][j + n/2];
                A21[i][j] = A[i + n/2][j];
                A22[i][j] = A[i + n/2][j + n/2];
            }
        }

        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n/2; j++) {
                B11[i][j] = B[i][j];
                B12[i][j] = B[i][j + n/2];
                B21[i][j] = B[i + n/2][j];
                B22[i][j] = B[i + n/2][j + n/2];
            }
        }

        int[][] m1 = multiply3(add(A11, B11, n/2), add(A22, B22, n/2), n/2);
        int[][] m2 = multiply3(add(A21, A22, n / 2), B11, n / 2);
        int[][] m3 = multiply3(A11, subtract(B12, B22, n / 2), n / 2);
        int[][] m4 = multiply3(A22, subtract(B21, B11, n / 2), n / 2);
        int[][] m5 = multiply3(add(A11, A12, n / 2), B22, n / 2);
        int[][] m6 = multiply3(subtract(A21, A11, n / 2), add(B11, B12, n / 2), n / 2);
        int[][] m7 = multiply3(subtract(A12, A22, n / 2), add(B21, B22, n / 2), n / 2);

        int c11[][] = add(add(subtract(m4, m5, n / 2), m7, n / 2), m1, n / 2);
        int c12[][] = add(m3, m5, n / 2);
        int c21[][] = add(m2, m4, n / 2);
        int c22[][] = add(add(subtract(m3, m2, n / 2), m6, n / 2), m1, n / 2);

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                C[i][j] = c11[i][j];
                C[i][j + n / 2] = c12[i][j];
                C[i + n / 2][j] = c21[i][j];
                C[i + n / 2][j + n / 2] = c22[i][j];
            }
        }

        return C;
    }

    public static int[][] add(int a[][], int b[][], int n) {
        int res[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = a[i][j] + b[i][j];
            }
        }
        return res;
    }
    
    public static int[][] subtract(int a[][], int b[][], int n) {
        int res[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = a[i][j] - b[i][j];
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[][] A = {{1,2},{3,4}};
        int[][] B = {{5,6},{7,8}};
        int n = 2;

        int[][] C = multiply3(A, B, n);

        for (int[] rows : C) {
            for (int ele : rows) {
                System.out.print(ele+" ");
            }
            System.out.println();
        }
    }
}