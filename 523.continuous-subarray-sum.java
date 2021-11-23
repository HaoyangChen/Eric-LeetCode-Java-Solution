/*
 * @lc app=leetcode id=523 lang=java
 *
 * [523] Continuous Subarray Sum
 */

// @lc code=start

// Time Complexity: O(M) where M is the length of nums, since the algorithm loops the entire array once
// Space Complexity: O(min(m, k)) where m is there length of nums. The space complexity depends on the hashmap. Since we use hashmap to store the index of first occurance of a remainder. There will be at most min(m, k) remainder
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int numLength = nums.length;
        if (numLength < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int remainder = 0;
        for (int i = 0; i < numLength; i++) {
            remainder = (remainder + nums[i]) % k;
            if (map.containsKey(remainder)) {
                int prevIndex = map.get(remainder);
                if (i - prevIndex >= 2) return true;
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }
}
// @lc code=end

