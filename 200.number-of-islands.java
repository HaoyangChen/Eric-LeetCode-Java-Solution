/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
// class Solution {
//     private static int [] xBias = {0, 0, 1, -1};
//     private static int [] yBias = {1, -1, 0, 0};
//     private int count;
//     public int numIslands(char[][] grid) {
//         count = 0;
//         if (grid == null || grid[0].length == 0) {
//             return count;
//         }

//         for (int i = 0; i < grid.length; i++) {
//             for (int j = 0; j < grid[0].length; j++) {
//                 if (grid[i][j] == '1') {
//                     bfs(grid, i, j);
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }

//     private void bfs(char[][] grid, int i, int j) {
//         int n = grid.length;
//         int m = grid[0].length;
//         grid[i][j] = '2';
//         Queue<Integer> queue = new ArrayDeque<>();
//         queue.offer(i * m + j);
//         while (!queue.isEmpty()) {
//             int num = queue.poll();
//             i = num / m;
//             j = num % m;
//             for (int k = 0; k < xBias.length; k++) {
//                 int newI = i + xBias[k];
//                 int newJ = j + yBias[k];
//                 if (newI < 0 || newI >= n || newJ < 0 || newJ >= m || grid[newI][newJ] != '1') {
//                     continue;
//                 }
//                 queue.offer(newI * m + newJ);
//                 grid[newI][newJ] = '2';
//             }
//         }
//     }
// }


// Method 2: BFS
// class Solution {
//     public int numIslands(char[][] grid) {
//         if (grid == null || grid.length == 0) return 0;
        
//         int nr = grid.length;
//         int nc = grid[0].length;
//         int numberIsland = 0;
        
//         for (int r = 0; r < nr; ++r) {
//             for (int c = 0; c < nc; ++c) {
//                 if (grid[r][c] == '1') {
//                     ++numberIsland;
//                     grid[r][c] = '0';
//                     Queue<Integer> neighbors = new LinkedList<>();
//                     neighbors.add(r * nc + c);
//                     while (!neighbors.isEmpty()) {
//                         int id = neighbors.remove();
//                         int row = id / nc;
//                         int col = id % nc;
//                         if (row - 1 >= 0 && grid[row - 1][col] == '1') {
//                             neighbors.add((row - 1) * nc + col);
//                             grid[row - 1][col] = '0';
//                         }
//                         if (row + 1 < nr && grid[row + 1][col] == '1') {
//                             neighbors.add((row + 1) * nc + col);
//                             grid[row + 1][col] = '0';
//                         }
//                         if (col - 1 >= 0 && grid[row][col - 1] == '1') {
//                             neighbors.add(row * nc + col - 1);
//                             grid[row][col - 1] = '0';
//                         }
//                         if (col + 1 < nc && grid[row][col + 1] == '1') {
//                             neighbors.add(row * nc + col + 1);
//                             grid[row][col + 1] = '0';
//                         }
//                     }
//                 }
//             }
//         }
//         return numberIsland;
//     }
// }

// Method 3: DFS

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int numIsland = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++numIsland;
                    dfs(grid, r, c);
                }
            }
        }
        return numIsland;
    }

    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') return;

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
}
// @lc code=end

