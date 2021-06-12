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

// class Solution {
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         int[] inDegree = new int[numCourses];
//         Map<Integer, Set<Integer>> graph = new HashMap<>();
//         for (int[] prerequisite: prerequisites) {
//             graph.computeIfAbsent(prerequisite[1], k -> new HashSet<>()).add(prerequisite[0]);
//             inDegree[prerequisite[0]]++;
//         }
//         Queue<Integer> queue = new ArrayDeque<>();
//         for (int i = 0; i < inDegree.length; i++) {
//             if (inDegree[i] == 0) {
//                 queue.offer(i);
//             }
//         }
//         while (!queue.isEmpty()) {
//             int course = queue.poll();
//             numCourses--;
//             if (!graph.containsKey(course)) {
//                 continue;
//             }
//             for (int relatedCourse: graph.get(course)) {
//                 inDegree[relatedCourse]--;
//                 if (inDegree[relatedCourse] == 0) {
//                     queue.offer(relatedCourse);
//                 }
//             }
//         }
//         return numCourses == 0;
//     }
// }



// Backtracking Method
// Time Limit Exceeded
// Time Complexity: O(|E| + |V| ^ 2) where |E| is the number of dependencies,∣V∣ is the number of courses and d is the maximum length of acyclic paths in the graph.
// Space Complexity: Space Complexity: O(∣E∣+∣V∣), with the same denotation as in the above time complexity.
// class Solution {
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         // build adjacency list: course -> list of next courses
//         HashMap<Integer, List<Integer>> courseDict = new HashMap<>();
//         for (int[] relation: prerequisites) {
//             if (courseDict.containsKey(relation[1])) {
//                 courseDict.get(relation[1]).add(relation[0]);
//             } else {
//                 List<Integer> nextCourses = new LinkedList<>();
//                 nextCourses.add(relation[0]);
//                 courseDict.put(relation[1], nextCourses);
//             }
//         }
//         boolean[] path = new boolean[numCourses];
//         for (int currCourse = 0; currCourse < numCourses; ++currCourse) {
//             if (this.isCyclic(currCourse, courseDict, path)) {
//                 return false;
//             }
//         }
//         return true;
//     }


//     protected boolean isCyclic(int currCourse, HashMap<Integer, List<Integer>> courseDict, boolean[] path) {
//         if (path[currCourse]) {
//             return true;
//         }

//         if (!courseDict.containsKey(currCourse)) {
//             return false;
//         }

//         path[currCourse] = true;
//         boolean result = false;
//         for (Integer nextCourse: courseDict.get(currCourse)) {
//             result = isCyclic(nextCourse, courseDict, path);
//             if (result) break;
//         }
//         path[currCourse] = false;
//         return result;
//     }
// }
// @lc code=end

