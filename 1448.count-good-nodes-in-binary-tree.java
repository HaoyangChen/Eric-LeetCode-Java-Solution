/*
 * @lc app=leetcode id=1448 lang=java
 *
 * [1448] Count Good Nodes in Binary Tree
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

//  import java.util.*;

// Shangan Solution
// class Solution {
//     public int goodNodes(TreeNode root) {
//         return goodNodes(root, -10000);
//     }
    
//     private int goodNodes(TreeNode root, int max) {
//         if (root == null) {
//             return 0;
//         }
//         int result = root.val >= max ? 1 : 0;
//         result += goodNodes(root.left, Math.max(max, root.val));
//         result += goodNodes(root.right, Math.max(max, root.val));
//         return result;
//     }
// }

// DFS - Recursion
// Time Complexity: O(N) - With DFS we visit each node exactly one and do a constant amount of work each time
// Space Complexity: O(N) - Because DFS prioritizes depth, our call stack can be as large as the height H of the tree. In the worst case, H = N, if the tree has only one path
class Solution {
    private int numberOfGoodNodes = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return numberOfGoodNodes;
    }
    
    private void dfs(TreeNode node, int maxSoFar) {
        if (maxSoFar <= node.val) {
            numberOfGoodNodes++;
        }
        if (node.right != null) {
            dfs(node.right, Math.max(maxSoFar, node.val));
        }
        if (node.left != null) {
            dfs(node.left, Math.max(maxSoFar, node.val));
        }
    }
}
// @lc code=end

