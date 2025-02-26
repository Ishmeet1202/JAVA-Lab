package Linked_List_Sir_Methods;

import java.util.Arrays;
import java.util.LinkedList;

public class RadixSort {
    public static void main(String[] args) {
        int[] A = {235,36,237,146,348,48,152,259,62,163};

        radixSort(A,A.length);
    }

    public static void radixSort(int[] arr,int n) {
        int max = findMax(arr);

        LinkedList<Integer>[] bin = new LinkedList[n];

        for (int i = 0; i < n; i++) {
            bin[i] = new LinkedList<>();
        }

        int deno = 1;

        while (deno < max) {

            for (int i = 0; i < n; i++) {
                bin[(arr[i]/deno)%10].add(arr[i]);
            }

            int i = 0,j = 0;

            while (i < n) {
                if (!bin[i].isEmpty()) {
                    arr[j++] = bin[i].removeFirst();
                }
                else {
                    i++;
                }
            }
            deno *= 10;
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
