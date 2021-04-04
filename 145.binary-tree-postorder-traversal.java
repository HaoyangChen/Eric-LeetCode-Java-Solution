/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
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

 // Method 1: Recursive Postorder Traversal
 // Time Complexity: O(N) - where N is the number of nodes. We visit each node exactly once, thus the time complexity is O(N)
 // Space Complexity: O(N) -  Up to O(H) to keep the recursion stack, where H is the tree height. H is the tree height. In the worst case of the skewed tree H = N.
// class Solution {
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> ans = new ArrayList<>();
//         postorderTraversal(root, ans);
//         return ans;
//     }
    
//     private void postorderTraversal(TreeNode root, List<Integer> ans) {
//         if (root == null) {
//             return;
//         }
//         postorderTraversal(root.left, ans);
//         postorderTraversal(root.right, ans);
//         ans.add(root.val);
//     }
// }

// Method 2: Iterative Postorder Traversal: Tweak the Order of the Output
// Time Complexity: O(N) - where N is the number of nodes. We visit each node exactly once, thus the time complexity is O(N)
// Space Complexity: O(N) -  Up to O(H) to keep the recursion stack, where H is the tree height. H is the tree height. In the worst case of the skewed tree H = N.
// class Solution {
//     public List<Integer> postorderTraversal(TreeNode root) {
//         LinkedList<Integer> output = new LinkedList();
//         Deque<TreeNode> stack = new ArrayDeque();
//         if (root == null) return output;

//         stack.push(root);
//         while (!stack.isEmpty()) {
//             root = stack.pop();
//             output.addFirst(root.val);
//             if (root.left != null) stack.push(root.left);
//             if (root.right != null) stack.push(root.right);
//         }
//         return output;
//     }
// }

// Method 3: Iterative Postorder Traversal
// Time Complexity: O(N) - where N is the number of nodes. We visit each node exactly once, thus the time complexity is O(N)
// Space Complexity: O(N) -  Up to O(H) to keep the recursion stack, where H is the tree height. H is the tree height. In the worst case of the skewed tree H = N.

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList();
        Deque<TreeNode> stack = new ArrayDeque();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                if (root.right != null) {
                    stack.push(root.right);
                }
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            
            // if the right subtree is not yet processed
            if (!stack.isEmpty() && root.right == stack.peek()) {
                stack.pop();
                stack.push(root);
                root = root.right;  
            // if we're on the leftmost leaf  
            } else {
                output.add(root.val);
                root = null;     
            }   
        }
        return output;
    }
}
// @lc code=end

