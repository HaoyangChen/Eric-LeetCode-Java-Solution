/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<Character, Integer>();
        HashMap<Character, Integer> window = new HashMap<Character, Integer>();
        for (char c: t.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1);
        int left = 0, right = 0;
        int valid = 0;
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char c1 = s.charAt(left);
                left++;
                if (need.containsKey(c1)) {
                    if (window.get(c1).equals(need.get(c1))) {
                        valid--;
                    }
                    window.put(c1, window.getOrDefault(c1, 0) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
// @lc code=end

