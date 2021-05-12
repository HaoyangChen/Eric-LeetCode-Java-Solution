/*
 * @lc app=leetcode id=219 lang=java
 *
 * [219] Contains Duplicate II
 */

// @lc code=start

// Time Complexity: O(nlog(min(k, n))) . We do n operations of search, delete and insert. Each operation costs logarithmic time complexity in the sliding window which size is min(k,n).
// Space Complexity: O(min(k, n)) - Space is the size of the sliding window which should not exceed n or k
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
// @lc code=end

