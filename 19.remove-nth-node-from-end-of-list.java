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
// class Solution {
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//         ListNode fast, slow;
//         fast = slow = head;
//         // let the fast pointer moves n steps ealier
//         while (n-- > 0) {
//             fast = fast.next;
//         }
//         if (fast == null) {
//             // if the fast pointer moves to the end, then n node is the first node
//             return head.next;
//         }
//         // let both the fast and slow pointers move at the same step
//         while (fast != null && fast.next != null) {
//             fast = fast.next;
//             slow = slow.next;
//         }
//         // slow.next is the node needs to be removed -- simply delete it
//         slow.next = slow.next.next;
//         return head;
//     }
// }


// Approach 2: Two pass algorithm
// Time Complexity: O(L) - the algorithm makes two traversals of the list, first to calculate list length L and second to find the (L - n)th node. There are 2L - n operations and time complexity is O(L)
// Space Complexity: O(1) - we only use constant extra space
// class Solution {
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//         ListNode dummy = new ListNode(0);
//         dummy.next = head;
//         int length = 0;
//         ListNode first = head;
        
//         while (first != null) {
//             length++;
//             first = first.next;
//         }
//         length -= n;
//         first = dummy;
//         while (length > 0) {
//             length--;
//             first = first.next;
//         }
//         first.next = first.next.next;
//         return dummy.next;
//     }
// }


// Approach 3: One pass algorithm
// Time Complexity: O(L) - The algorithm makes one traversal of the list of N nodes. Therefore time complexity is O(L)
// Space Complexity: O(1) - We only use constant extra space
// class Solution {
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//         ListNode dummy = new ListNode(0);
//         dummy.next = head;
//         ListNode first = dummy;
//         ListNode second = dummy;
//         for (int i = 1; i <= n + 1; i++) {
//             first = first.next;
//         }
//         while (first != null) {
//             first = first.next;
//             second = second.next;
//         }
//         second.next = second.next.next;
//         return dummy.next;
//     }
// }


// Approach 4: One pass algorithm
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode x = findNthNodeFromEnd(dummy, n + 1);
        x.next = x.next.next;
        return dummy.next;
    }
    
    private ListNode findNthNodeFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}

// @lc code=end

