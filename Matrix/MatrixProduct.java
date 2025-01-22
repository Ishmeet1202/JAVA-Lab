package Matrix;

import java.util.Arrays;

public class MatrixProduct {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}};
        int[][] b = {{1, 2}, {3, 4}, {5, 6}};

        int[][] resultMatrix = product(a, b);

        if (resultMatrix != null) {
            for (int[] arr : resultMatrix) {
                System.out.println(Arrays.toString(arr));
            }
        } else {
            System.out.println("Matrix cannot be multiplied !");
        }
    }

    static boolean check(int[][] aMatrix, int[][] bMatrix) {
        return aMatrix[0].length == bMatrix.length;
    }

    static int[][] product(int[][] aMatrix, int[][] bMatrix) {
        if (check(aMatrix, bMatrix)) {
            int[][] resultMatrix = new int[aMatrix.length][bMatrix[0].length];

            for (int i = 0; i < aMatrix.length; i++) {
                for (int j = 0; j < bMatrix[0].length; j++) {
                    resultMatrix[i][j] = 0;
//                    for (int k = 0; k < bMatrix.length; k++)
                    for (int k = 0; k < aMatrix[0].length; k++) {
                        resultMatrix[i][j] = resultMatrix[i][j] + (aMatrix[i][k] * bMatrix[k][j]);
                    }
                }
            }

            return resultMatrix;
        }
        return null;
    }
}