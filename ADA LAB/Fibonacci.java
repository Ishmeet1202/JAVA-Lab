import java.util.Scanner;

public class Fibonacci {
    
    public static long iterativeFibonacci(int n) {
        long f0 = 1;
        long f1 = 1;

        for (int i = 3; i <= n; i++) {
            long f2 = f1 + f0;
            f0 = f1;
            f1 = f2;
        }

        return f1;
    }

    public static long recursiveFibbonacciOne(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return recursiveFibbonacciOne(n - 1) + recursiveFibbonacciOne(n - 2);
        }
    }

    public static long recursiveFibbonacciTwo(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return recursiveFibbonacciTwo(n - 2) + recursiveFibbonacciTwo(n - 1);
        }
    }
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();

        long startIterative = System.currentTimeMillis();
        long iterativeFibo = iterativeFibonacci(n);
        long endIterative = System.currentTimeMillis();

        System.out.println("Value of "+n+"th term of fibonacci (Iterative): "+iterativeFibo);

        long startRecurisiveOne = System.currentTimeMillis();
        long recursiveFiboOne = recursiveFibbonacciOne(n);
        long endRecurisiveOne = System.currentTimeMillis();

        System.out.println("Value of "+n+"th term of fibonacci (Recursive (n-1) + (n-2)): "+recursiveFiboOne);

        long startRecurisiveTwo = System.currentTimeMillis();
        long recursiveFiboTwo = recursiveFibbonacciTwo(n);
        long endRecurisiveTwo = System.currentTimeMillis();

        System.out.println("Value of "+n+"th term of fibonacci (Recursive (n-2) + (n-1): "+recursiveFiboTwo);

        System.out.println("\nExecution time for Iterative: "+(endIterative - startIterative)+" ms");
        System.out.println("Execution time for Recursive ((n-1) + (n-2)): "+(endRecurisiveOne - startRecurisiveOne)+" ms");
        System.out.println("Execution time for Recursive ((n-2) + (n-1)) "+(endRecurisiveTwo - startRecurisiveTwo)+" ms");


    }
}