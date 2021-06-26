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
// class Solution {
//     public boolean isPalindrome(ListNode head) {
//         ListNode slow = head;
//         ListNode fast = head;
//         while (fast != null && fast.next != null) {
//             fast = fast.next.next;
//             slow = slow.next;
//         }
//         // This part is a bit tricky -- for list with even number of elements  !important
//         if (fast != null) {
//             slow = slow.next;
//         }
//         slow = reverse(slow);
//         ListNode iterator = head;
//         while (slow != null) {
//             if (iterator.val != slow.val) {
//                 return false;
//             }
//             iterator = iterator.next;
//             slow = slow.next;
//         }
//         return true;
//     }

//     private ListNode reverse(ListNode head) {
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


// Method 1: Copy into Array List and then Use Two Pointer Technique
// Time Complexity: O(n), where n is the number of nodes in the linked list
// Space Complexity: O(n)
// class Solution {
//     public boolean isPalindrome(ListNode head) {
//         List<Integer> vals = new ArrayList<>();
//         ListNode currentNode = head;
//         while (currentNode != null) {
//             vals.add(currentNode.val);
//             currentNode = currentNode.next;
//         }
//         int front = 0;
//         int back = vals.size() - 1;
//         while (front < back) {
//             if (!vals.get(front).equals(vals.get(back))) {
//                 return false;
//             }
//             front++;
//             back--;
//         }
//         return true;
//     }
// }


// Method 2: Recusive
// Time Complexity: O(n) - where n is the number of nodes in the linked list. The recursive function is run once for each of the nn nodes, and the body of the recursive function is O(1). Therefore, this gives a total of O(n).
// Space Complexity: O(n), where n is the number of nodes in the linked list.
// class Solution {
//     private ListNode frontPointer;
//     public boolean isPalindrome(ListNode head) {
//         frontPointer = head;
//         return recursivelyCheck(head);
//     }

//     private boolean recursivelyCheck(ListNode currentNode) {
//         if (currentNode != null) {
//             if (!recursivelyCheck(currentNode.next)) return false;
//             if (currentNode.val != frontPointer.val) return false;
//             frontPointer = frontPointer.next;
//         }
//         return true;
//     }
// }


// Time Complexity: O(n), where n is the number of nodes in the linked list. Finding the middle is O(n), reversing a list in place is O(n), and then comparing the 2 resulting linked list is also O(n)
// Space Complexity: O(1) we are changing the next pointers for half of the nodes. This was all memory that had already been allocated, so we are not using any extra memory and therefore it is O(1)
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // Check whether or not there is a palindrome
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) result = false;
            p1 = p1.next;
            p2 = p2.next;
        }
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;

    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}

// @lc code=end

