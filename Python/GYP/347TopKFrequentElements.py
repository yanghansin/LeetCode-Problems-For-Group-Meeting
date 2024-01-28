class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # klog(n)
        
        dic = {}
        for num in nums:
            if num in dic.keys():
                dic[num] += 1
            else:
                dic[num] = 0
        
        heap = []

        for key in dic.keys():
            #python自带的heap是minheap，所以取负数
            heapq.heappush(heap, (-dic[key], key))
        
        res = []
        
        for i in range(k):
            res.append(heapq.heappop(maxheap)[1])
            
        return res