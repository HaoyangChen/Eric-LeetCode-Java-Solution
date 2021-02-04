/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int count = 0;
        Set<Character> visited = new HashSet<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            while (visited.contains(c)) {
                visited.remove(s.charAt(i - count));
                count--;
            }
            visited.add(c);
            count++;
            max = Math.max(max, count);
        }
        return max;
    }
}
// @lc code=end

