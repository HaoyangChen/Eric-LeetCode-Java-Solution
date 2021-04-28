/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start

// Shangan
// Method 1: Backtracking
class Solution {
    private static Map<Character, String> map = new HashMap<>();
    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('5', "jkl");
        map.put('4', "ghi");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
    List<String> result;
    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        dfs(digits, 0, new StringBuilder());
        return result;
    }

    private void dfs(String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        String str = map.get(digits.charAt(index));
        for (char c: str.toCharArray()) {
            sb.append(c);
            dfs(digits, index + 1, sb);
            sb.setLength(sb.length() - 1);
        }
    }
}
// @lc code=end

