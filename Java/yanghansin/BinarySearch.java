/* By Han Yang
 * 2023/12/07
 * LeetCode 701, 34, 162, 153
 */

public class BinarySearch {

    // LeetCode 701 Binary Search
    // return the index of target in nums, if not found, return -1
    public static int BaseBinarySearch(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                return mid;
            }
        }

        if (nums[left] == target) {
            return left;
        }

        if (nums[right] == target) {
            return right;
        }

        return -1;
    }

    // LeetCode 34 First and Last Position of Element in Sorted Array
    // search the very first occurence of target and return its index
    // if not found, return -1
    public static int BinarySearchFirst(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (nums[left] == target) {
            return left;
        } 

        if (nums[right] == target) {
            return right;
        }

        return -1;
    }

    // search the very last occurence of target and return its index
    // if not found, return -1
    public static int BinarySearchLast(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        if (nums[right] == target) {
            return right;
        }

        if (nums[left] == target) {
            return left;
        } 

        return -1;
    }

    // Leetcode 162 Find Peak Element
    // it is ensured that there's one and only one PEAK element in inputed list
    // return the index of this PEAK 
    public static int BinarySearchPeak(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= nums[mid - 1] && nums[mid] <= nums[mid + 1]) {
                left = mid;
            } else if (nums[mid] <= nums[mid - 1] && nums[mid] >= nums[mid + 1]) {
                right = mid;
            } else {
                return mid;
            }
        }

        return nums[left] > nums[right] ? left : right;
    }

    // LeetCode 153 Find Minimum in Rotated Sorted Array
    // Find minimum in Rotated Sorted Array
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int target = nums[right];

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                left = mid;
            }else{
                right = mid;
            }
        }

        return Math.min(nums[left], nums[right]);
    }

}
