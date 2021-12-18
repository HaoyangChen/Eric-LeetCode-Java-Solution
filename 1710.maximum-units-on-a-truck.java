/*
 * @lc app=leetcode id=1710 lang=java
 *
 * [1710] Maximum Units on a Truck
 */

// @lc code=start

// Time Complexity: O(nlogn) where n is the number of elements in array boxTypes. Removing elements from the queue would take (logn) time and this would give the time complexity of O(nlogn)  + O(n) = O(nlogn)
// Space Complexity: O(n) since we use a queue of size n.
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        queue.addAll(Arrays.asList(boxTypes));
        int unitCount = 0;
        while (!queue.isEmpty()) {
            int[] topElement = queue.poll();
            int boxCount = Math.min(truckSize, topElement[0]);
            unitCount += boxCount * topElement[1];
            truckSize -= boxCount;
            if (truckSize == 0) break;
        }
        return unitCount;
    }
}
// @lc code=end

