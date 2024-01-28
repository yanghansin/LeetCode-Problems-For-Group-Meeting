class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        cols = len(matrix[0])-1
        rows = len(matrix)-1
        heap = []
        for i in range(rows+1):
            # put the min num of every row in the heap
            heapq.heappush(heap, (matrix[i][0], i, 0)) # value, row, col
        
        for j in range(k):
            temp = heapq.heappop(heap)

            # if the cell's col is not the right boundary, add its right cell to the heap
            if temp[2] < rows:
                heapq.heappush(heap, (matrix[temp[1]][temp[2] + 1], temp[1], temp[2] + 1))
        return temp[0]
    