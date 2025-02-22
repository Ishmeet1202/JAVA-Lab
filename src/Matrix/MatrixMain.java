package Matrix;

public class MatrixMain {
    public static void main(String[] args) {
        Matrix arr = new Matrix(2,2);

        arr.insert();
        arr.display();

        System.out.println(arr.determinant());

        Matrix inverse = arr.inverse();
        System.out.println();
        System.out.println();
        inverse.display();
    }
}
