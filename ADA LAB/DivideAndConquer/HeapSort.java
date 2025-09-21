
import java.util.Arrays;

public class HeapSort {

    public static void adjust(int[] a, int pos, int n) {
        int j = 2 * pos + 1; int i = pos;

        while (j <= n - 1) { 
            if (j < n - 1 && a[j] < a[j + 1]) {
                j += 1;
            }

            if (a[i] < a[j]) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i = j;
                j = 2 * j + 1;
            } else {
                break;
            }
        }
    }

    public static void heapify(int[] a, int n) {
        for (int i = (n - 2)/2; i >= 0; i--) {
            adjust(a, i, n);
        }
    }

    public static void heapSort(int[] a, int n) {
        heapify(a, n);

        for (int i = n - 1; i >= 1; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            adjust(a, 0, i);
        }
    }

    public static void main(String[] args) {
        int[] a = {2,4,3,5,1};

        heapSort(a, a.length);

        System.out.println(Arrays.toString(a));
    }
}