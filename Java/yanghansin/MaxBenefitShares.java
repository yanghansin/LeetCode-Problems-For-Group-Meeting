public class MaxBenefitShares {
    static void printMatrix(int[][] dp) {
        int rows = dp.length;
        int cols = dp[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int MaxBenefit(int [] values, int[] weights, int capacity) {
        int rows = values.length;
        int cols = capacity;

        int[][] dp = new int[rows + 1][cols + 1];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= cols; j++) {
                if (weights[i] <= j) {
                    dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - weights[i]] + values[i]);
                }else {
                    dp[i + 1][j] = dp[i][j];
                }
            }
        }
        printMatrix(dp);
        return dp[rows][cols];
    }

    public static void main(String[] args) {
        int[] values = new int[] {25, -8, 19, 18, 36};
        int[] weight = new int[] {175, 133, 109, 210, 97};
        int capacity = 250;

        System.out.println(MaxBenefit(values, weight, capacity));
    }

}
