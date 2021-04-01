/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start

// Method 1: Sort
// Time Complexity: O(NlogN), where NN is the length of points.
// Space Complexity: O(N).
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int N = points.length;
        int[] dists = new int[N];
        for (int i = 0; i < N; ++i) {
            dists[i] = dist(points[i]);
        }
        
        Arrays.sort(dists);
        int distK = dists[k - 1];
        
        int[][] ans = new int[k][2];
        int t = 0;
        for (int i = 0; i < N; ++i) {
            if (dist(points[i]) <= distK) ans[t++] = points[i];
        }
        return ans;
        
    }
    
    private int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
// @lc code=end

