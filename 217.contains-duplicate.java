/*
 * @lc app=leetcode id=217 lang=java
 *
 * [217] Contains Duplicate
 */

// @lc code=start

// Hash Set
// Time Complexity: O(n) we do search() and insert() for n times and each operation takes constant time
// Space Complexity: O(n) the space utilized by the hash set is linear with the number of elements in it
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>(nums.length);
        for (int x: nums) {
            if (set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }
}
// @lc code=end

