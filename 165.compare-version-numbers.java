/*
 * @lc app=leetcode id=165 lang=java
 *
 * [165] Compare Version Numbers
 */

// @lc code=start

// Method 1: Split + Parse, Two Pass
// Time Complexity: O(N + M + max(N, M)), where N and M are lengths of input strings
// Space Complexity: O(N + M) tp store arrays num1 and nums2
// class Solution {
//     public int compareVersion(String version1, String version2) {
//         String[] nums1 = version1.split("\\.");
//         String[] nums2 = version2.split("\\.");
//         int n1 = nums1.length, n2 = nums2.length;
//         int i1, i2;
//         for (int i = 0; i < Math.max(n1, n2); i++) {
//             i1 = i < n1 ? Integer.parseInt(nums1[i]) : 0;
//             i2 = i < n2 ? Integer.parseInt(nums2[i]) : 0;
//             if (i1 != i2) {
//                 return i1 < i2 ? -1 : 1;
//             }
//         }
//         return 0;
//     }
// }


// Method 2: Two Pointers, One Pass
// Time Complexity: O(max(N, M)), where N and M are lengths of the input strings respectively since it is a one-pass solution
// Space Complexity: O(max(N, N)) Though we did not keep arrays of revision numbers, we still need addtional space to store a substring of the input string for string conversion. In the worst case, the substring can be of the original string
class Solution {
    public int compareVersion(String version1, String version2) {
        int p1 = 0, p2 = 0;
        int n1 = version1.length(), n2 = version2.length();
        int i1, i2;
        Pair<Integer, Integer> pair;
        while (p1 < n1 || p2 < n2) {
            pair = getNextChunk(version1, n1, p1);
            i1 = pair.getKey();
            p1 = pair.getValue();

            pair = getNextChunk(version2, n2, p2);
            i2 = pair.getKey();
            p2 = pair.getValue();
            if (i1 != i2) {
                return i1 < i2 ? -1 : 1;
            }
        }
        return 0;
    }

    public Pair<Integer, Integer> getNextChunk(String version, int n, int p) {
        if (p > n - 1) {
            return new Pair(0, p);
        }
        int i, pEnd = p;
        while (pEnd < n && version.charAt(pEnd) != '.') {
            ++pEnd;
        }
        if (pEnd != n - 1) {
            i = Integer.parseInt(version.substring(p, pEnd));
        } else {
            i = Integer.parseInt(version.substring(p, n));
        }
        p = pEnd + 1;
        return new Pair(i, p);
    }
}

// Method 2: Two Pointers
// @lc code=end

