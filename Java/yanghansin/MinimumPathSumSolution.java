/* By Han Yang
    11/27/2023
    LeetCode 64 minPathSum
*/
public class MinimumPathSumSolution {
    public static int minPathSum(int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 1; i < rows; i++) {
            grid[i][0] += grid[i - 1][0];
        }
    
        for (int j = 1; j < cols; j++) {
            grid[0][j] += grid[0][j - 1];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        int[][] test_grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] test_grid2 = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(minPathSum(test_grid));
        System.out.println(minPathSum(test_grid2));
    }
}
