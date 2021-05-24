/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 */

// @lc code=start

// Method: Binary Search
// Time Complexity: O(logN)
// Space Complexity: O(1)
class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;
        long num;
        int pivot, left = 2, right = x / 2;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            num = (long)pivot * pivot;
            if (num > x) right = pivot - 1;
            else if (num < x) left = pivot + 1;
            else return pivot;
        }
        return right;
    }
}
// @lc code=end

