/*
 * @lc app=leetcode id=449 lang=java
 *
 * [449] Serialize and Deserialize BST
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = postOrder(root, new StringBuilder());
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public StringBuilder postOrder(TreeNode root, StringBuilder sb) {
        if (root == null) return sb;
        postOrder(root.left, sb);
        postOrder(root.right, sb);
        sb.append(root.val);
        sb.append(' ');
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        ArrayDeque<Integer> nums = new ArrayDeque<Integer>();
        for (String s: data.split("\\s+")) nums.add(Integer.valueOf(s));
        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE, nums);
    }

    public TreeNode helper(Integer low, Integer upper, ArrayDeque<Integer> nums) {
        if (nums.isEmpty())
            return null;
        int val = nums.getLast();
        if (val < low || val > upper) return null;
        nums.removeLast();
        TreeNode root = new TreeNode(val);
        root.right = helper(val, upper, nums);
        root.left = helper(low, val, nums);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
// @lc code=end

