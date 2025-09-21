
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayMultiplication {
    
    public static List<Integer> multiply(int[] num, int x) {
        int i = num.length - 1, carry = 0;
        List<Integer> res = new ArrayList<>();

        while (i >= 0) {
            int product = (num[i] * x) + carry;
            int lastDigit = product % 10;
            res.add(lastDigit);
            carry = product / 10;
            i--;
        }

        while (carry > 0) {
            res.add(carry % 10);
            carry = carry / 10;
        }

        Collections.reverse(res);

        return res;
    }

    public static void printResult(List<Integer> arr) {
        for (Integer ele : arr) {
            System.out.print(ele);
        }
    }

    public static void main(String[] args) {
        printResult(multiply(new int[] {8,7,5,9,4,3,2,9,7,6}, 3641));
    }
}