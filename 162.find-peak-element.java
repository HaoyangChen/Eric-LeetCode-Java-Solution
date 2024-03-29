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


// class Solution {
//     public int findPeakElement(int[] nums) {
//         if (nums.length == 0 || nums == null) {
//             return -1;
//         }
//         int left = 0;
//         int right = nums.length - 1;
//         while (left + 1 < right) {
//             int mid = left + (right - left) / 2;
//             if (nums[mid] > nums[mid - 1]) {
//                 left = mid;
//             } else {
//                 right = mid;
//             }
//         }
//         return nums[left] > nums[right] ?  left : right;
//     }
// }

// Iterative Binary Search
// Time Complexity: O(logn) the search space is reduced in half at every step. Thus, the total search space will be consumed in log2(n) steps. n refers to the size of nums array
// Space Complexity: O(1) constant extra space is used
class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
// @lc code=end

