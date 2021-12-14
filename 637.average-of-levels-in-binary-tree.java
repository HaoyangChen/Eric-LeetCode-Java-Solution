/*
 * @lc app=leetcode id=637 lang=java
 *
 * [637] Average of Levels in Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Integer> count = new ArrayList<>();
        List<Double> result = new ArrayList<>();
        calculateAverage(root, 0, result, count);
        for (int i = 0; i < result.size(); i++) result.set(i, result.get(i) / count.get(i));
        return result;
    }
    
    private void calculateAverage(TreeNode node, int i, List<Double> sum, List<Integer> count) {
        if (node == null) return;
        if (i < sum.size()) {
            sum.set(i, sum.get(i) + node.val);
            count.set(i, count.get(i) + 1);
        } else {
            sum.add(1.0 * node.val);
            count.add(1);
        }
        calculateAverage(node.left, i + 1, sum, count);
        calculateAverage(node.right, i + 1, sum, count);
    }
}
// @lc code=end

