import java.util.LinkedList;

import javax.swing.JPopupMenu.Separator;

/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 // Method 1
// public class Codec {
//     private String SEP = ",";
//     private String NULL = "#";
//     // Encodes a tree to a single string.
//     public String serialize(TreeNode root) {
//         StringBuilder sb = new StringBuilder();
//         serialize(root, sb);
//         return sb.toString();
//     }

//     private void serialize(TreeNode root, StringBuilder sb) {
//         if (root == null) {
//             sb.append(NULL).append(SEP);
//             return;
//         }
//         sb.append(root.val).append(SEP);
//         serialize(root.left, sb);
//         serialize(root.right, sb);
//     }

//     // Decodes your encoded data to tree.
//     public TreeNode deserialize(String data) {
//         LinkedList<String> nodes = new LinkedList<>();
//         for (String s: data.split(SEP)) {
//             nodes.addLast(s);
//         }
//         return deserialize(nodes);
//     }

//     private TreeNode deserialize(LinkedList<String> nodes) {
//         if (nodes.isEmpty()) return null;
//         String first = nodes.removeFirst();
//         if (first.equals(NULL)) return null;
//         TreeNode root = new TreeNode(Integer.parseInt(first));
//         root.left = deserialize(nodes);
//         root.right = deserialize(nodes);
//         return root;
//     }
// }

// Method 2: Depth First Search (DFS)
// Time Complexity: O(N) - in both serialization and deserialization functions, we visit each node exactly once, thus the time complexity is O(N), where N is the number of nodes
// Space Complexity: in both serialization and deserialization functions, we keep the entire tree, either at the beginning or at the end, therefore, the space complexity is O(N)
// public class Codec {
//     public String rserialize(TreeNode root, String str) {
//         // Recursive serialization.
//         if (root == null) {
//           str += "null,";
//         } else {
//           str += str.valueOf(root.val) + ",";
//           str = rserialize(root.left, str);
//           str = rserialize(root.right, str);
//         }
//         return str;
//       }
    
//       // Encodes a tree to a single string.
//       public String serialize(TreeNode root) {
//         return rserialize(root, "");
//       }

//       public TreeNode rdeserialize(List<String> l) {
//         // Recursive deserialization.
//         if (l.get(0).equals("null")) {
//           l.remove(0);
//           return null;
//         }
    
//         TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
//         l.remove(0);
//         root.left = rdeserialize(l);
//         root.right = rdeserialize(l);
//         return root;
//       }
    
//       // Decodes your encoded data to tree.
//       public TreeNode deserialize(String data) {
//         String[] data_array = data.split(",");
//         List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
//         return rdeserialize(data_list);
//       }
// }



// Method 3: pre-order traversal
public class Codec {
  String SEPARATOR = ",";
  String NULL = "#";
  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
      StringBuilder sb = new StringBuilder();
      serialize(root, sb);
      return sb.toString();
  }

  private void serialize(TreeNode root, StringBuilder sb) {
    if (root == null) {
      sb.append(NULL).append(SEPARATOR);
      return;
    }
    sb.append(root.val).append(SEPARATOR);
    serialize(root.left, sb);
    serialize(root.right, sb);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
      LinkedList<String> nodes = new LinkedList<>();
      for (String s: data.split(",")) nodes.addLast(s);
      return deserialize(nodes);
  }

  private TreeNode deserialize(LinkedList<String> nodes) {
      if (nodes.isEmpty()) return null;
      String firstNode = nodes.removeFirst();
      if (firstNode.equals(NULL)) return null;
      TreeNode root = new TreeNode(Integer.parseInt(firstNode));
      root.left = deserialize(nodes);
      root.right = deserialize(nodes);
      return root;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end

