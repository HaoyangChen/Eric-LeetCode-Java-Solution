/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start
// class Solution {
//     public int[] findOrder(int numCourses, int[][] prerequisites) {
//         List<List<Integer>> edges;
//         int[] indeg;
//         int[] result;
//         int index;

//         edges = new ArrayList<List<Integer>>();
//         for (int i = 0; i < numCourses; ++i) {
//             edges.add(new ArrayList<Integer>());
//         }
//         indeg = new int[numCourses];
//         result = new int[numCourses];
//         index = 0;
//         for (int[] info: prerequisites) {
//             edges.get(info[1]).add(info[0]);
//             ++indeg[info[0]];
//         }
//         Queue<Integer> queue = new LinkedList<Integer>();
//         for (int i = 0; i < numCourses; i++) {
//             if (indeg[i] == 0) {
//                 queue.offer(i);
//             }
//         }
//         while (!queue.isEmpty()) {
//             int u = queue.poll();
//             result[index++] = u;
//             for (int v: edges.get(u)) {
//                 --indeg[v];
//                 if (indeg[v] == 0) {
//                     queue.offer(v);
//                 }
//             }
//         }
//         if (index != numCourses) {
//             return new int[0];
//         }
//         return result;
//     }
// }

// LeetCode Solution
// Time Complexity: O(V + E) where V represents the number of vertices and E represents the number of edges.We pop each node exactly once from the zero in-degree queue and that gives us VV. Also, for each vertex, we iterate over its adjacency list and in totality, we iterate over all the edges in the graph which gives us EE. Hence, O(V + E)
// Space Complexity: O(V+E). We use an intermediate queue data structure to keep all the nodes with 0 in-degree. In the worst case, there won't be any prerequisite relationship and the queue will contain all the vertices initially since all of them will have 0 in-degree. That gives us O(V). Additionally, we also use the adjacency list to represent our graph initially. The space occupied is defined by the number of edges because for each node as the key, we have all its adjacent nodes in the form of a list as the value. Hence, O(E). So, the overall space complexity is O(V+E).
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean isPossible = true;
        Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
        int[] indegree = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];
        
        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> lst = adjList.getOrDefault(src, new ArrayList<Integer>());
            lst.add(dest);
            adjList.put(src, lst);
            
            indegree[dest] += 1;
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        
        int i = 0; 
        while (!q.isEmpty()) {
            int node = q.remove();
            topologicalOrder[i++] = node;
            
            if (adjList.containsKey(node)) {
                for (Integer neighbor: adjList.get(node)) {
                    indegree[neighbor]--;
                    
                    if (indegree[neighbor] == 0) {
                        q.add(neighbor);
                    }
                }
            }
        }
        
        if (i == numCourses) {
            return topologicalOrder;
        }
        return new int[0];
    }
}
// @lc code=end

