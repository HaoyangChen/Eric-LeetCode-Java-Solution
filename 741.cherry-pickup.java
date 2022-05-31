/*
 * @lc app=leetcode id=741 lang=java
 *
 * [741] Cherry Pickup
 */

// @lc code=start

import java.util.*;
class Solution {
    private int[][][] memo;
    private int[][] grid;
    private int N;
    
    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        N = grid.length;
        memo = new int[N][N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(memo[i][j], Integer.MIN_VALUE);
            }
        }
        return Math.max(0, dfs(0, 0, 0));
    }
    
    private int dfs(int x1, int y1, int x2) {
        int y2 = x1 + y1 - x2;
        if (x1 == N || y2 == N || y1 == N || x2 == N || grid[x1][y1] == -1 || grid[x2][y2] == -1) return -1;
        if (x1 == N - 1 && y1 == N - 1) return grid[x1][y1];
        if (memo[x1][y1][x2] != Integer.MIN_VALUE) return memo[x1][y1][x2];
        int result = Math.max(Math.max(dfs(x1, y1 + 1, x2 + 1), dfs(x1 + 1, y1, x2)), Math.max(dfs(x1 + 1, y1, x2 + 1), dfs(x1, y1 + 1, x2)));
        if (result < 0) return memo[x1][y1][x2] = -1;
        result += grid[x1][y1];
        if (x1 != x2) result += grid[x2][y2];
        return memo[x1][y1][x2] = result;
    }
}
// @lc code=end

