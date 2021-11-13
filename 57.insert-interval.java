import java.util.LinkedList;

/*
 * @lc app=leetcode id=57 lang=java
 *
 * [57] Insert Interval
 */

// @lc code=start

// Method: Greedy Algorithm
// Time Complexity: O(n) since it's one pass along the input array
// Space Complexity: O(n) since we allocate an array to keep the output
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int newStart = newInterval[0], newEnd = newInterval[1];
        int index = 0, intervalLength = intervals.length;
        LinkedList<int[]> result = new LinkedList<>();
        while (index < intervalLength && newStart > intervals[index][0]) {
            result.add(intervals[index++]);
        }
        int[] interval = new int[2];
        if (result.isEmpty() || result.getLast()[1] < newStart) {
            result.add(newInterval);
        } else {
            interval = result.removeLast();
            interval[1] = Math.max(interval[1], newEnd);
            result.add(interval);
        }

        while (index < intervalLength) {
            interval = intervals[index++];
            int start = interval[0], end = interval[1];
            if (result.getLast()[1] < start) {
                result.add(interval);
            } else {
                interval = result.removeLast();
                interval[1] = Math.max(interval[1], end);
                result.add(interval);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}
// @lc code=end

