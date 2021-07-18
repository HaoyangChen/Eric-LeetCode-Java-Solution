/*
 * @lc app=leetcode id=136 lang=java
 *
 * [136] Single Number
 */

// @lc code=start

// Method: Hash Table
// Time Complexity: O(n * 1)  = O(n). Time complexity of for loops is O(n).
// Space Complexity: O(n). The space required by hashtable is equal to the number of elements in nums
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int num: nums) {
            hashtable.put(num, hashtable.getOrDefault(num, 0) + 1);
        }
        for (int i: nums) {
            if (hashtable.get(i) == 1) return i;
        }
        return 0;
    }
}
// @lc code=end

