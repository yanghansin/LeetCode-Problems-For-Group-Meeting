import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    // LeetCode 57
    /* You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] 
    represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. 
    You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
    Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals 
    still does not have any overlapping intervals (merge overlapping intervals if necessary). */

    public static int[][] insertLS(int[][] intervals, int[] newInterval) {
        intervals = insertInterval(intervals, newInterval);

        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int[] curr = {intervals[i][0], intervals[i][1]};
            while (i < intervals.length && overlapsOrNot(curr, intervals[i])) {
                mergeIntervals(curr, intervals[i]);
                i++;
            }
            i--;
            ans.add(curr);
        }

        return ans.toArray(new int[ans.size()][2]);
    }

    public static boolean overlapsOrNot(int[] a, int[] b) {
        int minEnd = Math.min(a[1], b[1]);
        int maxStart = Math.max(a[0], b[0]);

        return minEnd - maxStart >= 0;
    }

    public static int[] mergeIntervals(int[] a, int[] b) {
        int[] newInterval = {Math.min(a[0], b[0]), Math.max(a[1], b[1])};
        return newInterval;
    }

    public static int[][] insertInterval(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[0] < intervals[i][0]) {
                list.add(i, newInterval);
                break;
            }
        } 

        if (list.size() == intervals.length) {
            list.add(newInterval);
        }

        return list.toArray(new int[list.size()][2]);
    }
}
