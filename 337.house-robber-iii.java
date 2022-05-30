/*
 * @lc app=leetcode id=337 lang=java
 *
 * [337] House Robber III
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

 import java.util.*;
 
// class Solution {
//     HashMap<TreeNode, Integer> memo = new HashMap<>();
//     public int rob(TreeNode root) {
//         if (root == null) return 0;
//         if (memo.containsKey(root)) return memo.get(root);
//         int robIt = root.val + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right)) + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
//         int notRobIt = rob(root.left) + rob(root.right);
//         int result = Math.max(robIt, notRobIt);
//         memo.put(root, result);
//         return result;
//     }
// }


class Solution {
    public int rob(TreeNode root) {
        int[] result = robHelper(root);
        return Math.max(result[0], result[1]);
    }

    private int[] robHelper(TreeNode root) {
        if (root == null) return new int[2];
        int[] left = robHelper(root.left);
        int[] right = robHelper(root.right);
        int[] result = new int[2];
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = root.val + left[0] + right[0];
        return result;
    }
}
// @lc code=end

