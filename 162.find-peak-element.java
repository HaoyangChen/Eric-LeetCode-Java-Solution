/*
 * @lc app=leetcode id=162 lang=java
 *
 * [162] Find Peak Element
 */

// @lc code=start

// public class Solution {
//     public int findPeakElement(int[] nums) {
//         for (int i = 0; i < nums.length - 1; i++) {
//             if (nums[i] > nums[i + 1])
//                 return i;
//         }
//         return nums.length - 1;
//     }
// }


class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid - 1]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return nums[left] > nums[right] ?  left : right;
    }
}
// @lc code=end

