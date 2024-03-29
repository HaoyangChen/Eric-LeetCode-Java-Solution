/*
 * @lc app=leetcode id=654 lang=java
 *
 * [654] Maximum Binary Tree
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
//     public TreeNode constructMaximumBinaryTree(int[] nums) {
//         return build(nums, 0, nums.length - 1);
//     }

//     private TreeNode build(int[] nums, int lo, int hi) {
//         if (lo > hi) return null;
//         int index = -1, maxVal = Integer.MIN_VALUE;
//         for (int i = lo; i <= hi; i++) {
//             if (maxVal < nums[i]) {
//                 index = i;
//                 maxVal = nums[i];
//             }
//         }
//         TreeNode root = new TreeNode(maxVal);
//         root.left = build(nums, lo, index - 1);
//         root.right = build(nums, index + 1, hi);
//         return root;
//     }
// }

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int low, int high) {
        if (low > high) return null;
        int index = -1, maxVal = Integer.MIN_VALUE;
        for (int i = low; i <= high; i++) {
            if (maxVal < nums[i]) {
                index = i;
                maxVal = nums[i];
            }
        }
        TreeNode root = new TreeNode(maxVal);
        root.left = build(nums, low, index - 1);
        root.right = build(nums, index + 1, high);
        return root;
    }
}
// @lc code=end

