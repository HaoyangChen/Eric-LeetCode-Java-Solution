/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
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

// Shangan Solution
// class Solution {
//     List <List<Integer>> result;
//     public List<String> binaryTreePaths(TreeNode root) {
//         result = new ArrayList<>();
//         helper(root, new ArrayList<>());
//         return convert();
//     }
    
//     private void helper (TreeNode node, List<Integer> list) {
//         if (node == null) {
//             return;
//         }
//         list.add(node.val);
        
//         if (node.left == null && node.right == null) {
//             result.add(new ArrayList<>(list));
//         } else {
//             helper(node.left, list);
//             helper(node.right, list);
//         }
//         list.remove(list.size() - 1);
//     }
    
//     private List<String> convert() {
//         return result.stream()
//             .map(list -> {
//                 StringBuilder sb = new StringBuilder();
//                 for (int element: list) {
//                     sb.append(element);
//                     sb.append("->");
//                 }
//                 sb.setLength(sb.length() - 2);
//                 return sb.toString();
//             })
//             .collect(Collectors.toList());
//     }
// }



// LeetCode Solution
// Time Complexity: We visit each node exactly once, thus the time complexity is O(N), where N is the number of nodes
// Space complexity : O(N). Here we use the space for a stack call and for a paths list to store the answer. paths contains as many elements as leafs in the tree and hence couldn't be larger than logN for the trees containing more than one element. Hence the space complexity is determined by a stack call. In the worst case, when the tree is completely unbalanced, e.g. each node has only one child node, the recursion call would occur N times (the height of the tree), therefore the storage to keep the call stack would be O(N). But in the best case (the tree is balanced), the height of the tree would be log(N). Therefore, the space complexity in this case would be O(log(N)).

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> paths = new LinkedList();
        construct_path(root, "", paths);
        return paths;
    }
    
    private void construct_path(TreeNode root, String path, LinkedList<String> paths) {
        if (root != null) {
            path += Integer.toString(root.val);
            if ((root.left == null) && (root.right == null)) {
                paths.add(path);
            } else {
                path += "->";
                construct_path(root.left, path, paths);
                construct_path(root.right, path, paths);
            }
        }
    }
}
// @lc code=end

