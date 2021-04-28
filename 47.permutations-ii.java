/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 */

// @lc code=start
// shangan solution
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, new HashSet<>(), new ArrayList<>());
        return result;
    }

    private void dfs(int[] nums, Set<Integer> visited, List<Integer> list) {
        if (visited.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !visited.contains[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (visited.contains(i) || (i > 0 && nums[i] == nums[i - 1]) && !visited.contains(i - 1)) {
                continue;
            }
            visited.add(i);
            list.add(nums[i]);
            dfs(nums, visited, list);
            visited.remove(i);
            list.remove(list.size() - 1);
        }
    }
}
// @lc code=end

