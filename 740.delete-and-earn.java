/*
 * @lc app=leetcode id=740 lang=java
 *
 * [740] Delete and Earn
 */

// @lc code=start
import java.util.*;
// class Solution {
//     private HashMap<Integer, Integer> points = new HashMap<>();
//     private HashMap<Integer, Integer> cache = new HashMap<>();
    
//     public int deleteAndEarn(int[] nums) {
//         int maxNumber = 0;
//         for (int num: nums) {
//             points.put(num, points.getOrDefault(num, 0) + num);
//             maxNumber = Math.max(maxNumber, num);
//         }
//         return maxPoints(maxNumber);
//     }
    
//     private int maxPoints(int num) {
//         if (num == 0) return 0;
//         if (num == 1) return points.getOrDefault(1, 0);
//         if (cache.containsKey(num)) return cache.get(num);
//         int gain = points.getOrDefault(num, 0);
//         cache.put(num, Math.max(maxPoints(num - 1), maxPoints(num - 2) + gain));
//         return cache.get(num);
//     }
// }

// Method 2: Dynamic Programming
// Time Complexity: O(N + k) where N is the length of nums and k is the maximum elements in nums
//                  Since we need to iterate through nums once, which costs O(N) time and then populate maxPoints of length k + 1, which costs O(k) time
// Space Complexity: O(N + k) the extra space used is the hash table points and dp array maxPoints. The size of maxPoints is k + 1 and the size of the hash table
//                   is equal to the number of unique elements in nums, which in the worst case can all be unique and take O(N) space. Therefore, the final space complexity is O(N + k)
class Solution {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> points = new HashMap<>();
        int maxNumber = 0;
        
        for (int num: nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNumber = Math.max(maxNumber, num);
        }

        int[] maxPoints = new int[maxNumber + 1];
        maxPoints[1] = points.getOrDefault(1, 0);
        for (int num = 2; num < maxPoints.length; num++) {
            int gain = points.getOrDefault(num, 0);
            maxPoints[num] = Math.max(maxPoints[num - 1], maxPoints[num - 2] + gain);
        }
        return maxPoints[maxNumber];
    }
}
// @lc code=end

