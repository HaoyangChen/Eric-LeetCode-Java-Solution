/*
 * @lc app=leetcode id=700 lang=java
 *
 * [700] Search in a Binary Search Tree
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

// Method 1: Recusion
// Time Complexity: O(H), where H is the tree height. That results in O(logN) in the average case, and O(N) in the worst case
// Space Complexity: O(H) to keep the recursion stack. O(logN) in the average case, and O(N) in the worst case
// class Solution {
//     public TreeNode searchBST(TreeNode root, int val) {
//         if (root == null || root.val == val) return root;

//         return val < root.val ? searchBST(root.left, val) :searchBST(root.right, val);
//     }
// }


// Method 2: Iteration
// Time complexity: O(H), where H is a tree height
// Space complexity: O(1) since it's a constant space solution.
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && val != root.val) {
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }
}
// @lc code=end

