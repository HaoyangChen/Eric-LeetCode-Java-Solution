/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start


// Method 1: Recursion with Memoization
// Time Complexity: O(n). size of recursion tree can go up to n
// Space Complexity: O(n). The depth of the recursion tree can go up to n.
// class Solution {
//     public int climbStairs(int n) {
//         int[] memo = new int[n + 1];
//         return climbStairs(0, n, memo);
//     }
    
//     public int climbStairs(int i, int n, int[] memo) {
//         if (i > n) return 0;
//         if (i == n) return 1;
//         if (memo[i] > 0) return memo[i];
//         memo[i] = climbStairs(i + 1, n, memo) + climbStairs(i + 2, n, memo);
//         return memo[i];
//     }
// }


// Method 2: Dynamic Programming
// Time Complexity: O(n). Single Loop up to n
// Space Complexity: O(n). dp array of size n is used
// class Solution {
//     public int climbStairs(int n) {
//         if (n == 1) {
//             return 1;
//         }
//         int[] dp = new int[n + 1];
//         dp[1] = 1;
//         dp[2] = 2;
//         for (int i = 3; i <= n; i++) {
//             dp[i] = dp[i - 1] + dp[i - 2];
//         }
//         return dp[n];
//     }
// }

// Method 3: Fibonacci Number
// Time Complexity: Single loop upto n is required to calculate n^{th fibonacci number
// Space Complexity: O(1). Constant space is used

class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
// @lc code=end

