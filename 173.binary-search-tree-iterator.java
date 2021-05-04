/*
 * @lc app=leetcode id=173 lang=java
 *
 * [173] Binary Search Tree Iterator
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

 // Method 1: Flattening the BST
 // Time Complexity: O(N) is the time taken by the constructor for the iterator
 // Space Complexity: O(N) since we create a new array to contain all the nodes of the BST
// class BSTIterator {
//     ArrayList<Integer> nodesSorted;
//     int index;
//     public BSTIterator(TreeNode root) {
//         this.nodesSorted = new ArrayList<Integer>();
//         this.index = -1;
//         this._inorder(root);
//     }

//     private void _inorder(TreeNode root) {
//         if (root == null) {
//             return;
//         }
//         this._inorder(root.left);
//         this.nodesSorted.add(root.val);
//         this._inorder(root.right);
//     }
    
//     public int next() {
//         return this.nodesSorted.get(++this.index);
//     }
    
//     public boolean hasNext() {
//         return this.index + 1 < this.nodesSorted.size();
//     }
// }

// Method 2: Controlled Recursion
// Time Complexity:  amortized (average) time complexity for this function would be O(1)
// Space Complexity: O(N) where N is the number of nodes in the tree, which is occupied by custom stack for simulating the inorder traversal
class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        this.stack = new Stack<TreeNode>();
        this._leftMostInoder(root);
    }

    private void _leftMostInoder(TreeNode root) {
        while (root != null) {
            this.stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode topMostNode = this.stack.pop();
        if (topMostNode != null) {
            this._leftMostInoder(topMostNode.right);
        }
        return topMostNode.val;
    }

    public boolean hasNext() {
        return this.stack.size() > 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end

