/*
 * @lc app=leetcode id=112 lang=java
 *
 * [112] Path Sum
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

// Method 1: recursion
// Time Complexity: we visit each node exactly once, thus the time complexity is O(N), where N is the number of nodes
// Space Complexity: in the worst case, the tree is completely unbalanced, each node has only one child node, the                              recursion call would occur N times (the height of the tree). Therefore, the storage to keep the call
//                   stack would be O(N). But in the best case (the tree is completely balanced), the height of the tree 
//                   would be log(N). Therefore, the time complexity in this case would be O(log(N))
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        int remain = targetSum - root.val;
        return hasPathSum(root.left, remain) || hasPathSum(root.right, remain);
    }
}
// @lc code=end

