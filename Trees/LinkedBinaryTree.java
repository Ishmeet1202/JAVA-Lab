
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LinkedBinaryTree {

    TreeNode root;
    private final Scanner sc;

    public LinkedBinaryTree() {
        this.root = null;
        sc = new Scanner(System.in);
    }

    public TreeNode build(TreeNode p) {

        if (p == null) {
            System.out.print("Enter the value of root node: ");
            int rootValue = sc.nextInt();
            p = new TreeNode(rootValue);
            root = p;
        }

        System.out.print("Does " + p.data + " have the left child ? (Y/N): ");
        String ans = sc.next();
        if (ans.equalsIgnoreCase("Y")) {
            System.out.print("Enter the value of " + p.data + " left child: ");
            int leftChildValue = sc.nextInt();
            p.lChild = new TreeNode(leftChildValue);
            build(p.lChild);
        }

        System.out.print("Does " + p.data + " have the right child ? (Y/N): ");
        ans = sc.next();
        if (ans.equalsIgnoreCase("Y")) {
            System.out.print("Enter the value of " + p.data + " right child: ");
            int rightChildValue = sc.nextInt();
            p.rChild = new TreeNode(rightChildValue);
            build(p.rChild);
        }

        return p;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        int size = 0;

        q.add(root);
        while (!q.isEmpty()) {              // ITERATIVE FUNCTION FOR CALCULATING NUMBER OF NODES IN TREE
            TreeNode node = q.remove();
            size++;

            if (node.lChild != null) {
                q.add(node.lChild);
            }
            if (node.rChild != null) {
                q.add(node.rChild);
            }
        }

        return size;
    }

    public int getSize(TreeNode node) {     // RECURSIVE FUNCTION FOR CALCULATING NUMBER OF NODES IN TREE
        if (node == null) {
            return 0;
        }

        return getSize(node.lChild) + getSize(node.rChild) + 1;
    }

    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0; 
        } else if (getHeight(node.lChild) > getHeight(node.rChild)) {
            return getHeight(node.lChild) + 1;
        } else {
            return getHeight(node.rChild) + 1;
        }
    }

    public TreeNode getRoot() {
        return root;
    }

    public TreeNode search(TreeNode node, int key) {  // RECURSIVE FUNCTION FOR SEARCHING AN ELEMENT IN THE TREE
        if (node == null) {
            return null;
        }

        if (node.data == key) {
            return node;
        }

        TreeNode leftResult = search(node.lChild, key);
        if (leftResult != null) {
            return leftResult;
        }

        return search(node.rChild, key);
    }

    public void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.lChild);
        System.out.print(node.data + " ");
        inorderTraversal(node.rChild);
    }

    public void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrderTraversal(node.lChild);
        preOrderTraversal(node.rChild);
    }

    public void postOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.lChild);
        postOrderTraversal(node.rChild);
        System.out.print(node.data + " ");
    }

    public void levelOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            TreeNode tempNode = q.remove();
            System.out.print(tempNode.data + " ");

            if (tempNode.lChild != null) {
                q.add(tempNode.lChild);
            }
            if (tempNode.rChild != null) {
                q.add(tempNode.rChild);
            }
        }
        System.out.println();
    }

    public void printTree() {
        System.out.print("Inorder Traversal: ");
        inorderTraversal(root);
        System.out.println();
        System.out.print("Preorder Traversal: ");
        preOrderTraversal(root);
        System.out.println();
        System.out.print("Postorder Traversal: ");
        postOrderTraversal(root);
        System.out.println();
        System.out.print("Levelorder Traversal: ");
        levelOrderTraversal(root);
    }

    public static void main(String[] args) {
        LinkedBinaryTree bt = new LinkedBinaryTree();

        bt.build(null);
        bt.printTree();
        // System.out.println(bt.size());
        System.out.println(bt.getSize(bt.root));
        System.out.println(bt.search(bt.getRoot(), 3));
    }
}

class TreeNode {

    TreeNode lChild;
    int data;
    TreeNode rChild;

    public TreeNode(int data) {
        this.data = data;
        this.lChild = null;
        this.rChild = null;
    }
}
