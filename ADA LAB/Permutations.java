import java.util.Arrays;

public class Permutations {

    static void recursivePermuations(int[] a, int k, int n) {
        if (k == n) {
            System.out.println(Arrays.toString(a));
        } else {
            for (int i = k; i < n; i++) {
                int t = a[i]; a[i] = a[k]; a[k] = t;
                recursivePermuations(a, k + 1, n);
                t = a[i]; a[i] = a[k]; a[k] = t;
            }
        }
    }

    static boolean getNextPermutation(int[] a, int n) {
        if (a == null || n <= 1) {
            return false;
        }

        int i = n - 2;
        while (i >= 0 && a[i] >= a[i + 1]) {
            i--;
        }

        if (i == -1) {
            return false;
        }

        int j = n - 1;
        while (a[j] <= a[i]) {
            j--;
        }

        swap(a, i, j);

        reverse(a, i + 1, n - 1);

        return true;
    }

    static void iterativePermutations(int[] a, int n) {
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        while (getNextPermutation(a, n)) { 
            System.out.println(Arrays.toString(a));
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void reverse(int[] a, int start, int end) {
        while (start < end) {
            swap(a, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        
        int[] arr = {3,5,7,9,11,56};

        System.out.println("Recursive Permutations: \n");

        long startTimeRecursive = System.currentTimeMillis();

        recursivePermuations(arr, 0, arr.length);

        long endTimeRecursive = System.currentTimeMillis();

        System.out.println("Iterative Permutations: \n");

        long startTimeIterative = System.currentTimeMillis();

        iterativePermutations(arr, arr.length);

        long endTimeIterative = System.currentTimeMillis();

        System.out.println("Execution Time for recusive function: "+(endTimeRecursive - startTimeRecursive+" ms"));

        System.out.println("Execution Time for iterative function: "+(endTimeIterative - startTimeIterative+" ms"));

    }
}