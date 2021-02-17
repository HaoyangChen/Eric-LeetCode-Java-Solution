/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
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

// Recursive Inorder Traversal
// Time Complexity: O(n) - in the worst case when the tree is a BST and the "bad" element is a rightmost leaf.
// Space Complexity: O(n) - for the space on the run-time stack
// class Solution {
//     private Integer prev;
//     public boolean isValidBST(TreeNode root) {
//         prev = null;
//         return inOrder(root);
//     }

//     private boolean inOrder(TreeNode root) {
//         if (root == null) {
//             return true;
//         }
//         if (!inOrder(root.left)) {
//             return false;
//         }
//         if (prev != null && root.val <= prev) {
//             return false;
//         }
//         prev = root.val;
//         return inOrder(root.right);
//     }
// }

// Shangan Solution
// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
//     }
    
//     private boolean helper(TreeNode node, long max, long min) {
//         if (node == null) {
//             return true;
//         }
//         return helper(node.left, node.val, min) && helper(node.right, max, node.val) && node.val < max && node.val > min;
//     }
// }


// LeetCode Solution: Recursive Traversal with Valid Range
// Time Complexity: O(N) - since we visit each node exactly once
// Space Complexity: O(N) - since we keep up to the entire tree
// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         return validate(root, null, null);
//     }
    
//     private boolean validate(TreeNode root, Integer low, Integer high) {
//         // empty trees are valid BSTs
//         if (root == null) {
//             return true;
//         }
        
//         // The current node's value must be between low and high
//         if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
//             return false;
//         }
//         // The left and right subtree must also be valid
//         return validate(root.right, root.val, high) && validate(root.left, low, root.val);
//     }
// }

// Method: recursive inorder traversal
class Solution {
    private Integer prev;
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inorder(root);
    }
    
    private boolean inorder(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!inorder(root.left)) {
            return false;
        }
        if (prev != null && root.val <= prev) {
            return false;
        }
        prev = root.val;
        return inorder(root.right);
    }
}
// @lc code=end

