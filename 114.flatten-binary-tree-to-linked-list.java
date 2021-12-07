/*
 * @lc app=leetcode id=114 lang=java
 *
 * [114] Flatten Binary Tree to Linked List
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
// class Solution {
//     public void flatten(TreeNode root) {
//         if (root == null) return;
//         flatten(root.left);
//         flatten(root.right);

//         TreeNode left = root.left;
//         TreeNode right = root.right;

//         root.left = null;
//         root.right = left;

//         TreeNode p = root;
//         while (p.right != null) {
//             p = p.right;
//         }
//         p.right = right;
//     }
// }

// O(1) space iterative solution
// Time Complexity: O(N) since we process each node of the tree at most twice
// Spcae Complexity: O(1)
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode node = root;
        while (node != null) {
            if (node.left != null) {
                TreeNode rightMost = node.left;
                while (rightMost.right != null) {
                    rightMost = rightMost.right;
                }
                rightMost.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            node = node.right;
        }
    }
}
// @lc code=end

