import java.util.PriorityQueue;
/*
 * Author: Han Yang
 * Date: 2023/11/16
 * LeetCode 23: Merge k Sorted Lists (Consider input as int[] instead of ListNode)
*/

class Element {
    int val;
    int list_index;
    int val_index;
    public Element (int val, int list_index, int val_index) {
        this.val = val;
        this.list_index = list_index;
        this.val_index = val_index;
    }
}

public class MergeKSortedListsSolution {
    public static int[] MergeKSortedLists (int[][] l) {
        if (l == null || l.length == 0) {
            return new int[] {};
        }

        int size = 0;
        System.out.println("====================");
        System.out.println("Lists to be merged: ");
        for (int[] list : l) {
            for (int val : list) {
                System.out.print(val);
                size++;
            }

            System.out.println();
        }
        int[] res = new int[size];

        PriorityQueue<Element> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        int list_index = 0;
        for (int[] list : l) {
            minHeap.offer(new Element(list[0], list_index++, 0));
        }

        int res_ptr = 0;
        while (!minHeap.isEmpty()) {
            Element currElement = minHeap.poll();
            res[res_ptr++] = currElement.val;
            if (currElement.val_index + 1 < l[currElement.list_index].length){
                int nextVal = l[currElement.list_index][currElement.val_index + 1];
                int nextListIndex = currElement.list_index;
                int nextValIndex = currElement.val_index + 1;
                minHeap.offer(new Element(nextVal, nextListIndex, nextValIndex));
            }

        }

        return res;
    }

    public static void main(String[] args) {
        int[] list1 = {1, 3, 5, 6, 7};
        int[] list2 = {2, 3, 4};
        int[] list3 = {2, 5, 6, 7};

        int[] test_res1 = MergeKSortedLists(new int[][] {list1, list2, list3});

        System.out.println("================");
        System.out.println("Merged List: ");
        printList(test_res1);

        

    }

    public static void printList(int[] list) {
        for (int i : list) {
            System.out.print(i);
        }
        System.out.println();
    }
}
