/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */

// @lc code=start

// Shangan Solution
// class Solution {
//     public List<List<Integer>> subsetsWithDup(int[] nums) {
//         List<List<Integer>> result = new ArrayList<>();
//         List<Integer> path = new ArrayList<>();
//         result.add(path);
//         Arrays.sort(nums);
//         helper(nums, 0, result, path);
//         return result;
//     }

//     private void helper(int[] nums, int index, List<List<Integer>> result, List<Integer> path) {
//         if (path.size() == nums.length) {
//             return;
//         }
//         for (int i = index; i < nums.length; i++) {
//             if (i != index && nums[i] == nums[i - 1]) {
//                 continue;
//             }
//             path.add(nums[i]);
//             result.add(new ArrayList<>(path));
//             helper(nums, i + 1, result, path);
//             path.remove(path.size() - 1);
//         }
//     }
// }


class Solution {
    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0);
        return result;
    }
    
    private void backtrack(int[] nums, int start) {
        result.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            track.addLast(nums[i]);
            backtrack(nums, i + 1);
            track.removeLast();
        }
    }
}
// @lc code=end

