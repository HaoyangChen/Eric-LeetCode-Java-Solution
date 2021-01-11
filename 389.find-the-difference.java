/*
 * @lc app=leetcode id=389 lang=java
 *
 * [389] Find the Difference
 */

// @lc code=start

// Use Ascii Code for each character in each string to calculate the sums. The value of at-as in character representation is the result
// Time Complexity: O(n)
// Space Complexity: O(1) 
class Solution {
    public char findTheDifference(String s, String t) {
        int as = 0, at = 0;
        for (int i = 0; i < s.length(); i++) {
            as += s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            at += t.charAt(i);
        }
        return (char) (at - as);
    }
}
// @lc code=end

