# minheap size = number of lists = K
# number of nodes = n
# time complexity = nlog(k)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:

        heap = []
        for i in range(len(lists)):
            if lists[i]:
                heapq.heappush(heap, (lists[i].val, i))
        
        res = dummy = ListNode()

        while heap:
            val, index = heapq.heappop(heap)
            dummy.next = ListNode(val)
            dummy = dummy.next
            if lists[index].next:
                lists[index] = lists[index].next
                heapq.heappush(heap, (lists[index].val, index))
    
        return res.next