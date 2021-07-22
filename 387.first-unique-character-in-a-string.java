/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 */

// @lc code=start

// Method: inear time solution
// Time Complexity: O(N) since we go through the string of length N two times
// Space Complexity: O(1) because English alphabet contains 26 letters
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            if (map.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
}
// @lc code=end

