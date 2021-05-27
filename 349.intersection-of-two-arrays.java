/*
 * @lc app=leetcode id=349 lang=java
 *
 * [349] Intersection of Two Arrays
 */

// @lc code=start

// Method 1: Built-in Set Intersection
// Time Complexity: O(n + m) in the average case 
// Space Complexity: O(n + m) in the worst case when all elements in the arrays are different.
// class Solution {
//     public int[] intersection(int[] nums1, int[] nums2) {
//         HashSet<Integer> set1 = new HashSet<Integer>();
//         for (Integer n: nums1) set1.add(n);
//         HashSet<Integer> set2 = new HashSet<Integer>();
//         for (Integer n: nums2) set2.add(n);

//         set1.retainAll(set2);
//         int[] output = new int[set1.size()];
//         int idx = 0;
//         for (int s: set1) {
//             output[idx++] = s;
//         }
//         return output;
//     }
// }


// Method 2: Binary Search
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for (Integer num: nums1) {
            if (binarySearch(nums2, num)) {
                set.add(num);
            }
        }
        int i = 0;
        int[] result = new int[set.size()];
        for (Integer num: set) {
            result[i++] = num;
        }
        return result;
    }

    public boolean binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return true;
            } 
            else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (nums[left] == target || nums[right] == target) return true;
        return false;
    }

}

// @lc code=end

