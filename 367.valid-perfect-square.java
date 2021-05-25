/*
 * @lc app=leetcode id=367 lang=java
 *
 * [367] Valid Perfect Square
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2) return true;
        long left = 2, right = num / 2, x, guessSquared;
        while (left + 1 < right) {
            x = left + ((right - left) >> 1);
            guessSquared = x * x;
            if (guessSquared == num) {
                return true;
            } else if (guessSquared < num) {
                left = x;
            } else {
                right = x;
            }
        }
        
        if (left * left == num) return true;
        if (right * right == num) return true;
        return false;
    }
}
// @lc code=end

