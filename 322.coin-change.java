/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

 import java.util.*;

// @lc code=start
// 
// Method: Dynamic Programming - Top Down
// Time Complexity: O(S * n) - where S is the amount, n is denomination amount. In the worst case, the recursive tree of the algorithm has height of S and the algorithm solves only S subproblems because it catches precalculated solutions in a table. Each subproblem is computed with n iterations, one by coin denomination. Therefore there is O(S * n) time complexity.
// Space Compexity: O(S) - where S is the amount to change. We use extra space for the memorization table. 
// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         if (amount < 1) return 0;
//         return coinChange(coins, amount, new int [amount]);
//     }

//     private int coinChange(int[] coins, int rem, int[] count) {
//         if (rem < 0) return -1;
//         if (rem == 0) return 0;
//         if (count[rem - 1] != 0) {
//             return count[rem - 1];
//         }
//         int min = Integer.MAX_VALUE;
//         for (int coin: coins) {
//             int res = coinChange(coins, rem - coin, count);
//             if (res >= 0 && res < min) {
//                 min = 1 + res;
//             }
//         }
//         count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
//         return count[rem - 1];
//     }
// }


// Method 2: Top Down Approach
// class Solution {
//     private int[] memo;
//     public int coinChange(int[] coins, int amount) {
//         memo = new int[amount + 1];
//         Arrays.fill(memo, -666);
//         return dp(coins, amount);
//     }
    
//     private int dp(int[] coins, int amount) {
//         if (amount == 0) return 0;
//         if (amount < 0) return -1;
//         if (memo[amount] != -666) return memo[amount];
        
//         int result = Integer.MAX_VALUE;
//         for (int coin: coins) {
//             int subProblem = dp(coins, amount - coin);
//             if (subProblem == -1) continue;
//             result = Math.min(result, subProblem + 1);
//         }
//         memo[amount] = (result == Integer.MAX_VALUE) ? -1 : result;
//         return memo[amount];
//     }
// }


// Method 3: Bottom Up Approach
// Time Complexity: O(S * n) where n is the number of denominations of the coins
// Space Complexity: O(S) where S is the amount
class Solution {
    public int coinChange(int[] coins, int amount) {
        int maxValue = amount + 1;
        int[] dp = new int[maxValue];
        Arrays.fill(dp, maxValue);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == maxValue ? -1 :dp[amount];
    }
}
// @lc code=end

