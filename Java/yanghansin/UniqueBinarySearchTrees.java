class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode (int val) {
        this.val = val;
        left = right = null;
    }
}

// LeetCode 95 Unique Binary Search Trees I and II
// By Han Yang
// 2023/12/19
public class UniqueBinarySearchTrees {
    
    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(numTrees(5));
    }
}
