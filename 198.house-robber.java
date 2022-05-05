/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start

// Method 1: Recursion with Memorization
// Time Complexity: O(N) since we process at most N recursive calls and making O(1) computation for each of thes calls to make two other recursive calls to find maximum and populate the cache based on the result
// Space Complexity: O(N) - recursion stack and cahce
// import java.util.*;
// class Solution {
//     private int[] memo;
    
//     public int rob(int[] nums) {
//         this.memo = new int[100];
//         Arrays.fill(this.memo, -1);
//         return this.robHelper(0, nums);
//     }
    
//     private int robHelper(int start, int[] nums) {
//         if (start >= nums.length) return 0;
//         if (this.memo[start] > -1) return this.memo[start];
//         int ans = Math.max(this.robHelper(start + 1, nums), this.robHelper(start + 2, nums) + nums[start]);
//         this.memo[start] = ans;
//         return ans;
//     }
// }


// Method 2: Dynamic Programming
// Time Complexity: O(N) since we have a loop from N - 2 to 0 and we can use the pre-calculated values of the dp table for calculating the current value in the table, which is a constant time operation
// Space Complexity: O(N) amount of space used by the table

class Solution {
    
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] maxRobbedAmount = new int[nums.length + 1];
        maxRobbedAmount[n] = 0;
        maxRobbedAmount[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxRobbedAmount[i] = Math.max(maxRobbedAmount[i + 1], maxRobbedAmount[i + 2] + nums[i]);
        }
        return maxRobbedAmount[0];
        
    }
}
// @lc code=end

