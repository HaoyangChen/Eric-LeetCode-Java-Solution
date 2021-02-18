/*
 * @lc app=leetcode id=797 lang=java
 *
 * [797] All Paths From Source to Target
 */

// @lc code=start

// LeetCode Solution
class Solution {
    private int target;
    private int[][] graph;
    private List<List<Integer>> results;
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.target = graph.length - 1;
        this.graph = graph;
        this.results = new ArrayList<List<Integer>>();
        LinkedList<Integer> path = new LinkedList<Integer>();
        path.addLast(0);
        this.backtrack(0, path);
        return results;
    }
    
    protected void backtrack(int currNode, LinkedList<Integer> path) {
        if (currNode == this.target) {
            this.results.add(new ArrayList<Integer>(path));
            return;
        }
        for (int nextNode: this.graph[currNode]) {
            path.add(nextNode);
            backtrack(nextNode, path);
            path.removeLast();
        }
    }
}
// @lc code=end

