/*
 * @lc app=leetcode id=559 lang=java
 *
 * [559] Maximum Depth of N-ary Tree
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

// Shangan Solution
// class Solution {
//     public int maxDepth(Node root) {
//         if (root == null) return 0;
//         int height = 1;
//         for (Node node: root.children) {
//             height = Math.max(height, maxDepth(node) + 1);
//         }
//         return height;
//     }
// }

// leetcode solution: recursion
// Time complexity : we visit each node exactly once, thus the time complexity is O(N), where N is the number of nodes.
// Space complexity : in the worst case, the tree is completely unbalanced, e.g. each node has only one child node, the // recursion call would occur N times (the height of the tree), therefore the storage to keep the call stack would be
// O(N). But in the best case (the tree is completely balanced), the height of the tree would be log(N). Therefore, the //space complexity in this case would be O(log(N)).
class Solution {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        } else if (root.children.isEmpty()) {
            return 1;
        } else {
            List<Integer> heights = new LinkedList<>();
            for (Node item: root.children) {
                heights.add(maxDepth(item));
            }
            return Collections.max(heights) + 1;
        }
    }
}
// @lc code=end

