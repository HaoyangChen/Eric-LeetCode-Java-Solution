/*
 * @lc app=leetcode id=230 lang=java
 *
 * [230] Kth Smallest Element in a BST
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
//     private int res = 0;
//     private int rank = 0;
//     public int kthSmallest(TreeNode root, int k) {
//         traverse(root, k);
//         return res;
//     }

//     private void traverse(TreeNode root, int k) {
//         if (root == null) return;
//         traverse(root.left, k);
//         rank++;
//         if (k == rank) {
//             res = root.val;
//             return;
//         }
//         traverse(root.right, k);
//     }
// }


// Method 1: Recursive Inorder Traversal
// Time Complexity: O(N) to build a traversal
// Space Complexity: O(N) to keep an inorder traversal

//  class Solution {
//     public int kthSmallest(TreeNode root, int k) {
//         ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
//         return nums.get(k - 1);
//     }
    
//     private ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
//         if (root == null) return arr;
//         inorder(root.left, arr);
//         arr.add(root.val);
//         inorder(root.right, arr);
//         return arr;
//     }
// }


// Method 2: Iterative Inorder Traversal
// Time Complexity: O(H + k), where H is a tree height. The complexity is defined by the stack, which contains at least H + k elements. since before starting to pop out one has to go down to a leaf. This results in O(logN+k) for the balanced tree and O(N+k) for completely unbalanced tree with all the nodes in the left subtree.
// Space Complexity: O(H) to keep the stack, where H is a tree height. That makes O(N) in the worst case of the skewed tree, and O(logN) in the average case of the balanced tree.
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }
}
// @lc code=end

