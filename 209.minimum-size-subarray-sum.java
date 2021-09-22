/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */

// @lc code=start
// class Solution {
//     public int minSubArrayLen(int target, int[] nums) {
//         int sum = 0;
//         int count = 0;
//         int min = Integer.MAX_VALUE;
//         for (int i = 0; i < nums.length; i++) {
//             sum += nums[i];
//             count++;
//             // shrink left pointer
//             while (sum >= target) {
//                 min = Math.min(min, count);
//                 count--;
//                 sum -= nums[i - count];
//             }
//         }
//         return min == Integer.MAX_VALUE ? 0 : min;
//     }
// }


class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            while (sum >= target) {
                ans = Math.min(ans, i + 1 - left);
                sum -= nums[left++];
            }
        }
        return (ans != Integer.MAX_VALUE) ? ans: 0;
    }
}




// @lc code=end

