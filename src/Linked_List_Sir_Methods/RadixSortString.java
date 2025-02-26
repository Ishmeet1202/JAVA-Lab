package Linked_List_Sir_Methods;

import java.util.Arrays;
import java.util.LinkedList;

public class RadixSortString {
    public static void main(String[] args) {
        String[] A = {"cap", "bit", "ad", "big", "add"};

        int maxSize = maxLength(A);
        radixSort(A, maxSize);

        System.out.println(Arrays.toString(A)); // Print sorted result
    }

    static void radixSort(String[] arr, int maxLength) {
        for (int pos = maxLength - 1; pos >= 0; pos--) {
            LinkedList<String>[] bin = new LinkedList[256];

            for (int i = 0; i < 256; i++) {
                bin[i] = new LinkedList<>();
            }

            // Initialize only when needed
            for (String str : arr) {
                int charIndex = (pos < str.length()) ? str.charAt(pos) : 0;
                bin[charIndex].add(str);
            }

            // Reconstruct the array
            int index = 0;
            for (LinkedList<String> ll : bin) {
                while (!ll.isEmpty()) {
                    arr[index++] = ll.removeFirst();
                }
            }
        }
    }

    public static int maxLength(String[] arr) {
        int max = 0;
        for (String str : arr) {
            max = Math.max(max, str.length());
        }
        return max;
    }
}
