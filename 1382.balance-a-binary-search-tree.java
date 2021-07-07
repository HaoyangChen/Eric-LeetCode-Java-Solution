/*
 * @lc app=leetcode id=1382 lang=java
 *
 * [1382] Balance a Binary Search Tree
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

// Greedy Algorithm
// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    List<Integer> inorderSeq = new ArrayList<Integer>();

    public TreeNode balanceBST(TreeNode root) {
        getInorder(root);
        return build(0, inorderSeq.size() - 1);
    }

    public void getInorder(TreeNode o) {
        if (o.left != null) {
            getInorder(o.left);
        }
        inorderSeq.add(o.val);
        if (o.right != null) {
            getInorder(o.right);
        }
    }

    public TreeNode build(int left, int right) {
        int mid = (left + right) >> 1;
        TreeNode o = new TreeNode(inorderSeq.get(mid));
        if (left <= mid - 1) {
            o.left = build(left, mid - 1);
        } 
        if (mid + 1 <= right) {
            o.right = build(mid + 1, right);
        }
        return o;
    }
}
// @lc code=end

