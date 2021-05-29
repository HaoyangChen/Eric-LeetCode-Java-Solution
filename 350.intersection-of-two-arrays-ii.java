/*
 * @lc app=leetcode id=350 lang=java
 *
 * [350] Intersection of Two Arrays II
 */

// @lc code=start

// Method 1: Hash Map
// Time Complexity: O(n+m), where n and m are the lengths of the arrays. We iterate through the first, and then through the second array; insert and lookup operations in the hash map take a constant time.
// Space Complexity: O(min(n,m)) We use hash map to store numbers (and their counts) from the smaller array.
// class Solution {
//     public int[] intersect(int[] nums1, int[] nums2) {
//         if (nums1.length > nums2.length) {
//             return intersect(nums2, nums1);
//         }

//         HashMap<Integer, Integer> map = new HashMap<>();
//         for (int n: nums1) {
//             map.put(n, map.getOrDefault(n, 0) + 1);
//         }
//         int k = 0;
//         for (int n: nums2) {
//             int cnt = map.getOrDefault(n, 0);
//             if (cnt > 0) {
//                 nums1[k++] = n;
//                 map.put(n, cnt - 1);
//             }
//         }
//         return Arrays.copyOfRange(nums1, 0, k);
//     }
// }


// Method 2: Sort
// Time Complexity: O(nlogn+mlogm), where nn and mm are the lengths of the arrays. We sort two arrays independently, and then do a linear scan.
// Space Complexity: O(logn+logm) to O(n+m), depending on the implementation of the sorting algorithm.
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                nums1[k++] = nums1[i++];
                j++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

}

// @lc code=end

