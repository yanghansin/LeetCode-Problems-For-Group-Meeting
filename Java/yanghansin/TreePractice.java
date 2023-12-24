
// Some TreeProblems
// Pre/In/Post Traversal
// Level Order Traversal
// Height of the Tree
// Reverse the Tree
// Is blalanced Tree or not


// By Han Yang
// 2023/12/19
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode (int val) {
        this.val = val;
        left = right = null;
    }
}
public class TreePractice {

    public static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    // Function to print the in-order traversal of a binary tree
    public static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }

    // Function to print the post-order traversal of a binary tree
    public static void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + " ");
        }
    }

    // Q1 Judge if a bianry tree is Sum Tree. A sum tee is the tree where 
    // value of nodes equal to the sum of nodes present on the left subtree and right subtree

    public static boolean isSumTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        int leftSum = sum(root.left);
        int rightSum = sum(root.right);

        if (root.val == leftSum + rightSum) {
            return isSumTree(root.left) && isSumTree(root.right);
        } else {
            return false;
        }
    }

    private static int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return sum(root.left) + root.val + sum(root.right);
    }

    // Q2. Judge if a Binary Tree is Perfect Binary Tree or not
    // A perfect binary tree is a tree where every nodes has two childrens and
    // the leaf nodes are all at same level
    public static boolean isPerfectTree(TreeNode root) {
        int height = height(root);
        return isPerfect(root, height, 0);
    }

    private static int height(TreeNode root) {
        if (root == null) {
            return 0;        
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }

    private static boolean isPerfect(TreeNode root, int height, int level) {
        if (root == null) {
            return true;
        }

        if ((root.left == null && root.right == null) ||
            (root.left != null && root.right != null)) {
                if (level == height - 1) {
                    return true;
                } else {
                    return isPerfect(root.left, height, level + 1) &&
                           isPerfect(root.right, height, level + 1);
                }
        }

        return false;
    }

    // Question3 Find Subtree with maximum sum in tree
    public static int maxSum = 0;
    public static int maxSumInTree(TreeNode root) {
        sumOfSubTree(root);
        return maxSum; 
    }

    public static int sumOfSubTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = root.val + sumOfSubTree(root.left) + sumOfSubTree(root.right);
        maxSum = Math.max(maxSum, sum);
        return sum;
    }
    public static void main(String args[]) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        // root.right.left = new TreeNode(6);

        if (isPerfectTree(root)) {
            System.out.println("The tree is a perfect binary tree");
        } else {
            System.out.println("The tree is not a perfect binary tree");
        }
    }

}


