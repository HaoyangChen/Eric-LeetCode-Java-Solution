/*
 * @lc app=leetcode id=142 lang=java
 *
 * [142] Linked List Cycle II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// public class Solution {
//     public ListNode detectCycle(ListNode head) {
//         ListNode fast, slow;
//         fast = slow = head;
//         while (fast != null && fast.next != null) {
//             fast = fast.next.next;
//             slow = slow.next;
//             if (fast == slow) break;
//         }
//         if (fast == null || fast.next == null) return null;
//         slow = head;
//         while (slow != fast) {
//             slow = slow.next;
//             fast = fast.next;
//         }
//         return slow;
//     }
// }

// Shangan Solution
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
// @lc code=end

