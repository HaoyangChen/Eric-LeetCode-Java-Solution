/*
 * @lc app=leetcode id=746 lang=java
 *
 * [746] Min Cost Climbing Stairs
 */

// @lc code=start
import java.util.*;

import javax.xml.catalog.CatalogFeatures.Feature;


// Approach 1: Top-Down Dynamic Programming
// Time Complexity: O(N) minimum cost gets called with each index from 0 and N. Because of the memorization, each call takes O(1) time
// Space Complexity: O(N) - the extra space used by this algorithm is the recursion call stack

// class Solution {
//     private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//     public int minCostClimbingStairs(int[] cost) {
//         return minimumCost(cost.length, cost);
//     }

//     private int minimumCost(int i, int[] cost) {
//         if (i <= 1) return 0;
//         if (map.containsKey(i)) return map.get(i);
//         int downOne = cost[i - 1] + minimumCost(i - 1, cost);
//         int downTwo = cost[i - 2] + minimumCost(i - 2, cost);
//         map.put(i, Math.min(downOne, downTwo));
//         return map.get(i);
//     }
// }


// Approach 2: Bottom-Up Dynamic Programming
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int minimumCost[] = new int[cost.length + 1];
        for (int i = 2; i < minimumCost.length; i++) {
            int takeOneStep = minimumCost[i - 1] + cost[i - 1];
            int takeTwoStep = minimumCost[i - 2] + cost[i - 2];
            minimumCost[i] = Math.min(takeOneStep, takeTwoStep);
        }
        return minimumCost[minimumCost.length - 1];
    }
}


// @lc code=end

