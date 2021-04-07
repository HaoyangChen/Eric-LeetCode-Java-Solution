/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
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

// Recursion Method
// Time Complexity: O(N)
// Space Complexity: O(N), since we store the entire tree
class Solution {
    int post_index;
    int[] postorder;
    int[] inorder;
    HashMap<Integer, Integer> index_map = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        post_index = postorder.length - 1;
        int idx = 0;
        for (Integer val: inorder) {
            index_map.put(val, idx++);
        }
        return helper(0, inorder.length - 1);
    }

    public TreeNode helper(int in_left, int in_right) {
        if (in_left > in_right) {
            return null;
        }
        int root_val = postorder[post_index];
        TreeNode root = new TreeNode(root_val);
        int index = index_map.get(root_val);
        post_index--;
        root.right = helper(index + 1, in_right);
        root.left = helper(in_left, index - 1);
        return root;
    }
}
// @lc code=end

