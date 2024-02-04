# dp
class Solution:
    def rob(self, nums: List[int]) -> int:
        length = len(nums)

        if length == 1:
            return nums[0]
    
        dp = [0] * length

        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])

        for i in range(2, length):
            dp[i] = max(nums[i] + dp[i-2], dp[i-1])
        
        return dp[length-1]
    

# less space
class Solution:
    def rob(self, nums: List[int]) -> int:
        length = len(nums)

        if length == 1:
            return nums[0]
    
        dp = [0] * length

        preFirst = nums[0]
        preSecond = max(nums[0], nums[1])

        for i in range(2, length):
            temp = preSecond
            preSecond = max(nums[i] + preFirst, temp)
            preFirst = temp
        
        return preSecond