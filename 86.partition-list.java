/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
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

 // Time Complexity: O(N) where N is the size of the original linked list
 // Space Complexity: O(1) because no extra space is used as the algorithm only modifies/reararnges the nodes
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallDummy = new ListNode(-1);
        ListNode largeDummy = new ListNode(-1);
        ListNode smallIterator = smallDummy;
        ListNode largeIterator = largeDummy;

        while (head != null) {
            if (head.val < x) {
                smallIterator.next = head;
                smallIterator = smallIterator.next;
            } else {
                largeIterator.next = head;
                largeIterator = largeIterator.next;
            }
            head = head.next;
        }
        largeIterator.next = null;
        smallIterator.next = largeDummy.next;
        return smallDummy.next;
    }
}
// @lc code=end

