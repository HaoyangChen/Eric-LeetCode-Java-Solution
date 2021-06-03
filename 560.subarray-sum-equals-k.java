/*
 * @lc app=leetcode id=560 lang=java
 *
 * [560] Subarray Sum Equals K
 */

// @lc code=start

// Method 1: Without Space
// Time complexity: O(n^2) We need to consider every subarray possible.
// Space complexity: O(1). Constant space is used.

// public class Solution {
//     public int subarraySum(int[] nums, int k) {
//         int count = 0;
//         for (int start = 0; start < nums.length; start++) {
//             int sum=0;
//             for (int end = start; end < nums.length; end++) {
//                 sum+=nums[end];
//                 if (sum == k)
//                     count++;
//             }
//         }
//         return count;
//     }
// }

// Method 2: Hashmap
// Time Complexity: O(n). The entire nums array is traversed only once
// Space Complexity: O(n). Hashmap map can contain up to n distinct entries in the worst case
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
// @lc code=end

