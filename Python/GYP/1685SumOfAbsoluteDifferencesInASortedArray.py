# https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/description/


# 数轴
class Solution:
    def getSumAbsoluteDifferences(self, nums: List[int]) -> List[int]:
        res = []
        sum = 0

        for num in nums:
            sum += num - nums[0]
            
        res.append(sum)
        length = len(nums)
        print(res, length)

        for i in range(1, length):
            diff = nums[i] - nums[i-1]
            diffleft = diff * i
            diffright = diff * (length - i)
            res.append(res[i-1] + diffleft - diffright)
        return res

# prefix and suffix
class Solution:
    def getSumAbsoluteDifferences(self, nums: List[int]) -> List[int]:
        prefix, suffix = 0, 0
        for num in nums:
            suffix += num
        print(suffix)
        
        res = []
        length = len(nums)
        for i in range(length):
            sufsum = suffix - nums[i]*(length-i-1)
            presum = nums[i]*(i-1) - prefix
            res.append(sufsum + presum)
            suffix -= nums[i]
            prefix += nums[i]

        return res