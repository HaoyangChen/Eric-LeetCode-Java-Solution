/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    private static int [] xBias = {0, 0, 1, -1};
    private static int [] yBias = {1, -1, 0, 0};
    private int count;
    public int numIslands(char[][] grid) {
        count = 0;
        if (grid == null || grid[0].length == 0) {
            return count;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;
        grid[i][j] = '2';
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(i * m + j);
        while (!queue.isEmpty()) {
            int num = queue.poll();
            i = num / m;
            j = num % m;
            for (int k = 0; k < xBias.length; k++) {
                int newI = i + xBias[k];
                int newJ = j + yBias[k];
                if (newI < 0 || newI >= n || newJ < 0 || newJ >= m || grid[newI][newJ] != '1') {
                    continue;
                }
                queue.offer(newI * m + newJ);
                grid[newI][newJ] = '2';
            }
        }
    }
}
// @lc code=end

