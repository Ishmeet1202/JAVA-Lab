package Matrix;

public class LowerTriangularMain {
    public static void main(String[] args) {
        LowerTriangularMatrix lm1 = new LowerTriangularMatrix(3);
        LowerTriangularMatrix lm2 = new LowerTriangularMatrix(3);

        lm1.read();

        lm1.display();
        System.out.println();

        lm2.read();

        lm2.display();
        System.out.println();

        LowerTriangularMatrix result = lm1.add(lm2);

        result.display();
        System.out.println();

        LowerTriangularMatrix mulResult = lm1.multiply(lm2);
        mulResult.display();
    }
}
