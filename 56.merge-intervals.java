/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start


// Method 1: Sorting
// Time Complexity: O(nlogn) - Other than the sort invocation, we do a simple linear scan of the list
// Space Complexity: O(logN) - If we can sort intervals in place, we don't need more than constant additional space although the sorting itself takes O(logn) space.
// class Solution {
//     public int[][] merge(int[][] intervals) {
//         Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
//         LinkedList<int[]> merged = new LinkedList<>();
//         for (int[] interval: intervals) {
//             if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
//                 merged.add(interval);
//             }
//             else {
//                 merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
//             }
//         }
//         return merged.toArray(new int[merged.size()][]);
//     }
// }

// Shangan Solution
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (current[1] >= interval[0]) {
                current[1] = Math.max(current[1], interval[1]);
            } else {
                result.add(current);
                current = interval;
            }
        }
        result.add(current);
        return result.toArray(new int[0][]);
    }
}

// @lc code=end

