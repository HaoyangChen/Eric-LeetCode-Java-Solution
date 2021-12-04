/*
 * @lc app=leetcode id=1047 lang=java
 *
 * [1047] Remove All Adjacent Duplicates In String
 */

// @lc code=start

// Time Complexity: O(N) where N is the length of the given string
// Space Complexity: O(N - D) where D is the total length of all duplicates
class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for (char character: s.toCharArray()) {
            if (sbLength != 0 && character == sb.charAt(sbLength - 1)) {
                sb.deleteCharAt(sbLength - 1);
                sbLength--;
            } else {
                sb.append(character);
                sbLength++;
            }
        }
        return sb.toString();
    }
}
// @lc code=end

