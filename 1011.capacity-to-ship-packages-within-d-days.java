/*
 * @lc app=leetcode id=1011 lang=java
 *
 * [1011] Capacity To Ship Packages Within D Days
 */

// @lc code=start
// Time Complexity: O(nlog(Σw)) where n is the length of weights array and Σw is the sum of all elements in weights. 
// Space Complexity: O(1)
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for (int w: weights) {
            left = Math.max(left, w);
            right += w;
        }
        while (left < right) {
            int mid = (left + right) / 2, need = 1, current = 0;
            for (int weight: weights) {
                if (current + weight > mid) {
                    need += 1;
                    current = 0;
                }
                current += weight;
            }
            if (need <= days) right = mid;
            else left = mid  + 1;
        }
        return left;
    }
}
// @lc code=end

