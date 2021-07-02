/*
 * @lc app=leetcode id=430 lang=java
 *
 * [430] Flatten a Multilevel Doubly Linked List
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

// Method: DFS by Recursion
// Time Complexity: O(N) where N is the number of nodes in the list. The DFS algorithm traverses each node once and only once
// Space Complexity: O(N) where N is the number of nodes int he list. In the worst case, the binary tree might be extremely unblanaced. In that case, the recursive calls would pill up, and it would take N space in the function call stack
class Solution {
    public Node flatten(Node head) {
        if (head == null) return head;
        Node pseudoHead = new Node(0, null, head, null);
        flattenDFS(pseudoHead, head);
        pseudoHead.next.prev = null;
        return pseudoHead.next;
    }

    public Node flattenDFS(Node prev, Node curr) {
        if (curr == null) return prev;
        curr.prev = prev;
        prev.next = curr;

        Node tempNext = curr.next;
        Node tail = flattenDFS(curr, curr.child);
        curr.child = null;
        return flattenDFS(tail, tempNext);
    }
}
// @lc code=end

