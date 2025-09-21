public class DecimalToRadixR {

    public static char[] decimalToBase(int n, int r) {
        if (n == 0) {
            return new char[] {'0'};
        }
        
        char[] res = new char[(int) (Math.log10(n)/Math.log10(r)) + 1];
        int resSize = res.length - 1;

        while (n > 0 && resSize > -1) {
            int digit = n % r;
            res[resSize--] = (char) (digit + '0');
            n /= r;
        }

        return res;
    }

    private static void printResult(char[] arr) {
        for (char ele : arr) {
            System.out.print(ele);
        }
    }

    public static void main(String[] args) {
        char[] res = decimalToBase(100, 3);
        printResult(res);
    }
}