/*
 * @lc app=leetcode id=528 lang=java
 *
 * [528] Random Pick with Weight
 */

// @lc code=start

// Method: Binary Search
// Time Complexity: O(N) - the construction of the prefix sums will take O(N) time and the pickIndex() function has a O(logN) time complexity since we did a binary search on the prefix sums.
// Space Complexity: O(N) - the construction of the prefix sums takes O(N) space and the space complexity of the pickIndex() function is O(1) since constant memory is used.
class Solution {
    private int[] prefixSums;
    private int totalSum;
    
    public Solution(int[] w) {
        this.prefixSums = new int[w.length];
        int prefixSum = 0;
        for (int i = 0; i < w.length; i++) {
            prefixSum += w[i];
            this.prefixSums[i] = prefixSum;
        }
        this.totalSum = prefixSum;
    }
    
    public int pickIndex() {
        double target = Math.random() * this.totalSum;
        int low = 0, high = this.prefixSums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (target > this.prefixSums[mid])
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
// @lc code=end

