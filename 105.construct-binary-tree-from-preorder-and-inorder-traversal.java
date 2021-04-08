/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
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
//     int pre_idx = 0;
//     int[] preorder;
//     int[] inorder;
//     HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();
    
//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         this.preorder = preorder;
//         this.inorder = inorder;
        
//         int idx = 0;
//         for (Integer val: inorder)
//             idx_map.put(val, idx++);
//         return helper(0, inorder.length);
//     }
    
//     public TreeNode helper(int in_left, int in_right) {
//         if (in_left == in_right) return null;
//         int root_val = preorder[pre_idx];
//         TreeNode root = new TreeNode(root_val);
        
//         int index = idx_map.get(root_val);
        
//         pre_idx++;
//         root.left = helper(in_left, index);
//         root.right = helper(index + 1, in_right);
//         return root;
//     }
// }


// Time Complexity: O(N), building the hashmap takes O(N) time as there are N nodes to add. Adding items to a hashmap takes O(1), so we get N * O(1) = O(N). Building the tree also takes O(N) time. The recursive helper method has a cost of O(1) for each call, and it is called once for each of the N nodes, giving a total of O(N)
// Space Complexity: O(N), building the hashmap and storing the entire tree each requires O(N) memory.
class Solution {
    int preorderIndex;
    Map<Integer, Integer> inorderIndexMap;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return arrayToTree(preorder, 0, preorder.length - 1);
    }
    
    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        // if there are no elements to construct the tree
        if (left > right) return null;
        
        // select the preorderIndex element as the root and increment it
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);
        
        // build left and right subtree
        root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue) - 1);
        root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue) + 1, right);
        return root;
    }
}
// @lc code=end

