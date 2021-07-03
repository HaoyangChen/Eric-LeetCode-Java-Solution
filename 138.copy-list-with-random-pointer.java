/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

// 
// class Solution {
//     // Visited dictionary to hold old node reference as "key" and new node reference as "value"
//     HashMap<Node, Node> visited = new HashMap<Node, Node>();

//     private Node getClonedNode(Node node) {
//         // if the node exists then
//         if (node != null) {
//             // check if the node is in the visited dictionary
//             if (this.visited.containsKey(node)) {
//                 // if it is in the visited dictionary, then return the new node reference from the dictionary
//                 return this.visited.get(node);
//             } else {
//                 // otherwise create a new node, add to the dictionary and return it
//                 this.visited.put(node, new Node(node.val, null, null));
//                 return this.visited.get(node);
//             }
//         }
//         return null;
//     }

//     public Node copyRandomList(Node head) {
//         if (head == null) {
//             return null;
//         }
//         Node oldNode = head;

//         // creating the new head node
//         Node newNode = new Node(oldNode.val);
//         this.visited.put(oldNode, newNode);

//         while (oldNode != null) {
//             // get the clones of the node referenced by random and next pointers
//             newNode.random = this.getClonedNode(oldNode.random);
//             newNode.next = this.getClonedNode(oldNode.next);

//             // move one step ahead in the linked list
//             oldNode = oldNode.next;
//             newNode = newNode.next;
//         }
//         return this.visited.get(head);
//     }
// }



// Method 1: Recursive Aprroach
// Time Complexity: O(N) where N is the number of nodes in the linked list
// Space Complexity: O(N). If we look closely, we have the recursion stack and we also have the space complexity to keep track of nodes already cloned using the visited dictionary. 
// class Solution {
//     HashMap<Node, Node> visitedHash = new HashMap<Node, Node>();

//     public Node copyRandomList(Node head) {
//         if (head == null) return null;
//         if (this.visitedHash.containsKey(head)) return this.visitedHash.get(head);
//         Node node = new Node(head.val, null, null);
//         this.visitedHash.put(head, node);
//         node.next = copyRandomList(head.next);
//         node.random = copyRandomList(head.random);
//         return node; 
//     }
// }

// Method 2: Iterative Apprach with O(N) Space
// Time Complexity: O(N) because we make one pass over the original linked list
// Space Complexity: O(N) as we have a dictionary containing mapping from old list nodes to new list nodes. Since there are N nodes, we have O(N) space complexity
class Solution {
    HashMap<Node, Node> visited = new HashMap<Node, Node>();
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node oldNode = head;
        Node newNode = new Node(oldNode.val);
        this.visited.put(oldNode, newNode);

        while (oldNode != null) {
            newNode.random = this.getClonedNode(oldNode.random);
            newNode.next = this.getClonedNode(oldNode.next);

            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return this.visited.get(head);
    }

    public Node getClonedNode(Node node) {
        if (node != null) {
            if (this.visited.containsKey(node)) {
                return this.visited.get(node);
            } else {
                this.visited.put(node, new Node(node.val, null, null));
                return this.visited.get(node);
            }
        }
        return null;
    }
}
// @lc code=end

