/*
 * @lc app=leetcode id=236 lang=java
 *
 * [236] Lowest Common Ancestor of a Binary Tree
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

 
// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         if (root == null || root == p || root == q) {
//             return root;
//         }
//         TreeNode left = lowestCommonAncestor(root.left, p, q);
//         TreeNode right = lowestCommonAncestor(root.right, p, q);
//         if (left != null && right != null) {
//             return root;
//         }
//         return left == null ? right : left; 
//     }
// }

// Method 1: Recursive Approach
// Time Complexity: O(N), where N is the number of nodes in the binary tree. In the worst case we //                  might be visiting all the nodes of the binary tree.
// Space Complexity: O(N). the maximum amount of space utilized by the recursion stack would be N //                  since the height of the skewed binary tree could be N
// class Solution {
//     private TreeNode ans;

//     public Solution() {
//         this.ans = null;
//     }
    
//     private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
//         if (currentNode == null) {
//             return false;
//         }
        
//         int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;
//         int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;
//         int mid = (currentNode == p || currentNode == q) ? 1 : 0;
        
//         if (left + right + mid >= 2) {
//             this.ans = currentNode;
//         }
//         return (mid + left + right > 0);
//     }
    
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         this.recurseTree(root, p, q);
//         return this.ans;
//     }
// }


// Method 2: Iterative using parent pointers
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);
        stack.push(root);

        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
    }
}
// @lc code=end

