/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
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

// Method 1: Recursion
// Time Complexity: O(N) - we visit each node exactly once, thus the time complexity is O(N), where N is the number of nodes, i.e. the size of tree
// Space Complexity: O(N) - depending on the tree structure, we could keep up to the entire tree. In the average case the space complexity is O(logn). In the worst case, when the tree is like linkedlist, the space complexity is O(N)
// class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> res = new ArrayList<Integer>();
//         preorder(root, res);
//         return res;
//     }
    
//     private void preorder(TreeNode root, List<Integer> res) {
//         if (root == null) {
//             return;
//         }
//         res.add(root.val);
//         preorder(root.left, res);
//         preorder(root.right, res);
//     }
// }

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }
}


// @lc code=end

