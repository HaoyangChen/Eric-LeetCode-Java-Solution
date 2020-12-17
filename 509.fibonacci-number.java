/*
 * @lc app=leetcode id=509 lang=java
 *
 * [509] Fibonacci Number
 */

// @lc code=start

// Method: Iterative Top-Down Approach
// Time Complexity: O(n). Each value from 2 to n will be visited at least once. The time it takes to do so directly proportionate to n where n is the fibonacci number we are loooking to compute.
// Space Compelxity: O(1). This requires 1 unit of space for the integer N and 3 units of space to store the computed values (curr, prev1, and prev2) for each loop iteration. The amount of space does not change so it is constant space complexity.
class Solution {
    public int fib(int n) {
        if (n <= 1) return n;
        if (n == 2) return 1;
        int current = 0;
        int prev1 = 1;
        int prev2 = 1;
        for (int i = 3; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return current;
    }
}
// @lc code=end

