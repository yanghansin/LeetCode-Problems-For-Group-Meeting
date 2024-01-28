import java.io.PipedReader;
import java.util.*;

public class HeapProblems {
    /*
     * LeetCode 23 Merge K Sorted Lists
     * Given Lists of ListNodes, which are heads of sorted linked lists.
     * Merge and sort them into 1 linked lists
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }

        }

        ListNode dummy = new ListNode(0);
        ListNode head = new ListNode();
        dummy.next = head;
        while (!pq.isEmpty()) {
            ListNode current = pq.poll();
            head = current;
            head = head.next;

            if (current.next != null) {
                pq.offer(current.next);
            }
        }
        return dummy.next;
    }

    /*
       LeetCode 264 UglyNumber II
       A number is ungly number if its prime factors are limited to 2, 3, and 5
       given an integer n, return the nth ugly number
     */

    public int nthUglyNumber(int n) {
        PriorityQueue <Long> pq = new PriorityQueue<>(Long::compare);
        pq.offer(1L);

        for (int i = 0; i < n - 1; i++) {
            long curr = pq.poll();
            if (!pq.contains(curr * 2)) {
                pq.offer(curr * 2);
            }

            if (!pq.contains(curr * 5)) {
                pq.offer(curr * 5);
            }

            if (!pq.contains(curr * 3)) {
                pq.offer(curr * 3);
            }
        }

        long ans = pq.poll();
        return (int) ans;
    }

    /*
        LeetCode 347 Top K Frequent Elements
        Given an Integer Array, and an integer k, return the k most frequent elements. You may return the answer in any order
     */

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue <Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(freq.get(b), freq.get(a)));
        for (int key : freq.keySet()) {
            pq.offer(key);
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            if (!pq.isEmpty()) {
                res[i] = pq.poll();
            }

        }
        return res;

    }

    /*
        LeetCode 378 Kth Smallest Elements in a Sorted Matrix
        Given NxN matrix where each of the rows and columns is sorted in ascending order,
        return the kth smallest element in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col ++) {
                maxHeap.offer(matrix[row][col]);
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }

        return maxHeap.poll();
    }

    /*
        LeetCode 658 Find K Closest Elements
        Given a sorted integer arr, two integer x and k, return the k closest integers to x in the array.
        the array should be sorted in ascending order
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Comparator<Integer> customComparator = (a, b) -> {
            int absDiffA = Math.abs(x - a);
            int absDiffB = Math.abs(x - b);
            int result = Integer.compare(absDiffA, absDiffB);

            if (result == 0) {
                result = Integer.compare(a, b);
            }
            return result;
        };

        PriorityQueue<Integer> pq = new PriorityQueue<>(customComparator);
        for (int i : arr) {
            pq.offer(i);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(pq.poll());
        }
        Collections.sort(res);
        return res;
    }
}

