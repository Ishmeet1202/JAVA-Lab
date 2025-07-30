public class DecimalToBinary {

    static int decimalToBinary(int positiveDecimal) {
        if (positiveDecimal < 0) {
            throw new IllegalArgumentException("Input decimal number must be positive");
        }

        int binary = 0;
        int place = 1;

        while (positiveDecimal > 0) { 
            int digit = positiveDecimal % 2;
            binary += place * digit;
            place *= 10;
            positiveDecimal /= 2;
        }

        return binary;
    }

    public static void main(String[] args) {
        // System.out.println("Hello world");

        int binary = decimalToBinary(10);
        System.out.println(binary);
    }
}