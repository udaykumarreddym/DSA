
import java.util.LinkedList;
import java.util.Queue;

public class Trees {

    static class TNode {

        int data;
        TNode left;
        TNode right;

        TNode(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    public static TNode root;

    public static void levelOrderTraversal() {
        Queue<TNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TNode temp = queue.remove();
            if (temp == null) {
                if (queue.isEmpty()) {
                    break;
                } else {
                    System.out.println();
                    queue.add(null);
                }
            } else {
                System.out.print(temp.data + " ");
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        root = new TNode(10);
        root.left = new TNode(20);
        root.right = new TNode(30);
        root.left.left = new TNode(40);
        root.left.right = new TNode(50);
        root.right.left = new TNode(60);
        root.right.right = new TNode(70);
        System.out.println("Tree elements in level order:");
        levelOrderTraversal();
    }
}
