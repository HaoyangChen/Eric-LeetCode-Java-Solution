/*
 * @lc app=leetcode id=217 lang=java
 *
 * [217] Contains Duplicate
 */

// @lc code=start


// Method 1: Sorting
// Time complexity: O(nlogn). Sorting is O(nlogn) and the sweeping is O(n). The entire algorithm is dominated by the sorting step, which is O(nlogn).
// Space Complexity: O(1) - space depends on the sorting implementation which costs O(1) space if heapsort is used
public boolean containsDuplicate(int[] nums) {
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 1; ++i) {
        if (nums[i] == nums[i + 1]) return true;
    }
    return false;
}

// Method2: Hash Set
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

