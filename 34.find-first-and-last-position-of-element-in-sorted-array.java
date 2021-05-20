/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start

// Binary Search
// Time Complexity: O(logN)
// Space Complexity: O(1) - All work is done in place, so the overall memory usage is constant
// class Solution {
//     public int[] searchRange(int[] nums, int target) {
//         int [] targetRange = {-1, -1};
//         int leftIndex = extremeInsertionIndex(nums, target, true);

//         // assert that "leftIndex" is within the array bounds and that "target" is actually in "nums"
//         if (leftIndex == nums.length || nums[leftIndex] != target) {
//             return targetRange;
//         }
//         targetRange[0] = leftIndex;
//         // subtract 1 to get rightmost index
//         targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;
//         return targetRange;
//     }

//     private int extremeInsertionIndex(int[] nums, int target, boolean left) {
//         int lo = 0; 
//         int hi = nums.length;
//         while (lo < hi) {
//             int mid = (lo + hi) / 2;
//             if (nums[mid] > target || left && target == nums[mid]) {
//                 hi = mid;
//             } else {
//                 lo = mid + 1;
//             }
//         }
//         return lo;
//     }
// }


class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int left = searchLeft(nums, target);
        int right = searchRight(nums, target);
        return new int[]{left, right};
    }

    public int searchLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (nums[left] == target) return left;
        return nums[right] == target ? right : -1;
    }

    public int searchRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[right] == target) return right;
        return nums[left] == target ? left : -1;
    }
}


// @lc code=end

