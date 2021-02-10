/*
 * @lc app=leetcode id=160 lang=java
 *
 * [160] Intersection of Two Linked Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 // shangan solution
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode iteratorA = headA;
        ListNode iteratorB = headB;
        while (iteratorA != iteratorB) {
            iteratorA = iteratorA == null ? headB : iteratorA.next;
            iteratorB = iteratorB == null ? headA : iteratorB.next;
        }
        return iteratorA;
    }
}
// @lc code=end

