/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start

// Method 1: Binary Search
// Time Complexity: O(log(m + n)), where m and n is the size of num1 and num2. Each round in the loop will reduce the search scope by half
// Space Complexity: O(1)
// class Solution {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//         int length1= nums1.length, length2 = nums2.length;
//         int totalLength = length1 + length2;
//         if (totalLength % 2 == 1) {
//             int midIndex = totalLength / 2;
//             double median = getKthElement(nums1, nums2, midIndex + 1);
//             return median;
//         } else {
//             int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
//             double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
//             return median;
//         }
//     }

//     public int getKthElement(int[] nums1, int[] nums2, int k) {
//         int length1 = nums1.length, length2 = nums2.length;
//         int index1 = 0, index2 = 0;
//         int kthElement = 0;

//         while (true) {
//             if (index1 == length1) {
//                 return nums2[index2 + k - 1];
//             }
//             if (index2 == length2) {
//                 return nums1[index1 + k - 1];
//             }
//             if (k == 1) {
//                 return Math.min(nums1[index1], nums2[index2]);
//             }

//             int half = k / 2;
//             int newIndex1 = Math.min(index1 + half, length1) - 1;
//             int newIndex2 = Math.min(index2 + half, length2) - 1;
//             int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
//             if (pivot1 <= pivot2) {
//                 k -= (newIndex1 - index1 + 1);
//                 index1 = newIndex1 + 1;
//             } else {
//                 k -= (newIndex2 - index2 + 1);
//                 index2 = newIndex2 + 1;
//             }
//         }
//     }
// }




// Method 2: Another Binary Search Implementation with a better time complexity
// Time Complexity: O(logmin(m,n)))
// Space Complexity: O(1)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length, n = nums2.length;
        int left = 0, right = m;
        int median1 = 0, median2 = 0;


        while (left <= right) {
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;

            // nums_im1, nums_i, nums_jm1, nums_j represent nums1[i-1], nums1[i], nums2[j-1], nums2[j] respectively
            int nums_im1 = (i == 0 ? Integer.MIN_VALUE: nums1[i - 1]);
            int nums_i = (i == m ? Integer.MAX_VALUE: nums1[i]);
            int nums_jm1 = (j == 0 ? Integer.MIN_VALUE: nums2[j - 1]);
            int nums_j = (j == n ? Integer.MAX_VALUE: nums2[j]);

            if (nums_im1 <= nums_j) {
                median1 = Math.max(nums_im1, nums_jm1);
                median2 = Math.min(nums_i, nums_j);
                left = i + 1;
            } else {
                right = i - 1;
            }
        }
        return (m + n) % 2 == 0 ? (median1 + median2) / 2.0 : median1;
    }
}

// @lc code=end

