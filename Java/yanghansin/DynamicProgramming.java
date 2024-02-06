package feb;

public class DynamicProgramming {

  // LeetCode 70 Climbing Stairs
  public int climbStars(int n) {
    // define dp[k] as number of ways to climb up to k stairs
    // then consider dp[k - 1], dp[k - 2].
    // since we ensure that climbing 1 step from k - 1 to k, and climbing 2 steps from k - 2 to k are two
    // different ways of reaching k;
    // develop the state transition function: dp[k] = dp[k - 1]  + dp[k - 2]
    // base case:

    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }

    return dp[n];
  }
}
