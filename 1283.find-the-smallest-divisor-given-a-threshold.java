/*
 * @lc app=leetcode id=1283 lang=java
 *
 * [1283] Find the Smallest Divisor Given a Threshold
 */

// @lc code=start

// Method 1: Brute Force + Binary Search
class Solution {
    public long computeSum(int[] nums, int x) {
        long s = 0;
        for (int n: nums) {
            s += n / x + ((n % x) == 0 ? 0 : 1);
        }
        return s;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = 2;
        while (computeSum(nums, right) > threshold) {
            left = right;
            right <<= 1;
        }

        while (left <= right) {
            int pivot = left + ((right - left) >> 1);
            long num = computeSum(nums, pivot);
            if (num > threshold) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return left;
    }
}
// @lc code=end

