class Solution:
    def increasingTriplet(self, nums: List[int]) -> bool:

        length = len(nums)
        n1 = 2**31 - 1
        n2 = 2**31 - 1
        for i in range(length):
            if nums[i] <= n1:
                n1 = nums[i]
            elif nums[i] <= n2:
                n2 = nums[i]
            else:
                return True
        return False
            