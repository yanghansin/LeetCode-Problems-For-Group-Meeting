# 560. Subarray Sum Equals K

'''prefix sum (time n^2, space n)
nums = [1, 2, 3, 4, 5]
s = [0, 1, 3, 6, 10, 15] # this is the sum before this index
s[1] - s[0] # this is the sum nums[0] to nums[1]
s[2] - s[0] 
...
s[2] - s[1]
'''

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:


'''hashtable (On)
sum(nums[i:j]) == k
sum[j] - sum[i] == k
sum[j] = sum[i] + k 
i < j

add the sum to hashtable one by one
check if a new sum, (sum-k) is in the dict
'''
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        sum = 0 # sum of empty array
        dict = {0:1} # add the sum 0 to the dict
        length = len(nums)
        count = 0 # count the result
        for i in range(length):
            sum += nums[i] # get the new sum
            diff = sum - k # the difference between sum and k
            if diff in dict.keys(): # find if the difference has shown up in the dict
                count += dict[diff] # add the times the difference show up in the prefix
            if sum not in dict.keys(): # add the pref sum to the dict
                dict[sum] = 0
            dict[sum] += 1
        return count

