/*
 * @lc app=leetcode id=435 lang=java
 *
 * [435] Non-overlapping Intervals
 */

// @lc code=start

import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        return n - intervalSchedule(intervals);
    }
    
    private int intervalSchedule(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        int result = 1;
        int endTime = intervals[0][1];
        for (int[] interval: intervals) {
            int startTime = interval[0];
            if (startTime >= endTime) {
                result++;
                endTime = interval[1];
            }
        }
        return result;
    }
}
// @lc code=end

