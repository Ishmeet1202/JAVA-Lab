package Matrix;

import java.util.Scanner;

public class LowerTriangularMatrix {
    private final int n;
    private final double[] mapArray;

    public LowerTriangularMatrix(int n) {
        this.n = n;
        this.mapArray = new double[(n*(n+1))/2];
    }

    public int getN() {
        return n;
    }

    public double[] getMapArray() {
        return mapArray;
    }

    private int mapRowWise(int i, int j) {
        return ((i*(i+1))/2) + j;
    }

    private int mapColumnWise(int i,int j) {
        return (n*j) - (j*(j+1)/2) + i;
    }

    public void read() {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("Enter "+(i+1)+","+(j+1)+" non null element: ");
                mapArray[mapRowWise(i,j)] = sc.nextDouble();
            }
        }
    }

    public void display() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= j) {
                    System.out.print(mapArray[mapRowWise(i,j)]+"\t");
                } else {
                    System.out.print(0.0+"\t");
                }
            }
            System.out.println();
        }
    }

    public LowerTriangularMatrix add(LowerTriangularMatrix lm) {
        int lmN = lm.getN();
        if (n != lmN) throw new IllegalStateException("Matrices must be of same dimension !");
        double[] lmMatrix = lm.getMapArray();

        LowerTriangularMatrix result = new LowerTriangularMatrix(n);
        double[] resultMatrix = result.getMapArray();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                resultMatrix[mapRowWise(i,j)] = mapArray[mapRowWise(i,j)] + lmMatrix[mapRowWise(i,j)];
            }
        }
        return result;
    }

    public LowerTriangularMatrix multiply(LowerTriangularMatrix lm) {
        int lmN = lm.getN();
        if (n != lmN) throw new IllegalStateException("Matrices must be of same dimension !");
        double[] lmMatrix = lm.getMapArray();

        LowerTriangularMatrix result = new LowerTriangularMatrix(n);
        double[] resultMatrix = result.getMapArray();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                resultMatrix[mapRowWise(i,j)] = 0;
                for (int k = j; k <= i; k++) {
                    resultMatrix[mapRowWise(i,j)] += mapArray[mapRowWise(i,k)] * lmMatrix[mapRowWise(k,j)];
                }
            }
        }
        return result;
    }
}
