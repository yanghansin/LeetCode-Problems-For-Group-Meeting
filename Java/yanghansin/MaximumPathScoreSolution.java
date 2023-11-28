/* By Han Yang
 * 2023/11/27
 * 
 * Given a matirx of integers A with R rows and C columns, find the maximum score of path starting at 
 * (0, 0) and ending at (R - 1, C - 1)
 * the score of the path is the minimum value in that path
 * Input = 
 * [[5, 2, 3]
 *  [6, 3, 1]
 *  [5, 7, 8]]
 * 
 * Path1: 5-2-3-1-8, Score = 1
 * Path2: 5-2-3-7-8, Score = 2
 * Path3: 5-6-5-7-8, Score = 5
 * Path4: 5-6-3-7-8, Score = 3
 * ......
 * Maximum Score out of all path: 5
 */

import java.util.Random;

public class MaximumPathScoreSolution {
    public static int maxScore(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 1; i < rows; i++) {
            grid[i][0] = Math.min(grid[i - 1][0], grid[i][0]);
        }
        
        for (int j = 1; j < cols; j++) {
            grid[0][j] = Math.min(grid[0][j - 1], grid[0][j]);
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                int upPathScore = Math.min(grid[i - 1][j], grid[i][j]);
                int leftPathScore = Math.min(grid[i][j - 1], grid[i][j]);
                grid[i][j] = Math.max(upPathScore, leftPathScore);
            }
        }

        return grid[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        int[][] test_grid = {{5, 2, 3}, {6, 3, 1}, {5, 7, 8}};
        System.out.println(maxScore(test_grid));
        int[][] randomMatrix = new int[5][5];

        // Create a Random object
        Random random = new Random();

        // Fill the matrix with random numbers in the range 15-30
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                // Generate a random number between 15 and 30 (inclusive)
                int randomNumber = random.nextInt(16) + 15;
                randomMatrix[i][j] = randomNumber;
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(randomMatrix[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println(maxScore(randomMatrix));
    }
}
