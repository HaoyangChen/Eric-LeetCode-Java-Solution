/*
 * @lc app=leetcode id=107 lang=java
 *
 * [107] Binary Tree Level Order Traversal II
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

 // Time Complexity: O(n) - n is the total number of nodes in the binary tree. Each node is visited exactly once, and adding a level of nodes to the linkedlist takes O(1) time. So the overall time complexity is O(n).
 // Space Complexity: O(n) - where n is the total number of nodes in the binary tree. Space complexity depends on the queue, and the number of nodes in the queue is at most n.
// class Solution {
//     public List<List<Integer>> levelOrderBottom(TreeNode root) {
//         List<List<Integer>> levelOrder = new LinkedList<List<Integer>>();
//         if (root == null) return levelOrder;
//         Queue<TreeNode> queue = new LinkedList<TreeNode>();
//         queue.offer(root);

//         while (!queue.isEmpty()) {
//             List<Integer> level = new ArrayList<Integer>();
//             int size = queue.size();
//             for (int i = 0; i < size; i++) {
//                 TreeNode node = queue.poll();
//                 level.add(node.val);
//                 TreeNode left = node.left, right = node.right;
//                 if (left != null) {
//                     queue.offer(left);
//                 }
//                 if (right != null) {
//                     queue.offer(right);
//                 }
//             }
//             levelOrder.add(0, level);
//         }
//         return levelOrder;
//     }
// }


// Shangan Solution
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.addFirst(level);
        }
        return result;
    }
}
// @lc code=end

