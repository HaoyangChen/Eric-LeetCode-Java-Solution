/*
 * @lc app=leetcode id=491 lang=java
 *
 * [491] Increasing Subsequences
 */

// @lc code=start

// Shangan
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> findSubsequences(int[] nums) {
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    
    private void helper(int[] nums, int index, List<Integer> numbers) {
        if (numbers.size() > 1) {
            result.add(new ArrayList<>(numbers));
        }
        Set<Integer> visited = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (visited.contains(nums[i])) {
                continue;
            }
            if (!numbers.isEmpty() && numbers.get(numbers.size() - 1) > nums[i]) {
                continue;
            }
            visited.add(nums[i]);
            numbers.add(nums[i]);
            helper(nums, i + 1, numbers);
            numbers.remove(numbers.size() - 1);
        }
    }
}
// @lc code=end

