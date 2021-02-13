/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */

// @lc code=start

// Shangan Solution
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        result.add(path);
        Arrays.sort(nums);
        helper(nums, 0, result, path);
        return result;
    }

    private void helper(int[] nums, int index, List<List<Integer>> result, List<Integer> path) {
        if (path.size() == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            result.add(new ArrayList<>(path));
            helper(nums, i + 1, result, path);
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

