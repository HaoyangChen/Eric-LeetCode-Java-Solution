/*
 * @lc app=leetcode id=108 lang=java
 *
 * [108] Convert Sorted Array to Binary Search Tree
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

// Method 1: Preorder Traversal: Always Choose Left Middle Node as a Root
// Time complexity: O(N) since we visit each node exactly once.
// Space complexity: O(N). O(N) to keep the output, and O(logN) for the recursion stack.
// class Solution {
//     int[] nums;
  
//     public TreeNode helper(int left, int right) {
//       if (left > right) return null;
  
//       // always choose left middle node as a root
//       int p = left + (right - left) / 2;
  
//       // preorder traversal: node -> left -> right
//       TreeNode root = new TreeNode(nums[p]);
//       root.left = helper(left, p - 1);
//       root.right = helper(p + 1, right);
//       return root;
//     }
  
//     public TreeNode sortedArrayToBST(int[] nums) {
//       this.nums = nums;
//       return helper(0, nums.length - 1);
//     }
//   }


// Method 2: Preorder Traversal: Always Choose Right Middle Node as a Root
class Solution {
    int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length - 1);
    }

    public TreeNode helper(int left, int right) {
        if (left > right) return null;
        int p = left + (right - left) / 2;
        if ((left + right) % 2 == 1) ++p;

        TreeNode root = new TreeNode(nums[p]);
        root.left = helper(left, p - 1);
        root.right = helper(p + 1, right);
        return root;
    }
}

// @lc code=end

