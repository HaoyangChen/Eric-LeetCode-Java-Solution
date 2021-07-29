/*
 * @lc app=leetcode id=652 lang=java
 *
 * [652] Find Duplicate Subtrees
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
//     private HashMap<String, Integer> memo = new HashMap<>();
//     private LinkedList<TreeNode> res = new LinkedList<>();  
//     public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
//         traverse(root);
//         return res;
//     }

//     private String traverse(TreeNode root) {
//         if (root == null) {
//             return "#";
//         }
//         String left = traverse(root.left);
//         String right = traverse(root.right);
//         String subtree = left + "," + right + "," + root.val;
//         int freq = memo.getOrDefault(subtree, 0);
//         if (freq == 1) {
//             res.add(root);
//         }
//         memo.put(subtree, freq + 1);
//         return subtree;
//     }
// }

// Method 2： Hashmap
class Solution {
    int t;
    Map<String, Integer> trees;
    Map<Integer, Integer> count;
    List<TreeNode> ans;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        t = 1;
        trees = new HashMap();
        count = new HashMap();
        ans = new ArrayList();
        lookup(root);
        return ans;
    }

    public int lookup(TreeNode node) {
        if (node == null) return 0;
        String serial = node.val + "," + lookup(node.left) + "," + lookup(node.right);
        int uid = trees.computeIfAbsent(serial, x-> t++);
        count.put(uid, count.getOrDefault(uid, 0) + 1);
        if (count.get(uid) == 2)
            ans.add(node);
        return uid;
    }
}

// @lc code=end

