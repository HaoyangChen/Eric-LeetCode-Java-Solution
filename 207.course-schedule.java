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



// Postorder DFS Method
// Time Complexity: O(|E| + |V|) where |V| is the numebr of vertices and |E| is the number of dependencies
// Space Complexity: O(|E| + |V|)
// class Solution {
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
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

//         boolean[] checked = new boolean[numCourses];
//         boolean[] path = new boolean[numCourses];

//         for (int currCourse = 0; currCourse < numCourses; currCourse++) {
//             if (this.isCyclic(currCourse, courseDict, checked, path)) {
//                 return false;
//             }
//         }
//         return true;
//     }

//     protected boolean isCyclic(int currCourse, HashMap<Integer, List<Integer>> courseDict, boolean[] checked, boolean[] path) {
//         if (checked[currCourse]) {
//             return false;
//         }
//         if (path[currCourse]) {
//             return true;
//         }
//         if (!courseDict.containsKey(currCourse)) {
//             return false;
//         }
//         path[currCourse] = true;
//         boolean result = false;
//         for (Integer child: courseDict.get(currCourse)) {
//             result = this.isCyclic(child, courseDict, checked, path);
//             if (result) break;
//         }
//         path[currCourse] = false;
//         checked[currCourse] = true;
//         return result;
//     }
// }


// Topological Sort Method
// Time Complexity: O(|E| + |V|) where |V| is the numebr of vertices and |E| is the number of dependencies
// Space Complexity: O(|E| + |V|)
class GNode {
    public Integer indegrees = 0;
    public List<Integer> outNodes = new LinkedList<Integer>();
}

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) return true;
        HashMap<Integer, GNode> graph = new HashMap<>();
        for (int[] relation: prerequisites) {
            GNode prevCourse = this.getCreateGNode(graph, relation[1]);
            GNode nextCourse = this.getCreateGNode(graph, relation[0]);
            prevCourse.outNodes.add(relation[0]);
            nextCourse.indegrees += 1;
        }

        int totalDeps = prerequisites.length;
        LinkedList<Integer> nodepCourses = new LinkedList<Integer>();
        for (Map.Entry<Integer, GNode> entry: graph.entrySet()) {
            GNode node = entry.getValue();
            if (node.indegrees == 0) {
                nodepCourses.add(entry.getKey());
            }
        }
        int removedEdges = 0;
        while (nodepCourses.size() > 0) {
            Integer course = nodepCourses.pop();
            for (Integer nextCourse: graph.get(course).outNodes) {
                GNode childNode = graph.get(nextCourse);
                childNode.indegrees -= 1;
                removedEdges++;
                if (childNode.indegrees == 0) {
                    nodepCourses.add(nextCourse);
                }
            }
        }
        if (removedEdges != totalDeps) {
            return false;
        }
        return true;
    }

    protected GNode getCreateGNode(HashMap<Integer, GNode> graph, Integer course) {
        GNode node = null;
        if (graph.containsKey(course)) {
            node = graph.get(course);
        } else {
            node = new GNode();
            graph.put(course, node);
        }
        return node;
    }
}

// @lc code=end

