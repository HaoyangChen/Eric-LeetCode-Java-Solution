/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start

// Shangan Solution
import java.util.*;
// class Solution {
//     List<List<Integer>> result;
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         result = new ArrayList<>();
//         dfs(candidates, 0, 0, target, new ArrayList<>());
//         return result;
//     }

//     private void dfs(int[] candidates, int index, int sum, int target, List<Integer> list) {
//         if (sum == target) {
//             result.add(new ArrayList<>(list));
//             return;
//         }
//         if (sum > target) {
//             return;
//         }
//         for (int i = index; i < candidates.length; i++) {
//             list.add(candidates[i]);
//             dfs(candidates, i, sum + candidates[i], target, list);
//             list.remove(list.size() - 1);
//         }
//     }
// }

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        LinkedList<Integer> combo = new LinkedList<>();
        this.backtrack(target, combo, 0, candidates, result);
        return result;
    }

    protected void backtrack(int remain, LinkedList<Integer> combo, int start, int[] candidates, List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<Integer>(combo));
            return;
        } else if (remain < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            combo.add(candidates[i]);
            this.backtrack(remain - candidates[i], combo, i, candidates, result);
            combo.removeLast();
        }
    }
}
// @lc code=end

