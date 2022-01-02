/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
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
// public ListNode mergeKLists(ListNode[] lists) {
//     List<Integer> l = new ArrayList<Integer>();
   
//     for (ListNode ln : lists) {
//         while (ln != null) {
//             l.add(ln.val);
//             ln = ln.next;
//         }
//     }
   
//     Collections.sort(l);
 
//     ListNode head = new ListNode(0);
//     ListNode h = head;
//     for (int i : l) {
//         ListNode t = new ListNode(i);
//         h.next = t;
//         h = h.next;
//     }
//     h.next = null;
//     return head.next;
// }


// Method: Priority Queue
// Time Complexity: O(NlogK) where k is the number of linked lists
// Space Complexity: o(n) creating a new linked list costs O(n) space
class Solution {
    class Status implements Comparable<Status> {
        int val;
        ListNode pointer;
        
        Status(int val, ListNode pointer) {
            this.val = val;
            this.pointer = pointer;
        }
        
        public int compareTo(Status status2) {
            return this.val - status2.val;
        }
    }
    
    PriorityQueue<Status> queue = new PriorityQueue<>();
    
    public ListNode mergeKLists(ListNode[] lists) {
        for (ListNode node: lists) {
            if (node != null) {
                queue.offer(new Status(node.val, node));
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!queue.isEmpty()) {
            Status f = queue.poll();
            tail.next = f.pointer;
            tail = tail.next;
            if (f.pointer.next != null) {
                queue.offer(new Status(f.pointer.next.val, f.pointer.next));
            }
        }
        return head.next;
    }
}
// @lc code=end

