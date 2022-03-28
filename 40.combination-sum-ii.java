/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

// @lc code=start

// Shangan Solution
import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, result, path, 0);
        return result;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> result, List<Integer> path, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length && candidates[i] <= target; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            if (target - candidates[i] < 0) break; // optimization
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], result, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

