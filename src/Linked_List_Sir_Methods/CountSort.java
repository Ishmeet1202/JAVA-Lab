package Linked_List_Sir_Methods;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] A = {6,3,9,10,15,6,8,12,3,6};

        countSort(A);
    }

    static void countSort(int[] arr) {
        int max = findMax(arr);

        int[] contArray = new int[max + 1];

        for (int i : contArray) {
            i = 0;
        }

        for (int i : arr) {
            contArray[i]++;
        }

        int i = 0,j = 0;

        while (i < max+1) {
            if (contArray[i] > 0) {
                arr[j++] = i;
                contArray[i]--;
            }
            else {
                i++;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    static int findMax(int[] arr) {
        int max = arr[0];

        for (int i: arr) {
            if (max < i) {
                max = i;
            }
        }
        return max;
    }
}

