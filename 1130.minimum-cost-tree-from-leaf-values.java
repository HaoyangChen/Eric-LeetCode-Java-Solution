/*
 * @lc app=leetcode id=1130 lang=java
 *
 * [1130] Minimum Cost Tree From Leaf Values
 */

// @lc code=start

// Method: Monotonic Stack
class Solution {
    public int mctFromLeafValues(int[] arr) {
        Stack<Integer> stack = new Stack();
        stack.push(Integer.MAX_VALUE);
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] >= stack.peek()) {
                result += stack.pop() * Math.min(stack.peek(), arr[i]);
            }
            stack.push(arr[i]);
        }
        while(stack.size() > 2) {
            result += stack.pop() * stack.peek();
        }
        return result;
    }
}
// @lc code=end

