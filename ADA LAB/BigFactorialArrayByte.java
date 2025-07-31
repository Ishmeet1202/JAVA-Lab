public class BigFactorialByteArray {

    /**
     * Calculates the factorial of n and prints the result.
     * @param n The non-negative integer.
     */
    public static void factorial(int n) {
        // Handle base cases
        if (n < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
            return;
        }
        if (n == 0) {
            System.out.println("Factorial of 0 is: 1");
            return;
        }

        // 1. Create a byte array of the required size to hold all digits.
        byte[] factorialArray = createFactorialArray(n);
        factorialArray[factorialArray.length - 1] = 1; // Initialize with 1! = 1
        int size = factorialArray.length;

        // 2. Multiply by numbers from 2 to n using long multiplication.
        for (int x = 2; x <= n; x++) {
            int carry = 0;
            // Iterate through the digits from right to left (least to most significant).
            for (int i = size - 1; i >= 0; i--) {
                // Calculate the product for the current digit and add the carry.
                int product = factorialArray[i] * x + carry;
                
                // 3. Store the new digit (product % 10) and cast to byte.
                factorialArray[i] = (byte) (product % 10);
                
                // Calculate the carry for the next digit.
                carry = product / 10;
            }
        }

        printResult(factorialArray, n);
    }

    /**
     * Prints the factorial result, skipping any leading zeros.
     */
    private static void printResult(byte[] result, int n) {
        System.out.print("Factorial of " + n + " is: ");
        
        // Find the index of the first non-zero digit to avoid printing leading zeros.
        int startIndex = 0;
        while (startIndex < result.length - 1 && result[startIndex] == 0) {
            startIndex++;
        }

        // Print the digits from the first non-zero one.
        for (int i = startIndex; i < result.length; i++) {
            System.out.print(result[i]);
        }
        System.out.println(); // Add a newline for clean output.
    }

    /**
     * Creates a byte array with a size sufficient to hold all digits of n!
     * The number of digits in N! is calculated using logarithms: floor(log10(N!)) + 1
     */
    private static byte[] createFactorialArray(int n) {
        double logSum = 0.0;
        for (int i = 1; i <= n; i++) {
            logSum += Math.log10(i);
        }
        int arraySize = (int) Math.floor(logSum) + 1;
        return new byte[arraySize];
    }

    public static void main(String[] args) {
        factorial(5);   // Expected: 120
        factorial(20);  // Expected: 2432902008176640000
        factorial(1000); // A very large number!
    }
}
