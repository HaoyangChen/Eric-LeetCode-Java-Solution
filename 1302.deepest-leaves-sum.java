/*
 * @lc app=leetcode id=1302 lang=java
 *
 * [1302] Deepest Leaves Sum
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

// DFS Implementation with recursion
class Solution {
    int maxDepth = -1;
    int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode root, int depth) {
        if (root == null) {
            return 0;
        }
        if (maxDepth < depth) {
            maxDepth = depth;
            sum = root.val;
        } else if (maxDepth == depth) {
            sum += root.val;
        }
        if (root.left != null) {
            dfs(root.left, depth + 1);
        }
        
        if (root.right != null) {
            dfs(root.right, depth + 1);
        }
        return sum;
    }
}
// @lc code=end

