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

// Method: Recursion with memoization
// Time Complexity: O(n^3) - size of the recursion tree can go up to n^2
// Space Complexity: O(n) - the depth of recursion tree can go up to n
// public class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         return wordBreakMemo(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
//     }

//     private boolean wordBreakMemo(String s, Set<String> wordDict, int start, Boolean[] memo) {
//         if (start == s.length()) {
//             return true;
//         }
//         if (memo[start] != null) {
//             return memo[start];
//         }
//         for (int end = start + 1; end <= s.length(); end++) {
//             if (wordDict.contains(s.substring(start, end)) && wordBreakMemo(s, wordDict, end, memo)) {
//                 return memo[start] = true;
//             }
//         }
//         return memo[start] = false;
//     }
// }


// Method 2: Using Breadth-First-Search
// Time Complexity: O(n^3) - For every starting index, the search can continue till the end of the given string.
// Space Complexity: O(n) - Queue of at most n size is needed.
// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         Set<String> wordDictSet = new HashSet<>(wordDict);
//         Queue<Integer> queue = new LinkedList<>();
//         boolean[] visited = new boolean[s.length()];
//         queue.add(0);
//         while (!queue.isEmpty()) {
//             int start = queue.remove();
//             if (visited[start]) continue;
//             for (int end = start + 1; end <= s.length(); end++) {
//                 if (wordDictSet.contains(s.substring(start, end))) {
//                     queue.add(end);
//                     if (end == s.length()) {
//                         return true;
//                     }
//                 }
//             }
//             visited[start] = true;
//         }
//         return false;
//     }
// }

// Using Dynamic Programming
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}


// @lc code=end

