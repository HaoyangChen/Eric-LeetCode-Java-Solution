/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 */

// @lc code=start
// class Solution {
//     public String decodeString(String s) {
//         Stack<Character> stack = new Stack<>();
//         for (int i = 0; i < s.length(); i++) {
//             if (s.charAt(i) == ']') {
//                 List<Character> decodedString = new ArrayList<>();
//                 while (stack.peek() != '[') {
//                     decodedString.add(stack.pop());
//                 }
//                 stack.pop();
//                 int base = 1;
//                 int k = 0;

//                 while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
//                     k = k + (stack.pop() - '0') * base;
//                     base *= 10;
//                 }

//                 while (k != 0) {
//                     for (int j = decodedString.size() - 1; j >= 0; j--) {
//                         stack.push(decodedString.get(j));
//                     }
//                     k--;
//                 }
//             } else {
//                 stack.push(s.charAt(i));
//             }
//         }
//         char[] result = new char[stack.size()];
//         for (int i = result.length - 1; i >= 0; i--) {
//             result[i] = stack.pop();
//         }
//         return new String(result);
//     }
// }


// Method 2: Using Two Stacks
class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack= new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;
        for (char ch: s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if (ch == '[') {
                countStack.push(k);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder decodeString = stringStack.pop();
                for (int currentK = countStack.pop(); currentK > 0; currentK--) {
                    decodeString.append(currentString);
                }
                currentString = decodeString;
            } else {
                currentString.append(ch);
            }
        }
        return currentString.toString();
    }
}
// @lc code=end

