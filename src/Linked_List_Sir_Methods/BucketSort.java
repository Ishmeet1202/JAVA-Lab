package Linked_List_Sir_Methods;

import java.util.Arrays;

public class BucketSort {
    public static void main(String[] args) {
        int[] A = {6,3,9,10,15,6,8,12,3,6};

        bucketSort(A,A.length);
    }

    public static void bucketSort(int[] arr,int n) {
        int max = findMax(arr);

        SingleLinkedList[] bin = new SingleLinkedList[max + 1];

        for (int i = 0; i < max + 1; i++) {
            bin[i] = new SingleLinkedList();
        }

        for (int i = 0; i < n; i++) {
            bin[arr[i]].insert(arr[i],0);
        }

        int i = 0,j = 0;
        while (i < max + 1) {
            if (bin[i].getSize() != 0) {
                arr[j++] = bin[i].get(bin[i].getSize() - 1);
                bin[i].delete(0);
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
