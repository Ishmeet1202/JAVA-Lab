
import java.util.Stack;

public class ExpressionTree {

    TreeNode root;

    public ExpressionTree() {
        this.root = null;
    }

    public void create(String postfixExp) {
        Stack<TreeNode> s = new Stack<>();

        for (int i = 0; i < postfixExp.length(); i++) {
            if (isOperator(postfixExp.charAt(i))) {
                TreeNode rightNode = s.pop();
                TreeNode leftNode = s.pop();
                TreeNode node = new TreeNode(String.valueOf(postfixExp.charAt(i)));
                node.left = leftNode;
                node.right = rightNode;
                s.push(node);
            } else {
                TreeNode node = new TreeNode(String.valueOf(postfixExp.charAt(i)));
                node.left = null;
                node.right = null;
                s.push(node);
            }
        }
        root = s.pop();
    }

    private boolean isOperator(char o) {
        return (o == '+' || o == '-' || o == '*' || o == '/');
    }

    double evaluate(TreeNode node) {
        if (node != null) {
            if (isOperator(node.data.charAt(0))) {
                double leftOperand = evaluate(node.left);
                double rightOperand = evaluate(node.right);

                switch (node.data) {
                    case "+" -> {
                        return leftOperand + rightOperand;
                    }
                    case "-" -> {
                        return leftOperand - rightOperand;
                    }
                    case "*" -> {
                        return leftOperand * rightOperand;
                    }
                    case "/" -> {
                        return leftOperand / rightOperand;
                    }
                }
            } else {
                return Double.parseDouble(node.data);
            }
        }
        return 0;
    }

    void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }

    void postOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        ExpressionTree et = new ExpressionTree();

        String postfixExpression = "123*4/+";

        et.create(postfixExpression);
        et.inOrderTraversal(et.root);
        System.out.println("\n" + et.evaluate(et.root));
    }
}

class TreeNode {

    TreeNode left;
    String data;
    TreeNode right;

    public TreeNode(String data) {
        this.left = null;
        this.data = data;
        this.right = null;
    }
}
