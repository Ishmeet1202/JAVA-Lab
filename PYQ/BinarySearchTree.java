
import java.util.*;

class Node {

    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class BinarySearchTree {

    Node root;

    public void insert(int x) {
        root = insert(root, x);
    }

    private Node insert(Node r, int x) {
        if (r == null) {
            return new Node(x);
        }
        if (x < r.data) {
            r.left = insert(r.left, x);
        } else if (x > r.data) {
            r.right = insert(r.right, x); // Skip duplicates

        }
        return r;
    }

    public void inOrder(Node r, int[] arr, int[] index) {
        if (r != null) {
            inOrder(r.left, arr, index);
            arr[index[0]++] = r.data;
            inOrder(r.right, arr, index);
        }
    }

    public int numberOfNodes(Node r) {
        if (r == null) {
            return 0;
        }
        return 1 + numberOfNodes(r.left) + numberOfNodes(r.right);
    }

    public int delDuplicates(int[] a, int n) {
        BinarySearchTree bst = new BinarySearchTree();
        for (int i = 0; i < n; i++) {
            bst.insert(a[i]);
        }
        return bst.numberOfNodes(bst.root);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] a = new int[n];

        System.out.print("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        BinarySearchTree bst = new BinarySearchTree();
        for (int x : a) {
            bst.insert(x);
        }

        int[] index = {0};                      // BECAUSE OF JAVA PASS BY VALUE BEHAVIOUR

        bst.inOrder(bst.root, a, index);

        System.out.println("Sorted unique values:");
        for (int i = 0; i < index[0]; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println("\nNumber of unique values: " + bst.numberOfNodes(bst.root));
    }
}
