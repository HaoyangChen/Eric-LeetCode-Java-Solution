/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 */

// @lc code=start

// Dynamic Programming
// Time Complexity: O(N^2)
// Space Complexity: O(N) - The space complexity of the above algorithm is mainly the storage to keep all the intermediate solutions
// class Solution {
//     public int numTrees(int n) {
//         int[] G = new int[n + 1];
//         G[0] = 1;
//         G[1] = 1;
//         for (int i = 2; i <= n; i++) {
//             for (int j = 1; j <= i; j++) {
//                 G[i] += G[j - 1] * G[i - j];
//             }
//         }
//         return G[n];
//     }
// }

// recursion with memorization
class Solution {
    int[][] memo;
    public int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        return count(1, n);
    }
    
    private int count(int low, int high) {
        if (low > high) return 1;
        if (memo[low][high] != 0) return memo[low][high];
        int res = 0;
        for (int mid = low; mid <= high; mid++) {
            int left = count(low, mid - 1);
            int right = count(mid + 1, high);
            res += left * right;
        }
        memo[low][high] = res;
        return res;
    }
}
// @lc code=end

