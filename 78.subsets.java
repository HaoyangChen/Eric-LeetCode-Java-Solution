/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start

// Shangan Solution
// class Solution {
//     public List<List<Integer>> subsets(int[] nums) {
//         List<List<Integer>> result = new ArrayList<>();
//         List<Integer> path = new ArrayList<>();
//         result.add(path);
//         helper(nums, path, result, 0);
//         return result;
//     }

//     private void helper(int[] nums, List<Integer> path, List<List<Integer>> result, int start) {
//         for (int i = start; i < nums.length; i++) {
//             if (path.contains(nums[i])) {
//                 continue;
//             }
//             path.add(nums[i]);
//             result.add(new ArrayList<>(path));
//             helper(nums, path, result, i + 1);
//             path.remove(path.size() - 1);
//         }
//     }
// }

class Solution {
    List<List<Integer>> output = new ArrayList();
    int n, k;
    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        for (k = 0; k < n + 1; k++) {
            backtrack(0, new ArrayList<Integer>(), nums);
        }
        return output;
    }

    private void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
        if (curr.size() == k) {
            output.add(new ArrayList(curr));
            return;
        }
        for (int i = first; i < n; i++) {
            curr.add(nums[i]);
            backtrack(i + 1, curr, nums);
            curr.remove(curr.size() - 1);
        }
    }
}

// @lc code=end

