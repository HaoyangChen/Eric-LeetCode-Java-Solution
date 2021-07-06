/*
 * @lc app=leetcode id=1010 lang=java
 *
 * [1010] Pairs of Songs With Total Durations Divisible by 60
 */

// @lc code=start
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int remainders[] = new int[60];
        int count = 0;
        for (int t: time) {
            if (t % 60 == 0) {
                count += remainder[0];
            } else {
                count += remainder[60 - t % 60];
            }
            remainders[t % 60]++;
        }
        return count;
    }
}
// @lc code=end

