/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
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

// Shangan Solution
class Solution {
    List <List<Integer>> result;
    public List<String> binaryTreePaths(TreeNode root) {
        result = new ArrayList<>();
        helper(root, new ArrayList<>());
        return convert();
    }
    
    private void helper (TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        
        if (node.left == null && node.right == null) {
            result.add(new ArrayList<>(list));
        } else {
            helper(node.left, list);
            helper(node.right, list);
        }
        list.remove(list.size() - 1);
    }
    
    private List<String> convert() {
        return result.stream()
            .map(list -> {
                StringBuilder sb = new StringBuilder();
                for (int element: list) {
                    sb.append(element);
                    sb.append("->");
                }
                sb.setLength(sb.length() - 2);
                return sb.toString();
            })
            .collect(Collectors.toList());
    }
}
// @lc code=end

