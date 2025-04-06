import java.util.Scanner;

public class SortedArrayToBST {
    // Function to read sorted input array
    static void read(int a[], int n) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter " + n + " sorted unique positive integers:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
    }

    // Recursive function to convert sorted array to complete BST
    static void convert_to_BST(int a[], int b[], int start, int end, int i) {
        if (start > end || i >= b.length) return;  // Prevent out-of-bounds
        
        // Middle element becomes root
        int mid = start + (end - start) / 2;
        b[i] = a[mid];
        
        // Recursively construct left and right subtrees
        convert_to_BST(a, b, start, mid - 1, 2 * i + 1); // Left child
        convert_to_BST(a, b, mid + 1, end, 2 * i + 2);   // Right child
    }

    // Preorder traversal of BST stored in array `b[]`
    static void preOrder(int b[], int n, int i) {
        if (i >= b.length || b[i] == 0) return; // Skip empty nodes
        System.out.print(b[i] + " ");
        preOrder(b, n, 2 * i + 1); // Left
        preOrder(b, n, 2 * i + 2); // Right
    }

    // Inorder traversal of BST stored in array `b[]`
    static void inOrder(int b[], int n, int i) {
        if (i >= b.length || b[i] == 0) return;
        inOrder(b, n, 2 * i + 1); // Left
        System.out.print(b[i] + " ");
        inOrder(b, n, 2 * i + 2); // Right
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements (n): ");
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[(int) Math.pow(2, Math.ceil(Math.log(n + 1) / Math.log(2))) - 1]; // Size = next power of 2 minus 1

        read(a, n);
        convert_to_BST(a, b, 0, n - 1, 0); // Start with i=0 (root)

        System.out.print("Preorder Traversal: ");
        preOrder(b, b.length, 0);
        
        System.out.print("\nInorder Traversal: ");
        inOrder(b, b.length, 0);
    }
}