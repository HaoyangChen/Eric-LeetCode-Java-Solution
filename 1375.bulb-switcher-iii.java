/*
 * @lc app=leetcode id=1375 lang=java
 *
 * [1375] Bulb Switcher III
 */

// @lc code=start

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public int numTimesAllBlue(int[] light) {
        int right = 0, result = 0, n = light.length;
        for (int i = 0; i < n; i++) {
            right = Math.max(right, light[i]);
            if (right == i + 1) result++;
        }
        return result;
    }
}
// @lc code=end

