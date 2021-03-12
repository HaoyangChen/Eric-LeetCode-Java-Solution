/*
 * @lc app=leetcode id=264 lang=java
 *
 * [264] Ugly Number II
 */

// @lc code=start

// Method 1: Heap
// Time complexity: O(1) to retrieve preliminary computed ugly number
// Space complexity: constant space to keep an array of 1690 ugly numbers, the heap of not more than 1690 \times 21690×2 elements and the hashset of not more than 1690×3 elements.
class Solution {
    public static Ugly u = new Ugly();
    public int nthUglyNumber(int n) {
        return u.nums[n - 1];
    }
}

class Ugly {
    public int[] nums = new int[1690];
    Ugly() {
        HashSet<Long> seen = new HashSet();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        seen.add(1L);
        heap.add(1L);
        
        long currUgly, newUgly;
        int[] primes = new int[]{2, 3, 5};
        for (int i = 0; i < 1690; i++) {
            currUgly = heap.poll();
            nums[i] = (int) currUgly;
            for (int j: primes) {
                newUgly = currUgly * j;
                if (!seen.contains(newUgly)) {
                    seen.add(newUgly);
                    heap.add(newUgly);
                }
            }
        }
    }
}
// @lc code=end

