/*
 * @lc app=leetcode id=513 lang=java
 *
 * [513] Find Bottom Left Tree Value
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
//     public int findBottomLeftValue(TreeNode root) {
//         int result = 0;
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.offer(root);

//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             for (int i = 0; i < size; i++) {
//                 TreeNode node = queue.poll();
//                 if (i == size - 1) {
//                     result = node.val;
//                 }
//                 if (node.right != null) {
//                     queue.offer(node.right);
//                 }
//                 if (node.left != null) {
//                     queue.offer(node.left);
//                 }
//             }
//         }
//         return result;
//     }
// }

class Solution {
    private int result;
    private int maxDepth;
    public int findBottomLeftValue(TreeNode root) {
        result = 0;
        maxDepth = 0;
        helper(root, 1);
        return result;
    }
    
    private void helper(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (maxDepth < depth) {
            result = node.val;
            maxDepth = depth;
        }
        depth++;
        helper(node.left, depth);
        helper(node.right, depth);
    }
}
// @lc code=end

