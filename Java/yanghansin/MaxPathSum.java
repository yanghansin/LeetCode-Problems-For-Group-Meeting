import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode (int val) {
        this.val = val;
        left = right = null;
    }
}
public class MaxPathSum {

    public static int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxPathSum(root.left), maxPathSum(root.right)) + root.val; 
    }



    public static List<Integer> res = new ArrayList<>();
    public static int maxSum = Integer.MIN_VALUE;
    public static List<Integer> getMaxPathValues(TreeNode root) {
        List<Integer> currentPath = new ArrayList<>();
        dfs(root, 0, currentPath);
        return res;
    }


    private static void dfs(TreeNode root, int currentSum, List<Integer> currentPath) {
        if (root == null) {
            return;
        }

        currentSum += root.val;
        currentPath.add(root.val);
        if (root.left == null && root.right == null) {
            if (currentSum > maxSum) {
                res = new ArrayList<>(currentPath);
            }
        }

        dfs(root.left, currentSum, currentPath);
        dfs(root.right, currentSum, currentPath);

        currentPath.remove(currentPath.size() - 1);
    }




    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> test = getMaxPathValues(root);
        for (Integer i : test) {
            System.out.println(i);
        }

    }
}


