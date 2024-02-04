# sliding window O(n)  O(m)(m=number of chars in the s)
class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        left = 0
        map = {} # frequency map
        maxFreq = 0
        size = 0
        for right in range(len(s)):
            # every time move the window:
            # 1/update the hashmap
            map[s[right]] = map.get(s[right], 0)+1
            # 2/update the maxFrequency
            maxFreq = max(maxFreq, map[s[right]])

            # move the left ptr to right if:
            # the cur window is NOT valid (window size > k + maxFrequency)
            if right - left + 1 > maxFreq +k: # if the window is not valid
                # update map
                map[s[left]] -= 1
                left += 1
            
            # the window is valie at this point, store length
            # size of the window never decreases
            size = right - left + 1
    
        return size