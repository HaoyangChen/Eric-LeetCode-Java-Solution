/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start


// Method 1: Divide and Conquer
// Time Limit Exceeded
// Time Complexity: Average case - O(nlogn), Worst case - O(n^2) if the numbers in the array are sorted
// Space Complexity: O(n) - recursion with worst case depth n 
// class Solution {
//     public int calculateArea(int[] heights, int start, int end) {
//         if (start > end)
//             return 0;
//         int minindex = start;
//         for (int i = start; i <= end; i++)
//             if (heights[minindex] > heights[i])
//                 minindex = i;
//         return Math.max(heights[minindex] * (end - start + 1),
//                         Math.max(calculateArea(heights, start, minindex - 1),
//                                 calculateArea(heights, minindex + 1, end))
//                 );
//     }

//     private int largestRectangleArea(int[] heights) {
//         return calculateArea(heights, 0, heights.length - 1);
//     }
// }



// Method 2: Using Stack
// Time Complexity: O(n) - n numbers are pushed and popped
// Space Complexity: O(n) stack is used
public class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int length = heights.length;
        int maxArea = 0;
        for (int i = 0; i < length; i++) {
            while ((stack.peek() != -1)
                    && (heights[stack.peek()] >= heights[i])) {
                int currentHeight = heights[stack.pop()];
                int currentWidth = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, currentHeight * currentWidth);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int currentHeight = heights[stack.pop()];
            int currentWidth = length - stack.peek() - 1;
            maxArea = Math.max(maxArea, currentHeight * currentWidth);
        }
        return maxArea;
    }
}
// @lc code=end

