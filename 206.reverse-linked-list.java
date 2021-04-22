/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
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
// class Solution {
//     public ListNode reverseList(ListNode head) {
//         ListNode oriNext = null;
//         ListNode next = null;

//         while (head != null) {
//             oriNext = head.next;
//             head.next = next;
//             next = head;
//             head = oriNext;
//         }
//         return next;
//     }
// }

// Recursive Approach
// Time Complexity: O(n). Assume that n is the list's length, the time complexity is O(n)
// Space Complexity: O(n). The extra space comes from the implicit stack space due to recursion. The recursion can go up to n levels deep.
public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode p = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return p;
}

// @lc code=end

