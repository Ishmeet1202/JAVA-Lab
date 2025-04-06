
import java.util.Scanner;

public class ArrayBinaryTree {

    int[] treeArray;
    int height;
    Scanner sc;

    public ArrayBinaryTree(int height) {
        this.height = height;
        this.treeArray = new int[(int) ((Math.pow(2.0, (double) (this.height))) - 1)];
        for (int i = 0; i < this.treeArray.length; i++) {
            this.treeArray[i] = -1;
        }
        this.sc = new Scanner(System.in);
    }

    public void build(int i) {
        if (i >= treeArray.length) {
            return;
        }

        if (i == 0) {
            System.out.print("Enter the value of root node: ");
            treeArray[i] = sc.nextInt();
            System.out.println();
        } else if (i % 2 == 1) {
            System.out.print("Enter the value of " + treeArray[(i - 1) / 2] + "'s left child node: ");
            treeArray[i] = sc.nextInt();
            System.out.println();
        } else {
            System.out.print("Enter the value of " + treeArray[(int) (Math.floor((i - 1) / 2))] + "'s right child node: ");
            treeArray[i] = sc.nextInt();
            System.out.println();
        }

        System.out.print("Does " + treeArray[i] + " has the left child: (Y/N) ");
        String ans = sc.next();
        if (ans.equalsIgnoreCase("Y") && (2 * (i + 1)) - 1 < (int) ((Math.pow(2.0, (double) (this.height))) - 1)) {
            build((2 * (i + 1)) - 1);
        }

        System.out.print("Does " + treeArray[i] + " has the right child: (Y/N) ");
        ans = sc.next();
        if (ans.equalsIgnoreCase("Y") && (2 * (i + 1)) < (int) ((Math.pow(2.0, (double) (this.height))) - 1)) {
            build((2 * (i + 1)));
        }
    }

    public boolean isEmpty() {
        return treeArray[0] == -1;
    }

    public int getHeight() {
        return height;
    }

    public int size() {
        int sz = 0;

        for (int i = 0; i < treeArray.length; i++) {
            if (treeArray[i] != -1) {
                sz++;
            }
        }

        return sz;
    }

    public int search(int key) {
        for (int i = 0; i < treeArray.length; i++) {
            if (treeArray[i] == key) {
                return i;
            }
        }

        return -1;
    }

    public void preOrderTraversal(int i) {
        if (isEmpty() || i >= treeArray.length) {
            return;
        }

        System.out.print(treeArray[i] + " ");

        if ((2 * (i + 1)) - 1 < treeArray.length && treeArray[(2 * (i + 1)) - 1] != -1) {
            preOrderTraversal((2 * (i + 1)) - 1);
        }

        if (2 * (i + 1) < treeArray.length && treeArray[2 * (i + 1)] != -1) {
            preOrderTraversal((2 * (i + 1)));
        }
    }

    public void inOrderTraversal(int i) {
        if (isEmpty() || i >= treeArray.length) {
            return;
        }

        if ((2 * (i + 1)) - 1 < treeArray.length && treeArray[(2 * (i + 1)) - 1] != -1) {
            inOrderTraversal((2 * (i + 1)) - 1);
        }

        System.out.print(treeArray[i] + " ");

        if (2 * (i + 1) < treeArray.length && treeArray[2 * (i + 1)] != -1) {
            inOrderTraversal((2 * (i + 1)));
        }
    }

    public void postOrderTraversal(int i) {
        if (isEmpty() || i >= treeArray.length) {
            return;
        }

        if ((2 * (i + 1)) - 1 < treeArray.length && treeArray[(2 * (i + 1)) - 1] != -1) {
            postOrderTraversal((2 * (i + 1)) - 1);
        }

        if (2 * (i + 1) < treeArray.length && treeArray[2 * (i + 1)] != -1) {
            postOrderTraversal((2 * (i + 1)));
        }

        System.out.print(treeArray[i] + " ");
    }

    public void levelOrderTraversal(int i) {
        for (int index = i; index < treeArray.length; index++) {
            if (treeArray[index] != -1) {
                System.out.print(treeArray[index]+" ");
            }
        }
    }

    public void printTree() {
        System.out.println();
        System.out.print("Preorder Traversal: ");
        preOrderTraversal(0);
        System.out.println();
        System.out.print("Inorder Traversal: ");
        inOrderTraversal(0);
        System.out.println();
        System.out.print("Postorder Traversal: ");
        postOrderTraversal(0);
        System.out.println();
        System.out.print("Levelorder Traversal: ");
        levelOrderTraversal(0);
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayBinaryTree bt = new ArrayBinaryTree(2);

        bt.build(0);
        bt.printTree();
        System.out.println(bt.isEmpty());
        System.out.println(bt.size());
        System.out.println(bt.getHeight());
        System.out.println(bt.search(3));
    }
}
