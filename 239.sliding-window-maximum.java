/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start

// Method: Deque
// Time complexity: O(N), since each element is processed exactly twice - it's index added and then removed from the deque.
// Space Complexity: O(N), since O(n - k + 1) is used for an output array and O(k) for a queue
class Solution {
    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    int[] nums;

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        // init deque and output
        this.nums = nums;
        int maxIndex = 0;
        for (int i = 0; i < k; i++) {
            cleanDeque(i, k);
            deq.addLast(i);
            if (nums[i] > nums[maxIndex]) maxIndex = i;
        }

        int[] output = new int[n - k + 1];
        output[0] = nums[maxIndex];

        // build output 
        for (int i = k; i < n; i++) {
            cleanDeque(i, k);
            deq.addLast(i);
            output[i - k + 1] = nums[deq.getFirst()];
        }
        return output;
    }

    public void cleanDeque(int i, int k) {
        if (!deq.isEmpty() && deq.getFirst() == i - k) {
            deq.removeFirst();
        }
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]) deq.removeLast();
    }
}
// @lc code=end

