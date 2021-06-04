/*
 * @lc app=leetcode id=889 lang=java
 *
 * [889] Construct Binary Tree from Preorder and Postorder Traversal
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

 // Method 1: Recursion
 // Time Complexity: O(N^2), where N is the total number of nodes
 // Space Complexity: O(N^2)
// class Solution {
//     public TreeNode constructFromPrePost(int[] pre, int[] post) {
//         int N = pre.length;
//         if (N == 0) return null;
//         TreeNode root = new TreeNode(pre[0]);
//         if (N == 1) return root;

//         int L = 0;
//         for (int i = 0; i < N; ++i) {
//             if (post[i] == pre[1]) {
//                 L = i + 1;   
//             }
//         }
//         root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, L + 1), Arrays.copyOfRange(post, 0, L));
//         root.right = constructFromPrePost(Arrays.copyOfRange(pre, L + 1, N), Arrays.copyOfRange(post, L, N - 1));
//         return root;

//     }
// }


 // Method 2: Recursion with better space complexity
 // Time Complexity: O(N^2), where N is the total number of nodes
 // Space Complexity: O(N)
class Solution {
    int[] pre, post;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        this.pre = pre;
        this.post = post;
        return make(0, 0, pre.length);
    }

    public TreeNode make(int i0, int i1, int N) {
        if (N == 0) return null;
        TreeNode root = new TreeNode(pre[i0]);
        if (N == 1) return root;

        int L = 1;
        for (; L < N; ++L)
            if (post[i1 + L-1] == pre[i0 + 1])
                break;

        root.left = make(i0+1, i1, L);
        root.right = make(i0+L+1, i1+L, N-1-L);
        return root;
    }
}
// @lc code=end

