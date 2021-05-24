/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start

// Method 1: Binary search
// Time Complexity: O(logN)
// Space Complexity: O(1)
// class Solution {
//     int[] nums;
//     int target;
//     public int search(int[] nums, int target) {
//         this.nums = nums;
//         this.target = target;
//         int n = nums.length;
//         if (n == 1) return this.nums[0] == target ? 0 : -1;
//         int rotate_index = findRotateIndex(0, n - 1);
//         if (nums[rotate_index] == target) {
//             return rotate_index;
//         }
//         if (rotate_index == 0) return search(0, n - 1);
//         if (target < nums[0]) {
//             return search(rotate_index, n - 1);
//         }
//         return search(0, rotate_index);

//     }

//     private int findRotateIndex(int left, int right) {
//         if (nums[left] < nums[right]) {
//             return 0;
//         }
//         while (left <= right) {
//             int pivot = left + (right - left) / 2;
//             if (nums[pivot] > nums[pivot + 1]) {
//                 return pivot + 1;
//             } else {
//                 if (nums[pivot] < nums[left]) {
//                     right = pivot - 1;
//                 } else {
//                     left = pivot + 1;
//                 }
//             }
//         }
//         return 0;
//     }

//     private int search(int left, int right) {
//         while (left <= right) {
//             int pivot = left + (right - left) / 2;
//             if (nums[pivot] == target) {
//                 return pivot;
//             } else {
//                 if (target < nums[pivot]) {
//                     right = pivot - 1;
//                 } else {
//                     left = pivot + 1;
//                 }
//             }
//         }
//         return -1;
//     }
// }



// Method 2: One-pass Binary Search
// Time Complexity: O(logN)
// Space Complexity: O(1)
class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] >= nums[start]) {
                if (target >= nums[start] && target < nums[mid]) end = mid - 1;
                else start = mid + 1;
            } else {
                if (target > nums[mid] && target <= nums[end]) start = mid + 1;
                else end = mid - 1;
            }
        }
        return -1;
    }
}
// @lc code=end

