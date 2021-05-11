/*
 * @lc app=leetcode id=701 lang=java
 *
 * [701] Insert into a Binary Search Tree
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

// Method 1: Recursion
// class Solution {
//     public TreeNode insertIntoBST(TreeNode root, int val) {
//         if (root == null) return new TreeNode(val);

//         // insert into the right subtree
//         if (val > root.val) root.right = insertIntoBST(root.right, val);
//         // insert into the left subtree
//         else root.left = insertIntoBST(root.left, val);
//         return root;
//     }
// }


// Method 2: Iteration
// Time Complexity: O(H), where H is the tree height. This results in O(logN) in the average case, and O(N) in the worst case
// Space Complexity: O(1) since this is a constant space solution
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = root;
        while (node != null) {
            // insert into the right subtree
            if (val > node.val) {
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    return root;
                } else {
                    node = node.right;
                }
                // insert into the left subtree
            } else {
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    return root;
                } else {
                    node = node.left;
                }
            }
        }
        return new TreeNode(val);
    }
}
// @lc code=end

