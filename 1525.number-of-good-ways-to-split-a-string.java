/*
 * @lc app=leetcode id=1525 lang=java
 *
 * [1525] Number of Good Ways to Split a String
 */

// @lc code=start
class Solution {
    public int numSplits(String s) {
        Set<Character> unique = new HashSet<>();
        int n = s.length();
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        for (int i = 0; i < n; i++) {
            unique.add(s.charAt(i));
            prefix[i] = unique.size();
        }
        unique.clear();
        for (int i = n - 1; i >= 0; i--) {
            unique.add(s.charAt(i));
            suffix[i] = unique.size();
        }
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (prefix[i - 1] == suffix[i]) {
                ans++;
            }
        }
        return ans;
    }
}
// @lc code=end

