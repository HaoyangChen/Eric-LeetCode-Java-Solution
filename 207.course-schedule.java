/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start
// class Solution {
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         List<List<Integer>> edges;
//         int[] indeg;
//         edges = new ArrayList<List<Integer>>();
//         for (int i = 0; i < numCourses; ++i) {
//             edges.add(new ArrayList<Integer>());
//         }
//         indeg = new int[numCourses];
//         for (int[] info: prerequisites) {
//             edges.get(info[1]).add(info[0]);
//             ++indeg[info[0]];
//         }
//         Queue<Integer> queue = new LinkedList<Integer>();
//         for (int i = 0; i < numCourses; ++i) {
//             if (indeg[i] == 0) {
//                 queue.offer(i);
//             }
//         }
//         int visited = 0;
//         while (!queue.isEmpty()) {
//             ++visited;
//             int u = queue.poll();
//             for (int v: edges.get(u)) {
//                 --indeg[v];
//                 if (indeg[v] == 0) {
//                     queue.offer(v);
//                 }
//             }
//         }
//         return visited == numCourses;
//     }
// }

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] prerequisite: prerequisites) {
            graph.computeIfAbsent(prerequisite[1], k -> new HashSet<>()).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            numCourses--;
            if (!graph.containsKey(course)) {
                continue;
            }
            for (int relatedCourse: graph.get(course)) {
                inDegree[relatedCourse]--;
                if (inDegree[relatedCourse] == 0) {
                    queue.offer(relatedCourse);
                }
            }
        }
        return numCourses == 0;
    }
}
// @lc code=end

