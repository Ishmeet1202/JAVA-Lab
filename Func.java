import java.util.Scanner;
import java.math.BigDecimal;

public class Func {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Calculate value of function f(x) = PI*e^x");
        System.out.print("Enter Value of x : ");

        double num = scan.nextDouble();

        BigDecimal exp = BigDecimal.valueOf(Math.exp(num));


        BigDecimal pi = new BigDecimal(Math.PI);

        BigDecimal function = pi.multiply(exp);

        System.out.println("Value: "+function);



    }
}