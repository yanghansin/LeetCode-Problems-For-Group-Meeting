class Solution:
    def nthUglyNumber(self, n: int) -> int:
        # time: nlog(n)
        # space: n
        heap = [1]
        nums = {2, 3, 5}
        count = 0
        visited = set() # prevent the repeated nums, record the ugly nums 
        while count < n:  # n times
            min = heapq.heappop(heap) # log(n) times
            if min in visited:
                continue
            for num in nums:
                heapq.heappush(heap, num*min)
                visited.add(min)
            count += 1
        
        return min

# best solution:
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        ans = [1]
        ptr2 = ptr3 = ptr5 = 0 # pointers for 2's multiples, 3's multiples, 5's multiples
        ugly = 1
        for _ in range(n-1):
            ugly = min(ans[ptr2]*2, ans[ptr3]*3, ans[ptr5]*5)
            ans.append(ugly)
            if ugly == ans[ptr2]*2:
                ptr2 += 1
            if ugly == ans[ptr3]*3:
                ptr3 += 1
            if ugly == ans[ptr5]*5:
                ptr5 += 1
        return ans[-1]
    
