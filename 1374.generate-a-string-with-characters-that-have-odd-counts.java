/*
 * @lc app=leetcode id=1374 lang=java
 *
 * [1374] Generate a String With Characters That Have Odd Counts
 */

// @lc code=start
class Solution {
    public String generateTheString(int n) {
        StringBuilder result = new StringBuilder();
        if (n % 2 == 0) {
            for (int i = 0; i < n - 1; i ++) {
                result.append('a');
            }
            result.append('b');
        } else {
            for (int i = 0; i < n; i++) {
                result.append('a');
            }
        }   
        return result.toString();
    }
}
// @lc code=end

