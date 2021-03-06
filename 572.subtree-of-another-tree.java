/*
 * @lc app=leetcode id=572 lang=java
 *
 * [572] Subtree of Another Tree
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

// Approach 1: Using Preorder Traversal
// Time Complexity:  O(m^2+n^2+m*n) A total of n nodes of the tree s and m nodes of tree t are traversed. Assuming string concatenation takes O(k) time for strings of length k and indexOf takes O(m*n).
// Space Complexity: O(max(m, n)) The depth of the recursion tree can go up to n for tree t and m for tree s in the worst case. 
//  class Solution {
//     public boolean isSubtree(TreeNode root, TreeNode subRoot) {
//         String tree1 = preOrder(root, true);
//         String tree2 = preOrder(subRoot, true);
//         return tree1.indexOf(tree2) >= 0;
//     }

//     public String preOrder(TreeNode node, boolean left) {
//         if (node == null) {
//             if (left)
//                 return "lnull";
//             else 
//                 return "rnull";
//         }
//         return "#" + node.val + " " + preOrder(node.left, true) + " " + preOrder(node.right, false);
//     }
// }


// Approach 2: By Comparison of Nodes
// Time Complexity: O(m * n) - In the worst case (skewed tree), traverse function takes (m * n) time
// Space Complexity: O(n) - The depth of the recursion tree can go up to n. n refers to the number of nodes in s  
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return traverse(root, subRoot);
    }

    public boolean equals(TreeNode x, TreeNode y) {
        if (x == null && y == null) return true;
        if (x == null || y == null) return false;
        return x.val == y.val && equals(x.left, y.left) && equals(x.right, y.right);
    }

    private boolean traverse(TreeNode s, TreeNode t) {
        return s!= null && (equals(s, t) || traverse(s.left, t) || traverse(s.right, t));
    }
}
// @lc code=end

