/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
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

 // Shangan Solution
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // This part is a bit tricky -- for list with even number of elements  !important
        if (fast != null) {
            slow = slow.next;
        }
        slow = reverse(slow);
        ListNode iterator = head;
        while (slow != null) {
            if (iterator.val != slow.val) {
                return false;
            }
            iterator = iterator.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode oriNext = null;
        ListNode next = null;

        while (head != null) {
            oriNext = head.next;
            head.next = next;
            next = head;
            head = oriNext;
        }
        return next;
    }
}
// @lc code=end

