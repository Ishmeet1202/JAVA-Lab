package Matrix;

import java.util.Arrays;
import java.util.Scanner;

public class LowerTriangularMatrix {
    private int n;
    private double[][] ltm;

    public double[][] getMatrix() {
        return ltm;
    }

    public int getSize() {
        return n;
    }

    public LowerTriangularMatrix(int size) {
        this.n = size;
        ltm = new double[n][n];

        for(int i = 0;i < n;i++) {
            for(int j = 0;j < n;j++) {
                if(j > i) {
                    ltm[i][j] = 0;
                }
            }
        }
    }

    public void read() {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("Enter a element: ");
                ltm[i][j] = sc.nextDouble();
            }
        }
        System.out.println("Reading Complete !\n");
    }

    public static void print(double[][] ltm) {
        for (double[] arr : ltm) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static double[][] product(LowerTriangularMatrix ltmOne,LowerTriangularMatrix ltmTwo) {
        if (ltmOne.getSize() == ltmTwo.getSize()) {
            LowerTriangularMatrix resultMatrix = new LowerTriangularMatrix(ltmOne.getSize());

            for (int i = 0; i < ltmOne.getSize(); i++) {
                for (int j = 0; j <= i; j++) {
                    resultMatrix.getMatrix()[i][j] = 0;
                    for (int k = 0; k <= i; k++) {
                        resultMatrix.getMatrix()[i][j] += ltmOne.getMatrix()[i][k] * ltmTwo.getMatrix()[k][j];
                    }
                }
            }

            return resultMatrix.getMatrix();
        }
        return null;
    }

    public static void main(String[] args) {
        LowerTriangularMatrix ltmOne = new LowerTriangularMatrix(3);
        LowerTriangularMatrix ltmTwo = new LowerTriangularMatrix(3);

        ltmOne.read();
        ltmTwo.read();

        double[][] resultMatrix = LowerTriangularMatrix.product(ltmOne,ltmTwo);

        if (resultMatrix != null) {
            LowerTriangularMatrix.print(resultMatrix);
        }
        else {
            System.out.println("Matrices must be of same dimension !");
        }
    }
}
