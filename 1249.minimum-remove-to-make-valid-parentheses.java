/*
 * @lc app=leetcode id=1249 lang=java
 *
 * [1249] Minimum Remove to Make Valid Parentheses
 */

// @lc code=start

// Method 1: Using a Stack and String Builder
// Time Complexity: O(n), where n is the length of the input string
// Space Complexity: O(n), we are using a stack, set, and string builder. Each of which could have up to n characters in them, and so requires up to O(n)
// class Solution {
//     public String minRemoveToMakeValid(String s) {
//         Set<Integer> indexesToRemove = new HashSet<>();
//         Deque<Integer> stack = new ArrayDeque<>();
//         for (int i = 0; i < s.length(); i++) {
//             if (s.charAt(i) == '(') {
//                 stack.push(i);
//             }
//             if (s.charAt(i) == ')') {
//                 if (stack.isEmpty()) {
//                     indexesToRemove.add(i);
//                 } else {
//                     stack.pop();
//                 }
//             }
//         }

//         while (!stack.isEmpty()) {
//             indexesToRemove.add(stack.pop());
//         }
//         StringBuilder sb = new StringBuilder();
//         for (int i = 0; i < s.length(); i++) {
//             if (!indexesToRemove.contains(i)) {
//                 sb.append(s.charAt(i));
//             }
//         }
//         return sb.toString();
//     }
// }


// Method 2: Two Pass String Builder

// class Solution {

//     private StringBuilder removeInvalidClosing(CharSequence string, char open, char close) {
//         StringBuilder sb = new StringBuilder();
//         int balance = 0;
//         for (int i = 0; i < string.length(); i++) {
//             char c = string.charAt(i);
//             if (c == open) {
//                 balance++;
//             } if (c == close) {
//                 if (balance == 0) continue;
//                 balance--;
//             }
//             sb.append(c);
//         }  
//         return sb;
//     }

//     public String minRemoveToMakeValid(String s) {
//         StringBuilder result = removeInvalidClosing(s, '(', ')');
//         result = removeInvalidClosing(result.reverse(), ')', '(');
//         return result.reverse().toString();
//     }
// }


// Method 3: Shortened Two Pass String Builder
class Solution {

    public String minRemoveToMakeValid(String s) {

        // Pass 1: Remove all invalid ")"
        StringBuilder sb = new StringBuilder();
        int openSeen = 0;
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                openSeen++;
                balance++;
            } if (c == ')') {
                if (balance == 0) continue;
                balance--;
            }
            sb.append(c);
        }

        // Pass 2: Remove the rightmost "("
        StringBuilder result = new StringBuilder();
        int openToKeep = openSeen - balance;
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') {
                openToKeep--;
                if (openToKeep < 0) continue;
            }
            result.append(c);
        }

        return result.toString();
    }
}
// @lc code=end

