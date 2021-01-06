/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges;
        int[] indeg;
        int[] result;
        int index;

        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        indeg = new int[numCourses];
        result = new int[numCourses];
        index = 0;
        for (int[] info: prerequisites) {
            edges.get(info[1]).add(info[0]);
            ++indeg[info[0]];
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int u = queue.poll();
            result[index++] = u;
            for (int v: edges.get(u)) {
                --indeg[v];
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        if (index != numCourses) {
            return new int[0];
        }
        return result;
    }
}
// @lc code=end

