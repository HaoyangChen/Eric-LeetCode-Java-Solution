/*
 * @lc app=leetcode id=410 lang=java
 *
 * [410] Split Array Largest Sum
 */

// @lc code=start
class Solution {
    public int splitArray(int[] nums, int m) {
        long right = 0;
        long left = 0;
        for (int i = 0; i < nums.length; i++) {
            right += nums[i];
        }
        while (left + 1 < right) {
            long mid = (left + right) >> 1;
            if (check(nums, m, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (check(nums, m, left)) {
            return (int)left;
        }
        return (int)right;
    }

    public boolean check(int[] nums, int m, long mid) {
        int index = 0;
        int parts = 0;
        while (index < nums.length) {
            long sum = 0;
            while (index < nums.length) {
                if (nums[index] > mid) {
                    return false;
                }
                if (sum + nums[index] > mid) {
                    break;
                }
                sum += nums[index];
                index++;
            }
            parts++;
        }
        if (parts > m) {
            return false;
        }
        return true;
    }
}
// @lc code=end

