/*
 * @lc app=leetcode id=1288 lang=java
 *
 * [1288] Remove Covered Intervals
 */

// @lc code=start

// Time Complexity: O(NlogN) since the sorting dominates the complexity of the algorithm
// Space Complexity: O(N) or O(logN) - In Java, the Arrays.sort() is implemented as a variant of quicksort algorithm whose space complexity is O(logN).
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // Sort by start point.
                // If two intervals share the same start point,
                // put the longer one to be the first.
                return o1[0] == o2[0] ? o2[1] - o1[1]: o1[0] - o2[0];
            }
        });

        int count = 0;
        int end, prev_end = 0;
        for (int[] curr: intervals) {
            end = curr[1];
            if (prev_end < end) {
                count++;
                prev_end = end;
            }
        }
        return count;
    }
}
// @lc code=end

