/*
 * @lc app=leetcode id=662 lang=java
 *
 * [662] Maximum Width of Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// Method 1: BFS
// Time Complexity: O(N) - We visit each node once and only once. And at each visit, it takes a constant time to process.
// Space Complexity: O(N) - We used a queue to maintain the nodes along with its indices, which is the main memory consumption of the algorithm.
// class Solution {
//     public int widthOfBinaryTree(TreeNode    ) {
//         if (root == null) return 0;
//         LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
//         Integer maxWidth = 0;
//         queue.addLast(new Pair<>(root, 0));
//         while (queue.size() > 0) {
//             Pair<TreeNode, Integer> head = queue.getFirst();
//             Integer currentLevelSize = queue.size();
//             Pair<TreeNode, Integer> element = null;
//             for (int i = 0; i < currentLevelSize; i++) {
//                 element = queue.removeFirst();
//                 TreeNode node = element.getKey();
//                 if (node.left != null) {
//                     queue.addLast(new Pair<>(node.left, 2 * element.getValue()));
//                 }
//                 if (node.right != null) {
//                     queue.addLast(new Pair<>(node.right, 2 * element.getValue() + 1));
//                 }
//             }
//             maxWidth = Math.max(maxWidth, element.getValue() - head.getValue() + 1);
//         }
//         return maxWidth;
//     }
// }


// Method 2: DFS Traversal
// Time Complexity: O(N). Similar to the BFS traversal, we visit each node once and only once in DFS traversal. And each visit takes a constant time to process as well.
// Space Complexity: O(N).  In the worst case where the tree is extremely skewed, there could be as many levels as the number of nodes. 
//                          An additional table to keep the index for the first element per level could take O(N) space complexity. If the tree is extremely skewed, the depth of the recursion would be equal to the number of nodes in the tree. 
//                          The space complexity of the function stack would be O(N).
class Solution {
    private Integer maxWidth = 0;
    private HashMap<Integer, Integer> firstColIndexTable;

    public int widthOfBinaryTree(TreeNode root) {
        this.firstColIndexTable = new HashMap<Integer, Integer>();
        dfs(root, 0, 0);
        return this.maxWidth;
    }

    protected void dfs(TreeNode node, Integer depth, Integer colIndex) {
        if (node == null) {
            return;
        }
        if (!firstColIndexTable.containsKey(depth)) {
            firstColIndexTable.put(depth, colIndex);
        }
        Integer firstColIndex = firstColIndexTable.get(depth);
        maxWidth = Math.max(this.maxWidth, colIndex - firstColIndex + 1);
        dfs(node.left, depth + 1, colIndex * 2);
        dfs(node.right, depth + 1, colIndex * 2 + 1);
    }
}

// @lc code=end

