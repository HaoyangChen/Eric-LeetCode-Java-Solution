/*
 * @lc app=leetcode id=1046 lang=java
 *
 * [1046] Last Stone Weight
 */

// @lc code=start

// Approach 1: Heap-Based Simulation
// Time Complexity: O(NlogN)
// Space complexity : O(N) or O(logN).

// class Solution {
//     public int lastStoneWeight(int[] stones) {
//         PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
//         for (int stone: stones) {
//             heap.add(stone);
//         }
//         while (heap.size() > 1) {
//             int stone1 = heap.poll();
//             int stone2 = heap.poll();
//             if (stone1 != stone2) {
//                 heap.add(stone1 - stone2);
//             }
//         }
//         return heap.isEmpty() ? 0 : heap.remove();
//     }
// }


// Approach 2: Bucket Sort
// Time complexity: O(N+W)
// Space complexity: O(W).
class Solution {
    public int lastStoneWeight(int[] stones) {
        
        // Set up the bucket array.
        int maxWeight = stones[0];
        for (int stone: stones) {
            maxWeight = Math.max(maxWeight, stone);
        }
        int[] buckets = new int[maxWeight + 1];

        // Bucket sort.
        for (int weight : stones) {
            buckets[weight]++;
        }

        // Scan through the buckets.
        int biggestWeight = 0;
        int currentWeight = maxWeight;
        while (currentWeight > 0) {
            if (buckets[currentWeight] == 0) {
                currentWeight--;
            } else if (biggestWeight == 0) {
                buckets[currentWeight] %= 2;
                if (buckets[currentWeight] == 1) {
                    biggestWeight = currentWeight;
                }
                currentWeight--;
            } else {
                buckets[currentWeight]--;
                if (biggestWeight - currentWeight <= currentWeight) {
                    buckets[biggestWeight - currentWeight]++;
                    biggestWeight = 0;
                } else {
                    biggestWeight -= currentWeight;
                }
            }
        }
        return biggestWeight;
    }
}
// @lc code=end

