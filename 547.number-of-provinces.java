/*
 * @lc app=leetcode id=547 lang=java
 *
 * [547] Number of Provinces
 */

// @lc code=start

// Method 1: Using Depth First Search
// Time Complexity: O(n^2) The complete matrix of size n^2 is traversed
// Space Complexity: O(n) - visited array of size n is used
// class Solution {
//     public int findCircleNum(int[][] isConnected) {
//         int[] visited = new int[isConnected.length];
//         int count = 0;
//         for (int i = 0; i < isConnected.length; i++) {
//             if (visited[i] == 0) {
//                 dfs(isConnected, visited, i);
//                 count++;
//             }
//         }
//         return count;
//     }
    
//     public void dfs(int[][] isConnected, int[] visited, int i) {
//         for (int j = 0; j < isConnected.length; j++) {
//             if (isConnected[i][j] == 1 && visited[j] == 0) {
//                 visited[j] = 1;
//                 dfs(isConnected, visited, j);
//             }
//         }
//     }
// }

// Method 2: Using Breadth First Search
// Time Complexity: O(n^2) The complete matrix of size n^2 is traversed
// Space Complexity: O(n) - A queue and visited array of size n is used
// class Solution {
//     public int findCircleNum(int[][] isConnected) {
//         int[] visited = new int[isConnected.length];
//         int count = 0;
//         Queue<Integer> queue = new LinkedList<>();
//         for (int i = 0; i < isConnected.length; i++) {
//             if (visited[i] == 0) {
//                 queue.add(i);
//                 while (!queue.isEmpty()) {
//                     int s = queue.remove();
//                     visited[s] = 1;
//                     for (int j = 0; j < isConnected.length; j++) {
//                         if (isConnected[s][j] == 1 && visited[j] == 0) {
//                             queue.add(j);
//                         }
//                     }
//                 }
//                 count++;
//             }
//         }
//         return count;
//     }
// }


// Time Complexity: O(n^3) We traverse over the complete matrix once. Union and find operations take O(n) time in the worst case
// Space Complexity: O(n) parent array of size n is used
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int[] parent = new int[isConnected.length];
        Arrays.fill(parent, -1);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    union(parent, i, j);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1) result++;
        }
        return result;
    }
    
    private void union(int[] parent, int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        if (xset != yset) {
            parent[xset] = yset;
        }
    }
    
    private int find(int[] parent, int i) {
        if (parent[i] == -1) return i;
        return find(parent, parent[i]);
    }
}

// @lc code=end

