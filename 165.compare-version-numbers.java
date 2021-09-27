/*
 * @lc app=leetcode id=165 lang=java
 *
 * [165] Compare Version Numbers
 */

// @lc code=start

// Method 1: Split + Parse, Two Pass
// Time Complexity: O(N + M + max(N, M)), where N and M are lengths of input strings
// Space Complexity: O(N + M) tp store arrays num1 and nums2
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int n1 = nums1.length, n2 = nums2.length;
        int i1, i2;
        for (int i = 0; i < Math.max(n1, n2); i++) {
            i1 = i < n1 ? Integer.parseInt(nums1[i]) : 0;
            i2 = i < n2 ? Integer.parseInt(nums2[i]) : 0;
            if (i1 != i2) {
                return i1 < i2 ? -1 : 1;
            }
        }
        return 0;
    }
}
// @lc code=end

