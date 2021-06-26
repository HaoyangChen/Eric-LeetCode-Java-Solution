/*
 * @lc app=leetcode id=328 lang=java
 *
 * [328] Odd Even Linked List
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
// class Solution {
//     public ListNode oddEvenList(ListNode head) {
//         ListNode oddDummy = new ListNode(-1);
//         ListNode evenDummy = new ListNode(-1);
//         ListNode oddIterator = oddDummy;
//         ListNode evenIterator = evenDummy;
//         while (head != null) {
//             oddIterator.next = head;
//             oddIterator = oddIterator.next;
//             head = head.next;
//             if (head == null) {
//                 break;
//             }
//             evenIterator.next = head;
//             evenIterator = evenIterator.next;
//             head = head.next;
//         }
//         oddIterator.next = evenDummy.next;
//         evenIterator.next = null;
//         return oddDummy.next;
//     }
// }

// Time Complexity: O(n) - there are total n nodes and we viist each node once
// Space Complexity: O(1) - all we need is the four pointers
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}


// @lc code=end

