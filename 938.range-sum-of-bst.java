/*
 * @lc app=leetcode id=938 lang=java
 *
 * [938] Range Sum of BST
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


 // Recursive Implementation
// class Solution {
//     int ans;
//     public int rangeSumBST(TreeNode root, int low, int high) {
//         ans = 0;
//         dfs(root, low, high);
//         return ans;
//     }

//     private void dfs(TreeNode node, int low, int high) {
//         if (node != null) {
//             if (node.val >= low && node.val <= high) {
//                 ans += node.val;
//             }
//             if (low < node.val) {
//                 dfs(node.left, low, high);
//             }
//             if (high > node.val) {
//                 dfs(node.right, low, high);
//             }
//         }
//     }
// }


// Iterative Implementation
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int ans = 0;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (low <= node.val && node.val <= high) {
                    ans += node.val;
                }
                if (low < node.val) {
                    stack.push(node.left);
                }
                if (node.val < high) {
                    stack.push(node.right);
                }
            }
        }
        return ans;
    }
}
// @lc code=end

