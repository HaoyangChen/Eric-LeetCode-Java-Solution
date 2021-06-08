/*
 * @lc app=leetcode id=1046 lang=java
 *
 * [1046] Last Stone Weight
 */

// @lc code=start

// Heap-Based Simulation
// Time Complexity: O(NlogN)
// Space complexity : O(N) or O(logN).
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone: stones) {
            heap.add(stone);
        }
        while (heap.size() > 1) {
            int stone1 = heap.poll();
            int stone2 = heap.poll();
            if (stone1 != stone2) {
                heap.add(stone1 - stone2);
            }
        }
        return heap.isEmpty() ? 0 : heap.remove();
    }
}
// @lc code=end

