import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringJoiner;


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
public class TreeProblems {

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

    // P1, get the height of tree by BFS
    public static int HeightOfTreeBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        
        int level = 0;
        while (!q.isEmpty()) {
            for (int i = 0; i < q.size(); i++) {
                TreeNode curr = q.poll();
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            level++;
        }

        return level;
    }

    // P2, get the height of tree by DFS
    public static int HeightOfTreeDFS(TreeNode root, int level) {
        if (root == null) {
            return level - 1;
        }

        int leftHighest = HeightOfTreeDFS(root.left, level + 1);
        int rightHightest = HeightOfTreeDFS(root.right, level + 1);

        return Math.max(leftHighest, rightHightest);
    }


    // P3, binary Tree preorder Traversal
    public static List<Integer> PreorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Traverse(root, result);
        return result;
    }

    public static void Traverse(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        Traverse(root.left, res);
        Traverse(root.right, res);
    }

    // P4, Level Order Traversal
    public static List<List<Integer>> LevelOrderTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int qSize = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < qSize; i++) {
                TreeNode currNode = q.poll();
                level.add(currNode.val);
                if (currNode.left != null) {
                    q.offer(currNode.left);
                }

                if (currNode.right != null) {
                    q.offer(currNode.right);
                }
            }
            res.add(level);
        }

        return res;
    }

    // P5 Judge if a binary tree is balanced or not
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Height(root) == -1) {
            return false;
        }

        return true;
    }

    private static int Height(TreeNode root) {  
        if (root == null) {
            return 0;
        }

        int leftHeight = Height(root.left);
        int rightHeight = Height(root.right);
        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }


    // P6 Reverse a Tree
    public static void ReverseTree(TreeNode root) {

        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }

        else if (root.left == null && root.right != null) {
            root.left = root.right;
            root.right = null;
        }

        else if (root.left != null && root.right == null) {
            root.right = root.left;
            root.left = null;
        }
        else {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }


        ReverseTree(root.left);
        ReverseTree(root.right);
    }


    // Question1 Largest Value in Each Level
    public static List<Integer> getLargestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                max = Math.max(current.val, max);

                if (current.left != null) {
                    q.offer(current.left);
                }

                if (current.right != null) {
                    q.offer(current.right);
                }
            }
            res.add(max);
        }

        return res;
    }

    // 5 min 21


    // Question 3: Identical Trees
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // Question 4: Mirror the Tree
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;

        if (root.left != null) {
            invertTree(root.left);
        }

        if (root.right != null) {
            invertTree(root.right);
        }

        return root;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        //root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        //root.right.right = new TreeNode(7);


        // Height Test
        System.out.println("By BFS, the Height of Tree is: "  + HeightOfTreeBFS(root));
        System.out.println("By DFS, the Height of Tree is: " + HeightOfTreeDFS(root, 1));


        // Preorder/Inorder/Postorder Traversal Test
        List<Integer> preOrder_arr = PreorderTraversal(root);
        StringJoiner joiner = new StringJoiner(", ");
        for (Integer num : preOrder_arr) {
            joiner.add(num.toString());
        }
        System.out.println("Preorder Traversal of this Tree is: " + joiner.toString());

        // Levelorder Traversal Test
        List<List<Integer>> levelOrder_arr = LevelOrderTraversal(root);
        System.out.println("Level Order Traversal: ");
        for (List<Integer> innerList : levelOrder_arr) {
            for (Integer num : innerList) {
                System.out.print(num + " ");
            }
            System.out.println(); 
        }

        ReverseTree(root);
        List<List<Integer>> reversed = LevelOrderTraversal(root);
        System.out.println("Level Order Traversal: ");
        for (List<Integer> innerList : reversed) {
            for (Integer num : innerList) {
                System.out.print(num + " ");
            }
            System.out.println(); 
        }

        // Question 1 test 
        List<Integer> res = getLargestValues(root);
        System.out.println("Largest Value At Each Level: ");
        for (int i : res) {
            System.out.println(i);
        }



    }
}

