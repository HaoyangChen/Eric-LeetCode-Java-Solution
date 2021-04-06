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
// class Solution {
//     public boolean hasPathSum(TreeNode root, int targetSum) {
//         if (root == null) {
//             return false;
//         }
//         if (root.left == null && root.right == null) {
//             return targetSum == root.val;
//         }
//         int remain = targetSum - root.val;
//         return hasPathSum(root.left, remain) || hasPathSum(root.right, remain);
//     }
// }

// Method 2: Iteration
// Time Complexity: the same as recursion method --  we visit each node exactly once, thus the time complexity is O(N), where N is the number of nodes
// Space Complexity: in the worst case, the tree is completely unbalanced, each node has only one child node, the                              recursion call would occur N times (the height of the tree). Therefore, the storage to keep the call
//                   stack would be O(N). But in the best case (the tree is completely balanced), the height of the tree 
//                   would be log(N). Therefore, the time complexity in this case would be O(log(N))
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
                return false;
        }
        LinkedList<TreeNode> node_stack = new LinkedList<>();
        LinkedList<Integer> sum_stack = new LinkedList<>();
        node_stack.add(root);
        sum_stack.add(targetSum - root.val);

        TreeNode node;
        int curr_sum;
        while (!node_stack.isEmpty()) {
            node = node_stack.pollLast();
            curr_sum = sum_stack.pollLast();
            if ((node.left == null) && (node.right == null) && (curr_sum == 0)) {
                return true;
            }
            if (node.right != null) {
                node_stack.add(node.right);
                sum_stack.add(curr_sum - node.right.val);
            }
            if (node.left != null) {
                node_stack.add(node.left);
                sum_stack.add(curr_sum - node.left.val);
            }
        }
        return false;
    }
}
// @lc code=end

