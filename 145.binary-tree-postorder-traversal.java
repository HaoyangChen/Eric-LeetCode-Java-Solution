/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
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

 // Method 1: Recursive Postorder Traversal
 // Time Complexity: O(N) - where N is the number of nodes. We visit each node exactly once, thus the time complexity is O(N)
 // Space Complexity: O(N) -  Up to O(H) to keep the recursion stack, where H is the tree height. H is the tree height. In the worst case of the skewed tree H = N.
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postorderTraversal(root, ans);
        return ans;
    }
    
    private void postorderTraversal(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left, ans);
        postorderTraversal(root.right, ans);
        ans.add(root.val);
    }
}


// @lc code=end

