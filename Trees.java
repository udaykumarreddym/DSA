
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


    private static int height(TNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    private static int balancedTree(TNode root){
        if(root == null){
            return 0;
        }
        int left = balancedTree(root.left);
        if(left == -1) return -1;
        int right = balancedTree(root.right);
        if(right == -1) return -1;
        if(Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
    static int maxDiameter = 0;
    private static int diameterOfTree(TNode root){
        diameter(root);
        return maxDiameter;
    }
    private static int diameter(TNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = diameter(root.left);
        int rightHeight = diameter(root.right);
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    static int maxpsum = Integer.MIN_VALUE;
    private static int maxPathsum(TNode root){
        maxPath(root);
        return maxpsum;
    }
    private static int maxPath(TNode root){
        if(root == null){
            return 0;
        }
        int left = Math.max(0, maxPath(root.left));
        int right = Math.max(0, maxPath(root.right));
        maxpsum = Math.max(maxpsum, left + right + root.data);
        return root.data + Math.max(left, right);
    }
    public static void main(String[] args) {
        root = new TNode(10);
        root.left = new TNode(20);
        root.right = new TNode(30);
        root.left.left = new TNode(40);
        root.left.right = new TNode(50);
        root.right.left = new TNode(60);
        root.right.right = new TNode(70);
        root.left.left.left = new TNode(80);
        // System.out.println("Tree elements in preorder:");
        // preorder(root);
        // System.out.println("\nTree elements in inorder:");
        // inorder(root);
        // System.out.println("\nTree elements in postorder:");
        // postorder(root);
        // System.out.println("Tree elements in level order:");
        // levelOrderTraversal();
        // recLevelorder(root);
        System.out.println("Height of tree: "+height(root));
        System.out.println("Is balanced tree: "+(balancedTree(root)!=-1));
        System.out.println("Diameter of tree: "+diameterOfTree(root));
        System.out.println("Max path sum of tree: "+maxPathsum(root));
    }
}
