/*
 * @lc app=leetcode id=791 lang=java
 *
 * [791] Custom Sort String
 */

// @lc code=start

// Time Complexity: O(order.length + s.length) since it needs to iterate through both the order and s strings
// Space Complexity: O(T.length) since we count at most 26 different lowercase letters and the final answer has the same length as the given s string.
class Solution {
    public String customSortString(String order, String s) {
        int[] count = new int[26];
        for (char c: s.toCharArray()) count[c - 'a']++;
        StringBuilder sb = new StringBuilder();
        
        for (char c: order.toCharArray()) {
            for (int i = 0; i < count[c - 'a']; i++) sb.append(c);
            count[c - 'a'] = 0;
        }
        
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < count[c - 'a']; i++) sb.append(c);
        }
        return sb.toString();
    }
}
// @lc code=end

