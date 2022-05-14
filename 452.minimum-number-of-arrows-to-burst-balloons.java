/*
 * @lc app=leetcode id=452 lang=java
 *
 * [452] Minimum Number of Arrows to Burst Balloons
 */

// @lc code=start
class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) return 0;
                if (a[1] < b[1]) return -1;
                return 1;
            }
        });
        int count = 1;
        int xEnd = points[0][1];
        for (int[] interval: points) {
            int start = interval[0];
            if (start > xEnd) {
                count++;
                xEnd = interval[1];
            }
        }
        return count;
    }
}
// @lc code=end

