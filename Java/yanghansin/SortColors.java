public class SortColors {
    // leetcode 75 Sort Colors
    // By Han Yang
    // 2023/12/21

    public static void sortColorsDoublePointers(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int curr = left;

        while (curr <= right) {
            if (nums[curr] == 0) {
                swap(left, curr, nums);
                left++;
                curr++;
            } else if (nums[curr] == 2) {
                swap(right, curr, nums);
                right--;
            } else {
                curr++;
            }
        }
    }

    private static void swap (int left, int right, int[] nums) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    private static void printList(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] sortColors_test_1 = new int[] {2, 0, 2, 1, 1, 0}; // Expecting {0, 0, 1, 1, 2, 2}
        int[] sortColors_test_2 = new int[] {2, 0, 1}; // Expecting {0, 1, 2}
        sortColorsDoublePointers(sortColors_test_1);
        sortColorsDoublePointers(sortColors_test_2);

        printList(sortColors_test_1);
        printList(sortColors_test_2);
    }
}
