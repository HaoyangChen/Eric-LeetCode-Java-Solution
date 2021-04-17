/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 */

// @lc code=start

// Method 1: Next Array - Brute Force
// class Solution {
//     public int[] dailyTemperatures(int[] T) {
//         int[] ans = new int[T.length];
//         int[] next = new int[101];
//         Arrays.fill(next, Integer.MAX_VALUE);
//         for (int i = T.length - 1; i >= 0; --i) {
//             int warmer_index = Integer.MAX_VALUE;
//             for (int t = T[i] + 1; t <= 100; ++t) {
//                 if (next[t] < warmer_index)
//                     warmer_index = next[t];
//             }
//             if (warmer_index < Integer.MAX_VALUE)
//                 ans[i] = warmer_index - i;
//             next[T[i]] = i;
//         }
//         return ans;
//     }
// }

// Time Complexity: O(N), where N is the length of T and W is the number of allowed values for T[i]. Ech index gets pushed and popped at most once from the stack
// Space Complexity: O(W). The size of the stack is bounded as it represents strictly increasing temperature
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack();
        for (int i = T.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) stack.pop();
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }
}


// @lc code=end

