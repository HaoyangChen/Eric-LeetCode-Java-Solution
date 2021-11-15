/*
 * @lc app=leetcode id=921 lang=java
 *
 * [921] Minimum Add to Make Parentheses Valid
 */

// @lc code=start

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int minAddToMakeValid(String s) {
        int answer = 0, balance = 0;
        for (int i = 0; i < s.length(); i++) {
            balance += s.charAt(i) == '(' ? 1 : -1;
            if (balance == -1) {
                balance++;
                answer++;
            }
        }
        return answer + balance;
    }
}
// @lc code=end

