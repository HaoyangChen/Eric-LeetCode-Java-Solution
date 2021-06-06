/*
 * @lc app=leetcode id=662 lang=java
 *
 * [662] Maximum Width of Binary Tree
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

// Method 1: BFS
// Time Complexity: O(N) - We visit each node once and only once. And at each visit, it takes a constant time to process.
// Space Complexity: O(N) - We used a queue to maintain the nodes along with its indices, which is the main memory consumption of the algorithm.
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        Integer maxWidth = 0;
        queue.addLast(new Pair<>(root, 0));
        while (queue.size() > 0) {
            Pair<TreeNode, Integer> head = queue.getFirst();
            Integer currentLevelSize = queue.size();
            Pair<TreeNode, Integer> element = null;
            for (int i = 0; i < currentLevelSize; i++) {
                element = queue.removeFirst();
                TreeNode node = element.getKey();
                if (node.left != null) {
                    queue.addLast(new Pair<>(node.left, 2 * element.getValue()));
                }
                if (node.right != null) {
                    queue.addLast(new Pair<>(node.right, 2 * element.getValue() + 1));
                }
            }
            maxWidth = Math.max(maxWidth, element.getValue() - head.getValue() + 1);
        }
        return maxWidth;
    }
}
// @lc code=end

