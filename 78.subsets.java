/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start

// Shangan Solution
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        result.add(path);
        helper(nums, path, result, 0);
        return result;
    }

    private void helper(int[] nums, List<Integer> path, List<List<Integer>> result, int start) {
        for (int i = start; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            result.add(new ArrayList<>(path));
            helper(nums, path, result, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

