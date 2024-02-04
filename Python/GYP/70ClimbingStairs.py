# dp
class Solution:
    def climbStairs(self, n: int) -> int:        
        if n == 1:
            return 1
        if n == 2:
            return 2

        dp = [0] * n
        dp[0] = 1
        dp[1] = 2

        for i in range (2, n):
            dp[i] = dp[i-2] + dp[i-1]

        return dp[n-1]


# less space with scrolling array
class Solution:
    def climbStairs(self, n: int) -> int:        
        if n == 1:
            return 1
        if n == 2:
            return 2

        preFirst = 1
        preSecond = 2

        for i in range (2, n):
            temp = preSecond
            preSecond += preFirst
            preFirst = temp

        return preSecond