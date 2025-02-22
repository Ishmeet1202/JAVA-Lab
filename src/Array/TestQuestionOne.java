package Array;

import java.util.Scanner;

public class TestQuestionOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an even number: ");
        int n = sc.nextInt();

        OneDArray<Integer> arr = new OneDArray<>(n);

        int oddIndex = 0;              // Start inserting odd numbers from index 0
        int evenIndex = (n + 1) / 2;   // Start inserting even numbers in the second half

        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                arr.insert(i, oddIndex);
                arr.display();
                oddIndex++;
            } else {
                arr.insert(i, evenIndex);
                arr.display();
                evenIndex++;
            }
        }
    }
}
