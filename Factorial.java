package BigNumbers;

import java.math.BigInteger;
import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        BigInteger fact = factorial(n);
        System.out.println("Factorial of "+n+" is "+fact);
    }

    static BigInteger factorial(int n){
        //BigInteger num = BigInteger.valueOf(n);
        BigInteger fact = BigInteger.ONE;
        for(int i = n;i > 0;i--){
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }
}
