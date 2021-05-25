/*
 * @lc app=leetcode id=658 lang=java
 *
 * [658] Find K Closest Elements
 */

// @lc code=start

// Method of Exclusion
// Time Complexity: O(N), where N is the length of the arr
// Space Complexity: O(1), we used constant space
// class Solution {
//     public List<Integer> findClosestElements(int[] arr, int k, int x) {
//         int size = arr.length;
//         int left = 0;
//         int right = size - 1;
//         int removeNums = size - k;
//         while (removeNums > 0) {
//             if (x - arr[left] <= arr[right] - x) {
//                 right--;
//             } else {
//                 left++;
//             }
//             removeNums--;
//         }
//         List<Integer> result = new ArrayList<>();
//         for (int i = left; i < left + k; i++) {
//             result.add(arr[i]);
//         }
//         return result;
//     }
// }


// Method 2: Binary Search
// Time Complexity: O(logN + K) where N is the length of arr
// Space Complexity: O(1) constant space
public class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int size = arr.length;

        int left = 0;
        int right = size - k;

        while (left < right) {
            int mid = (left + right) >>> 1;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
// @lc code=end

