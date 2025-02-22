package Array;

import java.util.Scanner;

public class QuestionOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a even number: ");
        int n = sc.nextInt();

        OneDArray<Integer> arr = new OneDArray<>(n + (int) (Math.floor(n/2)));

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1)
                arr.insert(i,arr.getSize());
            else {
                arr.insert(i, arr.getSize());
                arr.insert(i, arr.getSize());
            }
        }

        arr.display();
    }
}
