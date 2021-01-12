/*
 * @lc app=leetcode id=235 lang=java
 *
 * [235] Lowest Common Ancestor of a Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


 // Time Complexity: O(N) - where N is the number of nodes in the BST. In the worst case, we might be visiting all the nodes of the BST
 // Space Complexity: O(N) - This is because the maximum amount of space used by the recursion stack is N since the height of a skewed BST could be N
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Value of current node or parent node
        int parentVal = root.val;
        // value of p
        int pVal = p.val;
        // value of q
        int qVal = q.val;
        if (pVal > parentVal && qVal > parentVal) {
            // if both p and q are greater than parent
            return lowestCommonAncestor(root.right, p, q);
        } else if (pVal < parentVal && qVal < parentVal) {
            // if both p and q are lesser than parent
            return lowestCommonAncestor(root.left, p, q);
        } else {
            // We have found the split point i.e. the LCA node
            return root;
        }
    }
}
// @lc code=end

