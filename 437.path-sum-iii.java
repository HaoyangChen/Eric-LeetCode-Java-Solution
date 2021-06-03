/*
 * @lc app=leetcode id=437 lang=java
 *
 * [437] Path Sum III
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

// Method: Prefix Sum
// Time Complexity: where N is a number of nodes. During preorder traversal, each node is visited once.
// Space Complexity: Up to O(N) to keep the hashmap of prefix sums, where N is a number of nodes
class Solution {
    int count = 0;
    int k;
    HashMap<Integer, Integer> h = new HashMap();

    public int pathSum(TreeNode root, int targetSum) {
        k = targetSum;
        preorder(root, 0);
        return count;
    }

    private void preorder(TreeNode node, int currSum) {
        if (node == null) return;
        currSum += node.val;
        if (currSum == k) count++;
        count += h.getOrDefault(currSum - k, 0);
        h.put(currSum, h.getOrDefault(currSum, 0) + 1);
        preorder(node.left, currSum);
        preorder(node.right, currSum);
        h.put(currSum, h.get(currSum) - 1);
    }
}
// @lc code=end

