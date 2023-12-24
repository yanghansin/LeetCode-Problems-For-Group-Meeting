import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
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
    public static boolean isBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraverse(root, inorder);

        for (int i = 0; i < inorder.size() - 1; i++) {
            if(inorder.get(i) < inorder.get(i + 1)) {
                return false;
            }
        }

        return true;
    }
    private static void inorderTraverse(TreeNode root, List<Integer> inorder) {
        if (root == null) {
            return;
        }

        inorderTraverse(root.left, inorder);  
        inorder.add(root.val);
        inorderTraverse(root.right, inorder);
     }

     // 4 min 46s

    public static int uniqueBST(int n) {
        int[] dp = new int[n + 1];
        
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n  + 1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }

    // 7 min 21s


    private static TreeNode first, second, prev = null;
    public static void recoverTree(TreeNode root) {
        inorderTraverse(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }

    private static void inorderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
                second = root;
            }
        }

        prev = root;
        inOrder(root.right);


    }

    // 12min 29s
    // Question 2 Construct BST from given level order traversal
    public static TreeNode buildBSTbyLevel(int[] level) {
        if (level == null || level.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(level[0]);
        for (int i = 1; i < level.length; i++) {
            add(root, new TreeNode(level[i]));
        }

        return root;
    }

    private static void add (TreeNode root, TreeNode newNode) {
        if (newNode.val < root.val) {
            if (root.left != null) {
                add(root.left, newNode);
            } else {
                root.left = newNode;
            }
        } else {
            if (root.right != null) {
                add(root.right, newNode);
            } else {
                root.right = newNode;
            }
        }
    }

    // LeetCode 230 Kth Smallest Element in BST
    public static int kthSmallestBST(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraverse(root, inorder);

        return inorder.get(k - 1);
    }

    public static void main(String[] args) {
                // question 2 test
        int[] test2 = new int[] {7, 4, 12, 3, 6, 8, 1, 5, 10};
        TreeNode testNode = buildBSTbyLevel(test2);
        preOrder(testNode);
        System.out.println();
        inOrder(testNode);
        System.out.println();
        postOrder(testNode);
    }
}

