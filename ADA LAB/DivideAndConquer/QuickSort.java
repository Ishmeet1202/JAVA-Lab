import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] A, int low, int high) {
        if (low < high) {
            int pivotPoint = partition(A, low, high);
            quickSort(A, low, pivotPoint - 1);
            quickSort(A, pivotPoint + 1, high);
        }
    }

    public static int partition(int[] A, int low, int high) {
        int pivotElement = A[low];
        int j = low;
        for (int i = low + 1; i <= high; i++) {
            if (A[i] < pivotElement) {
                j += 1;
                if (i != j) {
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                }
            }
        }

        int pivotPoint = j;
        if (pivotPoint != low) {
            int temp = A[low];
            A[low] = A[pivotPoint];
            A[pivotPoint] = temp;
        }

        return pivotPoint;
    }

    public static void main(String[] args) {
        int[] A ={15,22,13,27,12,10,20,25};

        quickSort(A, 0, A.length - 1);

        System.out.println(Arrays.toString(A));
    }
}