package Matrix;

public class UpperTriangularMain {
    public static void main(String[] args) {
        UpperTriangularMatrix um1 = new UpperTriangularMatrix(3);
        UpperTriangularMatrix um2 = new UpperTriangularMatrix(3);

        um1.read();

        um1.display();
        System.out.println();

        um2.read();

        um2.display();
        System.out.println();

        UpperTriangularMatrix resultAdd = um1.add(um2);

        resultAdd.display();
        System.out.println();

        UpperTriangularMatrix resultMultiply = um1.multiply(um2);

        resultMultiply.display();
    }
}
