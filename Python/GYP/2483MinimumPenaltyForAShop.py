# https://leetcode.com/problems/minimum-penalty-for-a-shop/description/

# 不用计算出实际的penalty
# 先假设店铺一直关门，以此为基础进行下一步计算

class Solution:
    def bestClosingTime(self, customers: str) -> int:
        # suppose that the penalty is 0 when the shop always close
        prefix, suffix, ans, pen = 0, 0, 0, 0
        for i in range(len(customers)):
            if customers[i] == 'Y':
                suffix -= 1
            else:
                prefix += 1
            if prefix + suffix < pen:
                ans = i+1
                pen = prefix + suffix
        return ans

