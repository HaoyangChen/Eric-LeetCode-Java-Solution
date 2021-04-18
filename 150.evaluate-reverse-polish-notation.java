/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */

// @lc code=start

// Method 1: Reducing the List In-place
// Time Complexity: O(n^2)
// Space Complexity: O(1) - The only extra space used is a constant number of single-value variables. Therefore, the overall algorithm requires O(1) space.
// class Solution {
//     public int evalRPN(String[] tokens) {
//         int currentPosition = 0;
//         int length = tokens.length;
//         while (length > 1) {
//             while (!"+-*/".contains(tokens[currentPosition])) {
//                 currentPosition++;
//             }
//             int number1 = Integer.parseInt(tokens[currentPosition - 2]);
//             int number2 = Integer.parseInt(tokens[currentPosition - 1]);
//             int newValue = 0;
//             switch(tokens[currentPosition]) {
//                 case "+":
//                     newValue = number1 + number2;
//                     break;
//                 case "-":
//                     newValue = number1 - number2;
//                     break;
//                 case "*":
//                     newValue = number1 * number2;
//                     break;
//                 case "/":
//                     newValue = number1 / number2;
//                     break;
//             }
//             tokens[currentPosition] = Integer.toString(newValue);
//             delete2AtIndex(tokens, currentPosition - 2, length);
//             currentPosition--;
//             length -= 2;
//         }
//         return Integer.parseInt(tokens[0]);
//     }

//     private void delete2AtIndex(String[] tokens, int d, int length) {
//         for (int i = d; i < length - 2; i++) {
//             tokens[i] = tokens[i + 2];
//         }
//     }
// }


// Method 2: Evaluate with Stack
// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token: tokens) {
            if (!"+-*/".contains(token)) {
                stack.push(Integer.valueOf(token));
                continue;
            }
            int number2 = stack.pop();
            int number1 = stack.pop();
            int result = 0;
            switch (token) {
                case "+":
                    result = number1 + number2;
                    break;
                case "-":
                    result = number1 - number2;
                    break;
                case "*":
                    result = number1 * number2;
                    break;
                case "/":
                    result = number1 / number2;
                    break;
            }
            stack.push(result);
        }
        return stack.pop();
    }
}
// @lc code=end

