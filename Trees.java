
import java.util.*;
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

    // Level Order Traversal (BFS)
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

    public static void recLevelorder(TNode root) {
        List<List<Integer>> result = new ArrayList<>();
        bfs(root, 0, result);
        System.out.println(result);
    }

    public static void bfs(TNode node, int level, List<List<Integer>> ans) {
        if (node == null) {
            return;
        }
        if (level == ans.size()) {
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(node.data);
        bfs(node.left, level + 1, ans);
        bfs(node.right, level + 1, ans);
    }

    // Preorder, Inorder, Postorder Traversals
    // Preorder: Root -> Left -> Right
    public static void preorder(TNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void iterativePreorder(TNode root) {
        if (root == null) {
            return;
        }
        Stack<TNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TNode curr = stack.pop();
            System.out.print(curr.data + " ");
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
    }

    // Postorder: Left -> Right -> Root
    public static void postorder(TNode root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void iterativePostorder(TNode root) {
        if (root == null) {
            return;
        }
        Stack<TNode> stack1 = new Stack<>();
        Stack<TNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TNode curr = stack1.pop();
            stack2.push(curr);
            if (curr.left != null) {
                stack1.push(curr.left);
            }
            if (curr.right != null) {
                stack1.push(curr.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().data + " ");
        }
    }

    // Inorder: Left -> Root -> Right
    public static void inorder(TNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void iterativeInorder(TNode root) {
        if (root == null) {
            return;
        }
        Stack<TNode> stack = new Stack<>();
        TNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
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
        System.out.println("Tree elements in preorder:");
        preorder(root);
        System.out.println("\nTree elements in inorder:");
        inorder(root);
        System.out.println("\nTree elements in postorder:");
        postorder(root);
        // System.out.println("Tree elements in level order:");
        // levelOrderTraversal();
        // recLevelorder(root);
    }
}
