import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
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
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }

    // 7 min 21s


    private static TreeNode first, second, prev = null;
    public static void recoverTree(TreeNode root) {
        inOrder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }

    private static void inOrder(TreeNode root) {
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
}

