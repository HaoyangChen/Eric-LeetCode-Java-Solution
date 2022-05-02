/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

 // Time Complexity: O(N) where N is the size of the linked list
 // Space Complexity: O(N) stack space utilized for recursion
// class Solution {
//     public ListNode swapPairs(ListNode head) {
//         if (head == null || head.next == null) {
//             return head;
//         }
//         // nodes to be swapped
//         ListNode firstNode = head;
//         ListNode secondNode = head.next;
//         // swapping
//         firstNode.next = swapPairs(secondNode.next);
//         secondNode.next = firstNode;
//         return secondNode;
//     }
// }

// Time Complexity: O(N), where N is the size of the linked list
// Space Complexity: O(1)
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prevNode = dummy;
        while (head != null && head.next != null) {
            ListNode firstNode = head;
            ListNode secondNode = head.next;
            
            // swapping
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // reinitialize the head and prevNode for next step
            prevNode = firstNode;
            head = firstNode.next;
        }
        return dummy.next;
    }
}
// @lc code=end