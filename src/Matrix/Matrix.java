package Matrix;

import java.util.Scanner;

public class Matrix {

    private final double[][] matrix;
    private final int rows;
    private final int columns;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new double[this.rows][this.columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public void insert() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter "+(i+1)+","+(j+1)+" element: ");
                matrix[i][j] = sc.nextDouble();
            }
        }
        sc.close();
    }

    public void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public Matrix add(Matrix arr) {
        if (rows != arr.getRows() || columns != arr.getColumns()) throw new IllegalStateException("Given matrix is of different direction");

        Matrix result = new Matrix(rows,columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.getMatrix()[i][j] = matrix[i][j] + arr.getMatrix()[i][j];
            }
        }
        return result;
    }

    public Matrix multiply(Matrix arr) {
        if (columns != arr.getRows()) throw new IllegalStateException("Multiplication failed !");
        
        Matrix result = new Matrix(rows,arr.getColumns());
        
        for (int i = 0; i < result.getRows(); i++) {
            for (int j = 0; j < result.columns; j++) {
                result.getMatrix()[i][j] = 0;
                for (int k = 0; k < columns; k++) {
                    result.getMatrix()[i][j] += matrix[i][k] * arr.getMatrix()[k][j];
                }
            }
        }
        return result;
    }

    public double determinant() {
        if (rows != columns) throw new IllegalStateException("Matrix must be a square matrix !");

        double det = 1.0;

        double[][] tempMatrix = new double[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                tempMatrix[i][j] = matrix[i][j];
            }
        }

        for (int k = 0; k < rows; k++) {
            int pivotRow = k;

            // Find the row with the largest absolute value in column k
            for (int i = k + 1; i < rows; i++) {
                if (Math.abs(tempMatrix[i][k]) > Math.abs(tempMatrix[pivotRow][k])) {
                    pivotRow = i;
                }
            }

            // If the pivot is too small (< 1e-12), the matrix is singular
            if (Math.abs(tempMatrix[pivotRow][k]) < 1e-12) {
                throw new IllegalStateException("Matrix is singular and cannot be inverted.");
            }

            // Swap rows in tempMatrix and identity
            if (pivotRow != k) {
                double[] temp = tempMatrix[k];
                tempMatrix[k] = tempMatrix[pivotRow];
                tempMatrix[pivotRow] = temp;
                det *= -1;
            }

            for (int i = k + 1; i < rows; i++) {
                if (tempMatrix[i][k] == 0) continue;
                double factor = tempMatrix[i][k] / tempMatrix[k][k];
                for (int j = k; j < columns; j++) {
                    tempMatrix[i][j] = tempMatrix[i][j] - tempMatrix[k][j]*factor;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            det *= tempMatrix[i][i];
        }

        return det;
    }

    public Matrix inverse() {
        if (rows != columns)
            throw new IllegalStateException("Matrix must be a square matrix!");

        double[][] tempMatrix = new double[rows][columns];
        Matrix resultMatrix = new Matrix(rows, columns);
        double[][] identity = resultMatrix.getMatrix();

        // Copy input matrix and create identity matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                tempMatrix[i][j] = matrix[i][j];
                identity[i][j] = (i == j) ? 1.0 : 0.0;
            }
        }

        // Gaussian elimination with partial pivoting
        for (int k = 0; k < rows; k++) {
            int pivotRow = k;

            // Find the row with the largest absolute value in column k
            for (int i = k + 1; i < rows; i++) {
                if (Math.abs(tempMatrix[i][k]) > Math.abs(tempMatrix[pivotRow][k])) {
                    pivotRow = i;
                }
            }

            // If the pivot is too small (< 1e-12), the matrix is singular
            if (Math.abs(tempMatrix[pivotRow][k]) < 1e-12) {
                throw new IllegalStateException("Matrix is singular and cannot be inverted.");
            }

            // Swap rows in tempMatrix and identity
            if (pivotRow != k) {
                double[] temp = tempMatrix[k];
                tempMatrix[k] = tempMatrix[pivotRow];
                tempMatrix[pivotRow] = temp;

                temp = identity[k];
                identity[k] = identity[pivotRow];
                identity[pivotRow] = temp;
            }

            // Normalize the pivot row
            double pivot = tempMatrix[k][k];
            for (int j = 0; j < columns; j++) {
                tempMatrix[k][j] /= pivot;
                identity[k][j] /= pivot;
            }

            // Reduce all other rows
            for (int i = 0; i < rows; i++) {
                if (i == k || tempMatrix[i][k] == 0) continue; // Skip the pivot row
                double factor = tempMatrix[i][k];

                for (int j = 0; j < columns; j++) {
                    tempMatrix[i][j] -= factor * tempMatrix[k][j];
                    identity[i][j] -= factor * identity[k][j];
                }
            }
        }

        return resultMatrix;
    }

}
