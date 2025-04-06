
import java.util.*;

public class BinarySearchTreeImplementation {

    TreeNode root;
    private final Scanner sc;

    public BinarySearchTreeImplementation() {
        this.root = null;
        sc = new Scanner(System.in);
    }

    TreeNode build(TreeNode p) {

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

    int searchRecursive(TreeNode node, int key) {
        if (node == null) {
            return -1;
        }

        if (node.data == key) {
            return node.data;
        } else if (node.data > key) {
            return searchRecursive(node.lChild, key);
        } else {
            return searchRecursive(node.rChild, key);
        }
    }

    int searchIterative(TreeNode node, int key) {

        while (node != null) {
            if (node.data == key) {
                return node.data;
            } else if (node.data > key) {
                node = node.lChild;
            } else {
                node = node.rChild;
            }
        }
        return -1;
    }

    void insertIterative(TreeNode temp, int element) {
        if (temp == null) {
            root = new TreeNode(element);
            System.out.println("Tree is created with root node " + root);
            return;
        }

        TreeNode parent = null;

        while (temp != null) {
            parent = temp;
            if (temp.data == element) {
                System.out.println(element + " already exists !");
                return;
            } else if (temp.data > element) {
                temp = temp.lChild;
            } else {
                temp = temp.rChild;
            }
        }

        TreeNode newNode = new TreeNode(element);
        if (parent != null) {
            if (parent.data > element) {
                parent.lChild = newNode;
            } else {
                parent.rChild = newNode;
            }
        }
    }

    void insertRecursive(TreeNode node, int element) {
        if (node == null) {
            System.out.println("Creating the root node with value: " + element);
            root = new TreeNode(element);
            return;
        }

        if (element == node.data) {
            System.out.println(element + " already exists!");
            return;
        } else if (element < node.data) {
            if (node.lChild == null) {
                node.lChild = new TreeNode(element);
            } else {
                insertRecursive(node.lChild, element);
            }
        } else {
            if (node.rChild == null) {
                node.rChild = new TreeNode(element);
            } else {
                insertRecursive(node.rChild, element);
            }
        }
    }

    void delete(int x) {
        if (root == null) {
            throw new IllegalStateException("Tree is Empty!");
        }

        TreeNode tempNode = root;
        TreeNode parentNode = null;

        // Locate the node to be deleted
        while (tempNode != null) {
            if (tempNode.data == x) {
                break;
            } else if (tempNode.data > x) {
                parentNode = tempNode;
                tempNode = tempNode.lChild;
            } else {
                parentNode = tempNode;
                tempNode = tempNode.rChild;
            }
        }

        // If node not found
        if (tempNode == null) {
            throw new IllegalArgumentException("Key " + x + " doesn't exist in the tree");
        }

        // Case I: Node has no children (leaf node)
        if (tempNode.lChild == null && tempNode.rChild == null) {
            if (parentNode == null) {  // Node to be deleted is the root
                root = null;
            } else if (tempNode == parentNode.lChild) {
                parentNode.lChild = null;
            } else {
                parentNode.rChild = null;
            }
        } // Case II: Node has only one child
        else if (tempNode.lChild != null && tempNode.rChild == null) {
            if (parentNode == null) {  // Node to be deleted is the root
                root = tempNode.lChild;
            } else if (tempNode == parentNode.lChild) {
                parentNode.lChild = tempNode.lChild;
            } else {
                parentNode.rChild = tempNode.lChild;
            }
        } else if (tempNode.lChild == null && tempNode.rChild != null) {
            if (parentNode == null) {  // Node to be deleted is the root
                root = tempNode.rChild;
            } else if (tempNode == parentNode.lChild) {
                parentNode.lChild = tempNode.rChild;
            } else {
                parentNode.rChild = tempNode.rChild;
            }
        } // Case III: Node has two children
        else {
            TreeNode successorNode = tempNode.rChild;
            TreeNode successorParent = tempNode;

            // Find in-order successor (smallest in the right subtree)
            while (successorNode.lChild != null) {
                successorParent = successorNode;
                successorNode = successorNode.lChild;
            }

            // Replace tempNode's data with successor's data
            tempNode.data = successorNode.data;

            // Remove successor node
            if (successorParent.lChild == successorNode) {
                successorParent.lChild = successorNode.rChild;
            } else {
                successorParent.rChild = successorNode.rChild;
            }
        }
    }

    void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.lChild);
        System.out.print(node.data + " ");
        inOrderTraversal(node.rChild);
    }

    public void printTree() {
        System.out.println();
        System.out.print("Inorder Traversal: ");
        inOrderTraversal(root);
        System.out.println();
    }

    public static void main(String[] args) {
        BinarySearchTreeImplementation bst = new BinarySearchTreeImplementation();

        bst.build(null);
        System.out.println(bst.searchRecursive(bst.root, 10));
        System.out.println(bst.searchIterative(bst.root, 4));
        // bst.insertIterative(bst.root, 6);
        // bst.insertRecursive(bst.root, 6);
        bst.printTree();
        bst.delete(15);
        bst.printTree();
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
