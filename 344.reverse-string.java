/*
 * @lc app=leetcode id=344 lang=java
 *
 * [344] Reverse String
 */

// @lc code=start

// Approach 1: Recursion, In-Place, O(N) Space
// Time Compelxity: O(N) time to perform N/2 swaps
// Space Complexity: O(N) to keep the recursion stack
// class Solution {
//     public void reverseString(char[] s) {
//         helper(s, 0, s.length - 1);
//     }

//     public void helper(char[] s, int left, int right) {
//         if (left >= right) return;
//         char tmp = s[left];
//         s[left++] = s[right];
//         s[right--] = tmp;
//         helper(s, left, right);
//     }
// }

// Approach 2: two pointers, iteration, O(1) space
// Time Complexity: O(N) to swap N/2 elements
// Space Complexity: O(1) it is a constant space solution
class Solution {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
}
// @lc code=end

