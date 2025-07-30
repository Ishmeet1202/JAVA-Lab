public class BigFactorialArray {

    public static void factorial(int n) {
        int[] factorialArray = createFactorialArray(n);
        factorialArray[factorialArray.length - 1] = 1;
        int size = factorialArray.length;
        // System.out.println(size);

        for (int x = 2; x <= n; x++) {
            int carry = 0;

            for (int i = size - 1; i >= 0; i--) {
                int product = factorialArray[i] * x + carry;
                factorialArray[i] = product % 10;
                carry = product / 10;
            }
        }

        printResult(factorialArray, n);
    }

    private static void printResult(int[] a, int n) {
        System.out.print("Factorial of "+n+" is: ");
        for (int digit : a) {
            System.out.print(digit);
        }
    }

    private static int[] createFactorialArray(int n) {
        double logCalculation = 0.0;

        for (int i = 1; i <= n; i++) {
            logCalculation += Math.log10((double) (i));
        }

        int arraySize = (int) Math.floor(logCalculation) + 1;

        return new int[arraySize];
    }

    public static void main(String[] args) {
        factorial(1000);
    }
}