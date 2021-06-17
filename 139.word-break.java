/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start
// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         return wordBreakRecur(s, new HashSet<>(wordDict), 0);
//     }

//     private boolean wordBreakRecur(String s, Set<String> wordDict, int start) {
//         if (start == s.length()) {
//             return true;
//         }
//         for (int end = start + 1; end <= s.length(); end++) {
//             if (wordDict.contains(s.substring(start, end)) && wordBreakRecur(s, wordDict, end)) {
//                 return true;
//             }
//         }
//         return false;
//     }
// }

// Recursion with memoization
// Time Complexity: O(n^3) - size of the recursion tree can go up to n^2
// Space Complexity: O(n) - the depth of recursion tree can go up to n
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakMemo(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }

    private boolean wordBreakMemo(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreakMemo(s, wordDict, end, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }
}


// @lc code=end

