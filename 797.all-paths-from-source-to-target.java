/*
 * @lc app=leetcode id=797 lang=java
 *
 * [797] All Paths From Source to Target
 */

// @lc code=start
// LeetCode Solution
// class Solution {
//     private int target;
//     private int[][] graph;
//     private List<List<Integer>> results;
    
//     public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
//         this.target = graph.length - 1;
//         this.graph = graph;
//         this.results = new ArrayList<List<Integer>>();
//         LinkedList<Integer> path = new LinkedList<Integer>();
//         path.addLast(0);
//         this.backtrack(0, path);
//         return results;
//     }
    
//     protected void backtrack(int currNode, LinkedList<Integer> path) {
//         if (currNode == this.target) {
//             this.results.add(new ArrayList<Integer>(path));
//             return;
//         }
//         for (int nextNode: this.graph[currNode]) {
//             path.add(nextNode);
//             backtrack(nextNode, path);
//             path.removeLast();
//         }
//     }
// }


// Shangan Solution
// class Solution {
//     private List<List<Integer>> result;
    
//     public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
//         result = new ArrayList<>();
//         if (graph == null || graph.length == 0) {
//             return result;
//         }
//         List<Integer> path = new ArrayList<>();
//         path.add(0);
//         dfs(graph, 0, path);
//         return result;
//     }
    
//     private void dfs(int[][] graph, int index, List<Integer> path) {
//         if (index == graph.length - 1) {
//             result.add(new ArrayList<>(path));
//             return;
//         }
//         for (int neighbor: graph[index]) {
//             path.add(neighbor);
//             dfs(graph, neighbor, path);
//             path.remove(path.size() - 1);
//         }
//     }  
// }


// Method 3: Top-Down Dynamic Programming
class Solution {
    private int target;
    private int[][] graph;
    private HashMap<Integer, List<List<Integer>>> memo;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.target = graph.length - 1;
        this.graph = graph;
        this.memo = new HashMap<>();
        return this.allPathsToTarget(0);
    }

    protected List<List<Integer>> allPathsToTarget(int currNode) {
        if (memo.containsKey(currNode)) {
            return memo.get(currNode);
        }

        List<List<Integer>> results = new ArrayList<>();
        if (currNode == this.target) {
            ArrayList<Integer> path = new ArrayList<>();
            path.add(target);
            results.add(path);
            return results;
        }

        for (int nextNode: this.graph[currNode]) {
            for (List<Integer> path: allPathsToTarget(nextNode)) {
                ArrayList<Integer> newPath = new ArrayList<>();
                newPath.add(currNode);
                newPath.addAll(path);
                results.add(newPath);
            }
        }
        memo.put(currNode, results);
        return results;
    }
}
// @lc code=end

