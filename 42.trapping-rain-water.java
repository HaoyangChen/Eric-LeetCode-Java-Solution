/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start

// Using Monotonous Stack
// Time Complexity: O(n) single iteration of O(n) in which bar can be touched at most twice(due to insertion and deletion from stack) and insertion and deletion from stack takes O(1)
// Space Complexity: O(n) stack can take up to O(n) space in case of stairs-like or flat structure
// class Solution {
//     public int trap(int[] height) {
//         int ans = 0;
//         Deque<Integer> stack = new LinkedList<Integer>();
//         int n = height.length;
//         for (int i = 0; i < n; i++) {
//             while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
//                 int top = stack.pop();
//                 if (stack.isEmpty()) break;
//                 int left = stack.peek();
//                 int currentWidth = i - left - 1;
//                 int currentHeight = Math.min(height[left], height[i]) - height[top];
//                 ans += currentWidth * currentHeight;
//             }
//             stack.push(i);
//         }
//         return ans;
//     }
// }


// Method2: Using 2 Pointers
// Time Complexity: O(n) single iteration of O(n)
// Space Complexity: O(1) extra space. Only constant space required for left, right, leftMax, and rightMax
class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                left++;
            } else {
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }
}
// @lc code=end

