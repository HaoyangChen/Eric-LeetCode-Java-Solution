/*
 * @lc app=leetcode id=116 lang=java
 *
 * [116] Populating Next Right Pointers in Each Node
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

// class Solution {
//     public Node connect(Node root) {
//         if (root == null) return null;
//         connectTwoNode(root.left, root.right);
//         return root;
//     }

//     private void connectTwoNode(Node node1, Node node2) {
//         if (node1 == null || node2 == null) {
//             return;
//         }
//         node1.next = node2;
//         connectTwoNode(node1.left, node1.right);
//         connectTwoNode(node2.left, node2.right);
//         connectTwoNode(node1.right, node2.left);
//     }
// }

// Time Complexity: O(N) since we traverse each node exactly once
// Space Complexity: O(N) This is a perfect binary tree which means that the last level contains N/2 nodes. The space complexity for breadth first traversal is the space occupied by the queue which is dependent upon the maximum number of nodes in particular level. 
class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i < size - 1) {
                    node.next = queue.peek();
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return root;
    }
}
// @lc code=end

