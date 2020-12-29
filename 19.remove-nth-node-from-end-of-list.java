/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast, slow;
        fast = slow = head;
        // let the fast pointer moves n steps ealier
        while (n-- > 0) {
            fast = fast.next;
        }
        if (fast == null) {
            // if the fast pointer moves to the end, then n node is the first node
            return head.next;
        }
        // let both the fast and slow pointers move at the same step
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // slow.next is the node needs to be removed -- simply delete it
        slow.next = slow.next.next;
        return head;
    }
}
// @lc code=end

