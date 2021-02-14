/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
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

 // shangan solution
 // Time Complexity: We visit each node exactly once, thus the time complexity is O(N), where N is the number of nodes
 // Space Complexity: In the worst case, the tree is completely unbalanced, e.g. each node has only left child node, the recursion call would occur N times (the height of the tree), therefore the storage to keep the call stack would be O(N). 
 //                   But in the best case (the tree is completely balanced), the height of the tree would be log(N). Therefore, the space complexity in this case would be O(log(N)).
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);
        return Math.max(maxLeft, maxRight) + 1;
    }
}
// @lc code=end

