
import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] A, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(A, low, mid);
            mergeSort(A, mid + 1, high);
            merge(A, low, mid, high);
        }
    }
    
    public static void merge(int[] A, int low, int mid, int high) {
        int[] B = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;

        while (i <= mid && j <= high) { 
            if (A[i] < A[j]) {
                B[k++] = A[i++];
            } else {
                B[k++] = A[j++];
            }
        }

        while (i <= mid) { 
            B[k++] = A[i++];
        }

        while (j <= high) { 
            B[k++] = A[j++];
        }

        for (int index = 0; index < B.length; index++) {
            A[low + index] = B[index];
        }
    }

    public static void main(String[] args) {
        int[] A ={15,22,13,27,12,10,20,25};

        mergeSort(A, 0, A.length - 1);

        System.out.println(Arrays.toString(A));
    }
}