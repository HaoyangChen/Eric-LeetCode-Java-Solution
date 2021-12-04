/*
 * @lc app=leetcode id=680 lang=java
 *
 * [680] Valid Palindrome II
 */

// @lc code=start

// Greedy Algorithm
// Time Complexity: O(n)
// Space Complexity: O(1)
// class Solution { 
//     public boolean validPalindrome(String s) {
//         int low = 0, high = s.length() - 1;
//         while (low < high) {
//             char c1 = s.charAt(low), c2 = s.charAt(high);
//             if (c1 == c2) {
//                 ++low;
//                 --high;
//             } else {
//                 return validPalindrome(s, low, high - 1) || validPalindrome(s, low + 1, high);
//             }
//         }
//         return true;
//     }

//     private boolean validPalindrome(String s, int low, int high) {
//         for (int i = low, j = high; i < j; ++i, --j) {
//             char c1 = s.charAt(i), c2 = s.charAt(j);
//             if (c1 != c2) {
//                 return false;
//             }
//         }
//         return true;
//     }
// }


// Time Complexity: O(n) where n is the length of the given string. To check if the entire string is a palindrome will take O(n) time and checking if the substring is a palindrom also tkees O(n) time.
// Space Complexity: O(1) because constant space is used
class Solution {
    public boolean validPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while (low < high) {
            char charLow = s.charAt(low), charHigh = s.charAt(high);
            if (charLow == charHigh) {
                ++low;
                --high;
            } else {
                return validPalindrome(s, low, high - 1) || validPalindrome(s, low + 1, high);
            }
        }
        return true;
    }
    
    public boolean validPalindrome(String s, int low, int high) {
        for (int i = low, j = high; i < j; ++i, --j) {
            char charLow = s.charAt(i), charHigh = s.charAt(j);
            if (charLow != charHigh) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

