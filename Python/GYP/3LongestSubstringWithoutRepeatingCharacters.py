# sliding window
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        mp = {} # record the last position of a char + 1 记录如果遇到了该字母需要从第几个开始下一轮
        res = 0
        length = len(s)
        i = 0
        for j in range(length):
            if s[j] in mp:
                i = max(mp[s[j]], i) # find the index of last s[j] + 1, and update i if the location is right to i
            res = max(res, j-i+1)
            mp[s[j]] = j + 1
        return res      