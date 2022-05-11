/*
 * @lc app=leetcode id=1014 lang=java
 *
 * [1014] Best Sightseeing Pair
 */

// @lc code=start
class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int ans = 0, max = values[0] + 0;
        for (int j = 1; j < values.length; j++) {
            ans = Math.max(ans, max + values[j] - j);
            max = Math.max(max, values[j] + j);
        }
        return ans;
    }
}
// @lc code=end

