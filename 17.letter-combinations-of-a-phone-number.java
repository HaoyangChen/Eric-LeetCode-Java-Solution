/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start

import java.util.*;
// Shangan
// Method 1: Backtracking
// class Solution {
//     private static Map<Character, String> map = new HashMap<>();
//     static {
//         map.put('2', "abc");
//         map.put('3', "def");
//         map.put('5', "jkl");
//         map.put('4', "ghi");
//         map.put('6', "mno");
//         map.put('7', "pqrs");
//         map.put('8', "tuv");
//         map.put('9', "wxyz");
//     }
//     List<String> result;
//     public List<String> letterCombinations(String digits) {
//         result = new ArrayList<>();
//         if (digits == null || digits.isEmpty()) {
//             return result;
//         }
//         dfs(digits, 0, new StringBuilder());
//         return result;
//     }

//     private void dfs(String digits, int index, StringBuilder sb) {
//         if (index == digits.length()) {
//             result.add(sb.toString());
//             return;
//         }
//         String str = map.get(digits.charAt(index));
//         for (char c: str.toCharArray()) {
//             sb.append(c);
//             dfs(digits, index + 1, sb);
//             sb.setLength(sb.length() - 1);
//         }
//     }
// }


class Solution {
    private List<String> combinations = new ArrayList<>();
    private Map<Character, String> letters = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl", 
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    private String phoneDigits;
    
    public List<String> letterCombinations(String digits) {
        // If the input is empty, immediately return an empty answer array
        if (digits.length() == 0) {
            return combinations;
        }
        
        // Initiate backtracking with an empty path and starting index of 0
        phoneDigits = digits;
        backtrack(0, new StringBuilder());
        return combinations;
    }
    
    private void backtrack(int index, StringBuilder path) {
        // If the path is the same length as digits, we have a complete combination
        if (path.length() == phoneDigits.length()) {
            combinations.add(path.toString());
            return; // Backtrack
        }
        
        // Get the letters that the current digit maps to, and loop through them
        String possibleLetters = letters.get(phoneDigits.charAt(index));
        for (char letter: possibleLetters.toCharArray()) {
            // Add the letter to our current path
            path.append(letter);
            // Move on to the next digit
            backtrack(index + 1, path);
            // Backtrack by removing the letter before moving onto the next
            path.deleteCharAt(path.length() - 1);
        }
    }
}
// @lc code=end

