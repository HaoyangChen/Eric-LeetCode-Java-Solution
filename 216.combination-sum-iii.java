/*
 * @lc app=leetcode id=216 lang=java
 *
 * [216] Combination Sum III
 */

// @lc code=start
import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        LinkedList<Integer> combo = new LinkedList<Integer>();
        this.backtrack(n, k, combo, 0, result);
        return result;
    }

    protected void backtrack(int remainingNumber, int k, LinkedList<Integer> combo, int nextStartNumber, List<List<Integer>> result) {
        if (remainingNumber == 0 && combo.size() == k) {
            result.add(new ArrayList<Integer>(combo));
            return;
        } else if (remainingNumber < 0 || combo.size() == k) {
            return;
        }
        for (int i = nextStartNumber; i < 9; i++) {
            combo.add(i + 1);
            this.backtrack(remainingNumber - i - 1, k, combo, i + 1, result);
            combo.removeLast();
        }
    }
}
// @lc code=end

