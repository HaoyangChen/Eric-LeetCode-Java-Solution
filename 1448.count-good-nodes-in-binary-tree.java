/*
 * @lc app=leetcode id=1448 lang=java
 *
 * [1448] Count Good Nodes in Binary Tree
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

// Shangan Solution
class Solution {
    public int goodNodes(TreeNode root) {
        return goodNodes(root, -10000);
    }
    
    private int goodNodes(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        int result = root.val >= max ? 1 : 0;
        result += goodNodes(root.left, Math.max(max, root.val));
        result += goodNodes(root.right, Math.max(max, root.val));
        return result;
    }
}
// @lc code=end

