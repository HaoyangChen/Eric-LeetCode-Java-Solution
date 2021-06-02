/*
 * @lc app=leetcode id=1465 lang=java
 *
 * [1465] Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
 */

// @lc code=start

// Time complexity: O(N⋅log(N) + M⋅log(M)), Sorting an array of length n costs ⋅logn time.
// Space complexity: O(1), Regardless of the input size, we only ever need to use 2 variables: maxHeight and maxWidth.
class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int n = horizontalCuts.length;
        int m = verticalCuts.length;

        long maxHeight = Math.max(horizontalCuts[0], h - horizontalCuts[n - 1]);
        for (int i = 1; i < n; i++) {
            maxHeight = Math.max(maxHeight, horizontalCuts[i] - horizontalCuts[i - 1]);
        }

        long maxWidth = Math.max(verticalCuts[0], w - verticalCuts[m - 1]);
        for (int i = 1; i < m; i++) {
            maxWidth = Math.max(maxWidth, verticalCuts[i] - verticalCuts[i - 1]);
        }
        return (int)((maxHeight * maxWidth) % (1e9 + 7));
    }
}
// @lc code=end

