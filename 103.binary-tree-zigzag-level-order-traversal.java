/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
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
// class Solution {
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//         List<List<Integer>> ans = new LinkedList<List<Integer>>();
//         if (root == null) return ans;
//         Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
//         nodeQueue.offer(root);
//         boolean isOrderLeft = true;

//         while(!nodeQueue.isEmpty()) {
//             Deque<Integer> levelList = new LinkedList<Integer>();
//             int size = nodeQueue.size();
//             for (int i = 0; i < size; ++i) {
//                 TreeNode curNode = nodeQueue.poll();
//                 if (isOrderLeft) {
//                     levelList.offerLast(curNode.val);
//                 } else {
//                     levelList.offerFirst(curNode.val);
//                 }
//                 if (curNode.left != null) {
//                     nodeQueue.offer(curNode.left);
//                 }
//                 if (curNode.right != null) {
//                     nodeQueue.offer(curNode.right);
//                 }
//             }
//             ans.add(new LinkedList<Integer>(levelList));
//             isOrderLeft = !isOrderLeft;
//         }
//         return ans;
//     }
// }


// shangan
// class Solution {
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//         List<List<Integer>> result = new ArrayList<>();
//         Queue<TreeNode> queue = new LinkedList<>();
//         boolean leftToRight = false;
//         queue.offer(root);

//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             LinkedList<Integer> level = new LinkedList<>();
//             for (int i = 0; i < size; i++) {
//                 TreeNode node = queue.poll();
//                 if (node == null) {
//                     continue;
//                 }
//                 if (leftToRight) {
//                     level.addFirst(node.val);
//                 } else {
//                     level.add(node.val);
//                 }
//                 queue.offer(node.left);
//                 queue.offer(node.right);
//             }
//             if (!level.isEmpty()) {
//                 result.add(level);
//             }
//             leftToRight = !leftToRight;
//         }
//         return result;
//     }
// }

// Method 2: DFS (Depth-First Search)
// Time Complexity: O(N) where N is the number of nodes in the tree
// Space Complexity: O(H) where H is the height of the tree, which would roughly be log2(N)
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        dfs(results, 0, root);
        return results;
    }

    private void dfs(List<List<Integer>> results, int level, TreeNode node) {
        if (level >= results.size()) {
            LinkedList<Integer> newLevel = new LinkedList<Integer>();
            newLevel.add(node.val);
            results.add(newLevel);
        } else {
            if (level % 2 == 0) {
                results.get(level).add(node.val);
            } else {
                results.get(level).add(0, node.val);
            }
        }
        if (node.left != null) dfs(results, level + 1, node.left);
        if (node.right != null) dfs(results, level + 1, node.right);
    }
}

// @lc code=end

