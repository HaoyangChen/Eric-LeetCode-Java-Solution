/*
 * @lc app=leetcode id=771 lang=java
 *
 * [771] Jewels and Stones
 */

// @lc code=start

// Method: Hash Set
// Time Complexity: O(J.length + S.length). The O(J.length) part comes from creating J. The O(S.length) part comes from searching S
// Space Complexity: O(J.length)
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelSet = new HashSet();
        for (char j: jewels.toCharArray()) {
            jewelSet.add(j);
        }
        int ans = 0;
        for (char s: stones.toCharArray()) {
            if (jewelSet.contains(s)) ans++;
        }
        return ans;
    }
}
// @lc code=end

