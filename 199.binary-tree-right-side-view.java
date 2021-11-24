/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
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
//     public List<Integer> rightSideView(TreeNode root) {
//         Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
//         int max_depth = -1;

//         Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
//         Queue<Integer> depthQueue = new LinkedList<Integer>();
//         nodeQueue.add(root);
//         depthQueue.add(0);

//         while (!nodeQueue.isEmpty()) {
//             TreeNode node = nodeQueue.remove();
//             int depth = depthQueue.remove();

//             if (node != null) {
//                 max_depth = Math.max(max_depth, depth);
//                 rightmostValueAtDepth.put(depth, node.val);

//                 nodeQueue.add(node.left);
//                 nodeQueue.add(node.right);
//                 depthQueue.add(depth+1);
//                 depthQueue.add(depth+1);
//             }
//         }

//         List<Integer> rightView = new ArrayList<Integer>();
//         for (int depth = 0; depth <= max_depth; depth++) {
//             rightView.add(rightmostValueAtDepth.get(depth));
//         }

//         return rightView;
//     }
// }

// Method 2: Recursive DFS
// Time Complexity: O(N) since one has to visit each node
// Space Complexity: O(H) to keep the recursion stack, where H is the tree height. In the worst-case situation is a skewed tree, when H = N
// class Solution {
//     List<Integer> result = new ArrayList();
//     public List<Integer> rightSideView(TreeNode root) {
//         if (root == null) return result;
//         helper(root, 0);
//         return result;
//     }
    
//     private void helper(TreeNode node, int level) {
//         if (level == result.size()) {
//             result.add(node.val);
//         }
//         if (node.right != null) {
//             helper(node.right, level + 1);
//         }
//         if (node.left != null) {
//             helper(node.left, level + 1);
//         }
//     }
// }


// BFS: One Queue + Level Size Measurements
// Time Complexity: O(N) since each node has to be visited
// Space Complexity: O(D) to keep the queues, where D is a tree's diameter. The level can contain up to N/2 tree nodes in the case of a complete binary tree.
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque(){{ offer(root); }};
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (i == levelSize - 1) {
                    result.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return result;
    }
}
// @lc code=end

