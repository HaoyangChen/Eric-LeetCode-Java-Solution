/*
 * @lc app=leetcode id=429 lang=java
 *
 * [429] N-ary Tree Level Order Traversal
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

// Time Complexity: O(n) - n is the number of nodes
// Space Complexity: O(n)
// class Solution {
//     public List<List<Integer>> levelOrder(Node root) {
//         List<List<Integer>> result = new ArrayList<>();
//         if (root == null) return result;
//         Queue<Node> queue = new LinkedList<>();
//         queue.add(root);
//         while (!queue.isEmpty()) {
//             List<Integer> level = new LinkedList();
//             int size = queue.size();
//             for (int i = 0; i < size; i++) {
//                 Node node = queue.poll();
//                 level.add(node.val);
//                 queue.addAll(node.children);
//             }
//             result.add(level);
//         }
//         return result;
//     }
// }

// Simplified BFS
// Time Complexity: O(n), where n is the number of nodes
// Space Complexity: O(n) same as above, we always have lists containing levels of nodes
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        List<Node> previousLayer = Arrays.asList(root);
        while (!previousLayer.isEmpty()) {
            List<Node> currentLayer = new ArrayList<>();
            List<Integer> previousVals = new ArrayList<>();
            for (Node node: previousLayer) {
                previousVals.add(node.val);
                currentLayer.addAll(node.children);
            }
            result.add(previousVals);
            previousLayer = currentLayer;
        }
        return result;
    }
}


// @lc code=end

