/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
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
//     private ListNode successor = null;
//     public ListNode reverseBetween(ListNode head, int m, int n) {
//         if (m == 1) {
//             return reverseN(head, n);
//         }
//         // 前进到反转的起点触发 base case
//         head.next = reverseBetween(head.next, m - 1, n - 1);
//         return head;
//     }

//     ListNode reverseN(ListNode head, int n) {
//         if (n == 1) { 
//             // 记录第 n + 1 个节点
//             successor = head.next;
//             return head;
//         }
//         // 以 head.next 为起点，需要反转前 n - 1 个节点
//         ListNode last = reverseN(head.next, n - 1);
    
//         head.next.next = head;
//         // 让反转之后的 head 节点和后面的节点连起来
//         head.next = successor;
//         return last;
//     }
// }

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode previousM = dummy;

        int i = 1;
        while (i < m && head != null) {
            previousM = head;
            head = head.next;
            i++;
        }

        ListNode actualNext;
        ListNode previous = null;
        while (i <= n && head != null) {
            actualNext = head.next;
            head.next = previous;
            previous = head;
            head = actualNext;
            i++;
        }
        previousM.next.next = head; // why?
        previousM.next = previous;
        return dummy.next;
    }
}

// @lc code=end

