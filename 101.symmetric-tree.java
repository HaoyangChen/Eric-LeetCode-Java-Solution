/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
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

// Shangan Solution Method: stack
// class Solution {
//     public boolean isSymmetric(TreeNode root) {
//         if (root == null) return true;
//         Stack<TreeNode> stack = new Stack<>();
//         stack.push(root.left);
//         stack.push(root.right);
//         while (!stack.isEmpty()) {
//             TreeNode n1 = stack.pop();
//             TreeNode n2 = stack.pop();
//             if (n1 == null && n2 == null) {
//                 continue;
//             }
//             if (n1 == null || n2 == null || n1.val != n2.val) {
//                 return false;
//             }
//             stack.push(n1.left);
//             stack.push(n2.right);
//             stack.push(n1.right);
//             stack.push(n2.left);
//         }
//         return true;
//     }
// }

// Shangan Solution
// Time Complexity: O(n) - because we traverse the entire input tree once, the total run time is                            O(n), where n is the total number of nodes in the tree
// Space Complexity: O(n) - The number of recursive calls is bound by the height of the tree. In 
//                          the worst case, the tree is linear and height is in O(n). Therefore, 
//                          the space complexity due to recursive calls on stack is O(n) in the                               worst case
// class Solution {
//     public boolean isSymmetric(TreeNode root) {
//         return root == null || helper(root.left, root.right);
//     }
    
//     private boolean helper(TreeNode left, TreeNode right) {
//         if (left == null || right == null) {
//             return left == right;
//         }
//         if (left.val != right.val) {
//             return false;
//         }
//         return helper(left.left, right.right) && helper(left.right, right.left);
//     }
// }

// leetcode solution: recursive
// Time Complexity: O(n) - because we traverse the entire input tree once, the total run time is                            O(n), where n is the total number of nodes in the tree
// Space Complexity: O(n) - The number of recursive calls is bound by the height of the tree. In 
//                          the worst case, the tree is linear and height is in O(n). Therefore, 
//                          the space complexity due to recursive calls on stack is O(n) in the //                          worst case
// class Solution {
//     public boolean isSymmetric(TreeNode root) {
//         return isMirror(root, root);
//     }
    
//     private boolean isMirror(TreeNode t1, TreeNode t2) {
//         if (t1 == null && t2 == null) return true;
//         if (t1 == null || t2 == null) return false;
//         return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
//     }
// }

// Iterative Method
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
}
// @lc code=end

