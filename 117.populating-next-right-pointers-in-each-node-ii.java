/*
 * @lc app=leetcode id=117 lang=java
 *
 * [117] Populating Next Right Pointers in Each Node II
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

// Method 1: Level Order Traversal
// Time Complexity: O(N) since we traverse each node exactly once
// Space Complexity: O(N) This is a perfect binary tree which means that the last level contains N/2 nodes. The space complexity for breadth first traversal is the space occupied by the queue which is dependent upon the maximum number of nodes in particular level. 
// class Solution {
//     public Node connect(Node root) {
//         if (root == null) return root;
//         Queue<Node> queue = new LinkedList<Node>();
//         queue.add(root);
        
//         while (!queue.isEmpty()) {
//             int size = queue.size();
            
//             for (int i = 0; i < size; i++) {
//                 Node node = queue.poll();
//                 if (i < size - 1) {
//                     node.next = queue.peek();
//                 }
//                 if (node.left != null) queue.add(node.left);
//                 if (node.right != null) queue.add(node.right);
//             }
//         }
//         return root;
//     }
// }



// Method 2: Using previously established next pointers
// Time Complexity: O(N) since we process each node exactly once
// Space Complexity: O(1) since we don't make use of any additional data structure for traversing nodes on a particular level like the previous approach does
class Solution {
    Node prev, leftmost;

    public void processChild(Node childNode) {
        if (childNode != null) {
            if (this.prev != null) {
                this.prev.next = childNode;
            } else {
                this.leftmost = childNode;
            }
            this.prev = childNode;
        }
    }

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        this.leftmost = root;
        Node curr = leftmost;
        while (this.leftmost != null) {
            this.prev = null;
            curr = this.leftmost;
            this.leftmost = null;

            while (curr != null) {
                this.processChild(curr.left);
                this.processChild(curr.right);
                curr = curr.next;
            }
        }
        return root;
    }
}
// @lc code=end

