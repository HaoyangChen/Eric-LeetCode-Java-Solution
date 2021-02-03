/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int temp;
        for (int i = 0; i <= right; i++) {
            if (nums[i] == 0) {
                temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                left++;
            } else if (nums[i] == 2) {
                temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
                right--;
                i--;
            }
        }
    }
}
// @lc code=end

