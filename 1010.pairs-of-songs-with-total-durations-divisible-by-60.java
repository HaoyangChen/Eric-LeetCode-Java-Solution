/*
 * @lc app=leetcode id=1010 lang=java
 *
 * [1010] Pairs of Songs With Total Durations Divisible by 60
 */

// @lc code=start

// Time Complexity: O(n) when n is the length of the input array because we would visit each element in time once
// Space Complexity: O(1) because the size of the array remainders is fixed with 60
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int remainders[] = new int[60];
        int count = 0;
        for (int t: time) {
            if (t % 60 == 0) {
                count += remainders[0];
            } else {
                count += remainders[60 - t % 60];
            }
            remainders[t % 60]++;
        }
        return count;
    }
}
// @lc code=end

