/*
 * @lc app=leetcode id=109 lang=java
 *
 * [109] Convert Sorted List to Binary Search Tree
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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 // Method 1: Recursion
 // Time Complexity: O(NlogN) 
 // Space Complexity: O(logN) since we are resorting to recursion. The height of the tree is bounded by O(logN) since the question states that we need to maintain the height balance property
// class Solution {
//     public TreeNode sortedListToBST(ListNode head) {
//         if (head == null) return null;
//         ListNode mid = this.findMiddleElement(head);
//         TreeNode node = new TreeNode(mid.val);
//         if (head == mid) return node;
//         node.left = this.sortedListToBST(head);
//         node.right = this.sortedListToBST(mid.next);
//         return node;
//     }

//     private ListNode findMiddleElement(ListNode head) {
//         ListNode prevPointer = null;
//         ListNode slowPointer = head;
//         ListNode fastPointer = head;
//         while (fastPointer != null && fastPointer.next != null) {
//             prevPointer = slowPointer;
//             slowPointer = slowPointer.next;
//             fastPointer = fastPointer.next.next;
//         }
//         if (prevPointer != null) {
//             prevPointer.next = null;
//         }
//         return slowPointer;
//     }
// }


// Method 2: Recursion + Conversion to Array
// Time Complexity: O(N) time complexity is O(N) since we convert the linked list to an array initially and then convert the array into a BST. Accessing the middle element now takes O(1) and thus the time complexity comes down
// Space Complexity: O(N) Since we used extra space to bring down the time complexity, the space complexity now goes up to O(N) as opposed of O(logN) because of the array we construct initially
// class Solution {
//     private List<Integer> values;

//     public Solution() {
//       this.values = new ArrayList<Integer>();
//     }
  
//     private void mapListToValues(ListNode head) {
//       while (head != null) {
//         this.values.add(head.val);
//         head = head.next;
//       }
//     }
  
//     private TreeNode convertListToBST(int left, int right) {
//       // Invalid case
//       if (left > right) {
//         return null;
//       }
  
//       // Middle element forms the root.
//       int mid = (left + right) / 2;
//       TreeNode node = new TreeNode(this.values.get(mid));
  
//       // Base case for when there is only one element left in the array
//       if (left == right) {
//         return node;
//       }
  
//       // Recursively form BST on the two halves
//       node.left = convertListToBST(left, mid - 1);
//       node.right = convertListToBST(mid + 1, right);
//       return node;
//     }
  
//     public TreeNode sortedListToBST(ListNode head) {
  
//       // Form an array out of the given linked list and then
//       // use the array to form the BST.
//       this.mapListToValues(head);
  
//       // Convert the array to
//       return convertListToBST(0, this.values.size() - 1);
//     }
//   }


// Inorder Simulation
// Time Complexity: The time complexity is still O(N) since we still have to process each of the nodes in the linked list once and form corresponding BST nodes.
// Space Complexity: O(logN) since now the only extra space is used by the recursion stack and since we are building a height balanced BST, the height is bounded by logN.
class Solution {
    private ListNode head;
  
    private int findSize(ListNode head) {
      ListNode ptr = head;
      int c = 0;
      while (ptr != null) {
        ptr = ptr.next;  
        c += 1;
      }
      return c;
    }
  
    private TreeNode convertListToBST(int l, int r) {
      // Invalid case
      if (l > r) {
        return null;
      }
  
      int mid = (l + r) / 2;
  
      // First step of simulated inorder traversal. Recursively form
      // the left half
      TreeNode left = this.convertListToBST(l, mid - 1);
  
      // Once left half is traversed, process the current node
      TreeNode node = new TreeNode(this.head.val);
      node.left = left;
  
      // Maintain the invariance mentioned in the algorithm
      this.head = this.head.next;
  
      // Recurse on the right hand side and form BST out of them
      node.right = this.convertListToBST(mid + 1, r);
      return node;
    }
  
    public TreeNode sortedListToBST(ListNode head) {
      // Get the size of the linked list first
      int size = this.findSize(head);
  
      this.head = head;
  
      // Form the BST now that we know the size
      return convertListToBST(0, size - 1);
    }
  }
// @lc code=end

