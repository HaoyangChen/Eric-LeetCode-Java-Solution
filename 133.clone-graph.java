/*
 * @lc app=leetcode id=133 lang=java
 *
 * [133] Clone Graph
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/


// Method: Shangan Solution 

// class Solution {
//     public Node cloneGraph(Node node) {
//         return dfs(node, new HashMap<>());
//     }
    
//     private Node dfs(Node node, Map<Node, Node> map) {
//         if (node == null) {
//             return null;
//         }
//         if (map.containsKey(node)) {
//             return map.get(node);
//         }
//         Node clone = new Node(node.val);
//         map.put(node, clone);
//         for (Node neighbor: node.neighbors) {
//             clone.neighbors.add(dfs(neighbor, map));
//         }
//         return clone;
//     }
// }


// Method 1: LeetCode Solution - Depth First Search
// class Solution {
//     private HashMap<Node, Node> visited = new HashMap<>();
//     public Node cloneGraph(Node node) {
//         if (node == null) {
//             return node;
//         }
        
//         if (visited.containsKey(node)) {
//             return visited.get(node);
//         }
        
//         Node cloneNode = new Node(node.val, new ArrayList());
//         visited.put(node, cloneNode);
        
//         for (Node neighbor: node.neighbors) {
//             cloneNode.neighbors.add(cloneGraph(neighbor));
//         }
//         return cloneNode;
//     }
// }


// Method 2: LeetCode Solution - Breath First Search
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        
        HashMap<Node, Node> visited = new HashMap();
        
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(node);
        visited.put(node, new Node(node.val, new ArrayList<>()));
        
        while (!queue.isEmpty()) {
            Node n = queue.remove();
            for (Node neighbor: n.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.add(neighbor);
                }
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }
}
// @lc code=end

