/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start

// Method 1: Sort
// Time Complexity: O(NlogN), where N is the length of points.
// Space Complexity: O(N).
// class Solution {
//     public int[][] kClosest(int[][] points, int k) {
//         int N = points.length;
//         int[] dists = new int[N];
//         for (int i = 0; i < N; ++i) {
//             dists[i] = dist(points[i]);
//         }
//         Arrays.sort(dists);
//         int distK = dists[k - 1];
        
//         int[][] ans = new int[k][2];
//         int t = 0;
//         for (int i = 0; i < N; ++i) {
//             if (dist(points[i]) <= distK) ans[t++] = points[i];
//         }
//         return ans;
//     }
    
//     private int dist(int[] point) {
//         return point[0] * point[0] + point[1] * point[1];
//     }
// }

// Method 2: Heap
// Time Complexity: O(nlogK) where n is the length of points
// Space Complexity: O(K) - because we have at most K points in the heap
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] array1, int[] array2) {
                return array2[0] - array1[0];
            }
        });

        for (int i = 0; i < K; i++) {
            pq.offer(new int[]{points[i][0] * points[i][0] + points[i][1] * points[i][1], i});
        }
        int n = points.length;
        for (int i = K; i < n; ++i) {
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (dist < pq.peek()[0]) {
                pq.poll();
                pq.offer(new int[]{dist, i});
            }
        }
        int[][] ans = new int[K][2];
        for (int i = 0; i < K; i++) {
            ans[i] = points[pq.poll()[1]];
        }
        return ans;
    }
}
// @lc code=end

