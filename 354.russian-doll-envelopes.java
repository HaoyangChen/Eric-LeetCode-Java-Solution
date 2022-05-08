/*
 * @lc app=leetcode id=354 lang=java
 *
 * [354] Russian Doll Envelopes
 */

// @lc code=start
import java.util.*;


// Method: Sort + Longest Increasing Subsequence
// Time Complexity: O(NlogN) where N is the length of the input. Both sorting the array and finding the LIS happen in O(N \log N)O(NlogN)
// Space Complexity: O(N) The function requires an array top that goes up to O(NlogN)

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                return arr1[0] == arr2[0] ? arr2[1] - arr1[1] : arr1[0] - arr2[0];
            }
        });
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }
        return lengthOfLIS(height);
    }
    
    private int lengthOfLIS(int[] nums) {
        int piles = 0, n = nums.length;
        int[] top = new int[n];
        for (int i = 0; i < n; i++) {
            int poker = nums[i];
            int left = 0, right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] >= poker)
                    right = mid;
                else
                    left = mid + 1;
            }
            if (left == piles) piles++;
            top[left] = poker;
        }
        return piles;
    }
}
// @lc code=end

