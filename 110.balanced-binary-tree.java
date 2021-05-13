/*
 * @lc app=leetcode id=110 lang=java
 *
 * [110] Balanced Binary Tree
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

 // Top-down recursion
 
// class Solution {
//     public boolean isBalanced(TreeNode root) {
//         if (root == null) return true;
//         return Math.abs(height(root.left) - height(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
//     }

//     private int height(TreeNode node) {
//         if (node == null) return -1;
//         return 1 + Math.max(height(node.left), height(node.right));
//     }
// }


// Bottom-up recursion
// Time Complexity: O(n) - For every subtree, we compute its height in constant time as well as compare the height of its children.
// Space Complexity: O(n) - The recursion stack may go up to O(n) if the tree is unbalanced
final class TreeInfo {
    public final int height;
    public final boolean balanced;
  
    public TreeInfo(int height, boolean balanced) {
      this.height = height;
      this.balanced = balanced;
    }
  }

class Solution {
    public boolean isBalanced(TreeNode root) {
        return isBalancedTreeHelper(root).balanced;
    }

    private TreeInfo isBalancedTreeHelper(TreeNode root) {
        if (root == null) {
            return new TreeInfo(-1, true);
        }
        TreeInfo left = isBalancedTreeHelper(root.left);
        if (!left.balanced) {
            return new TreeInfo(-1, false);
        }
        TreeInfo right = isBalancedTreeHelper(root.right);
        if (!right.balanced) {
            return new TreeInfo(-1, false);
        }
        if (Math.abs(left.height - right.height) < 2) {
            return new TreeInfo(Math.max(left.height, right.height) + 1, true);
        }
        return new TreeInfo(-1, false);
    }
}

// @lc code=end

