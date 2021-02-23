/*
 * @lc app=leetcode id=1319 lang=java
 *
 * [1319] Number of Operations to Make Network Connected
 */

// @lc code=start
class Solution {
    public int makeConnected(int n, int[][] connections) {
        List<Integer>[] g = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        
        for(int[] e: connections) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        
        int numComponents = bfs(g, n);
        
        return connections.length >= n - 1 ? numComponents - 1 : -1;
    }
    
    private int bfs(List<Integer>[] g, int n) {
        int numComponents = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(visited[i]) {
                continue;
            }
            numComponents++;
            visited[i] = true;
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(i);
            
            while(!queue.isEmpty()) {
                int computer = queue.poll();
                for(int neighbor : g[computer]) {
                    if(!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
        }
        return numComponents;
    }
}
// @lc code=end

