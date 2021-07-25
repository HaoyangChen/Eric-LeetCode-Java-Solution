/*
 * @lc app=leetcode id=1466 lang=java
 *
 * [1466] Reorder Routes to Make All Paths Lead to the City Zero
 */

// @lc code=start
class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> tree = new ArrayList<>();
        int len = connections.length;
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < len; i++) {
            tree.get(connections[i][0]).add(i);
            tree.get(connections[i][1]).add(i);
        }
        boolean[] visited = new boolean[len];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int ans = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            List<Integer> connection = tree.get(node);
            for (Integer idx : connection) {
                if (!visited[idx]) {
                    visited[idx] = true;
                    int a = connections[idx][0];
                    int b = connections[idx][1];
                    ans += a == node ? 1 : 0;
                    queue.offer(a == node ? b : a);
                }
            }
        }
        return ans;
    }
}
// @lc code=end

