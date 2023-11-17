/*
 * Author: Han Yang
 * Date: 2023/11/16
 * LeetCode 21: Merge Two Sorted Lists (Consider input as int[] instead of ListNode)
*/
public class MergeTwoSortedListsSolution {
    
    public static int[] MergeTwoSortedLists(int[] list1, int[] list2) {
        if (list1.length == 0) {
            return list2;
        }
        if (list2.length == 0) {
            return list1;
        }

        int l1_ptr = 0;
        int l2_ptr = 0;
        int res_ptr = 0;
        int[] res = new int[list1.length + list2.length];

        while (l1_ptr < list1.length && l2_ptr < list2.length) {
            if (list1[l1_ptr] <= list2[l2_ptr]) {
                res[res_ptr] = list1[l1_ptr++];
            } else {
                res[res_ptr] = list2[l2_ptr++];
            }
            res_ptr++;
        }

        while (l1_ptr < list1.length) {
            res[res_ptr++] = list1[l1_ptr++];
        }

        
        while (l2_ptr < list2.length) {
            res[res_ptr++] = list2[l2_ptr++];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] list1 = {1, 3, 5, 6, 7};
        int[] list2 = {};
        int[] list3 = {2, 5, 6, 7};

        int[] test_res1 = MergeTwoSortedLists(list1, list2);
        int[] test_res2 = MergeTwoSortedLists(list2, list3);
        int[] test_res3 = MergeTwoSortedLists(list1, list3);

        printList(test_res1);
        
        printList(test_res2);
        
        printList(test_res3);

    }

    public static void printList(int[] list) {
        for (int i : list) {
            System.out.print(i);
        }
        System.out.println();
    }
}
