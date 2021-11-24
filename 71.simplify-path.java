import java.util.Stack;

/*
 * @lc app=leetcode id=71 lang=java
 *
 * [71] Simplify Path
 */

// @lc code=start

// Time Complexity: O(N) if there are N characters in the original path. First, we spend O(N) trying to split input path into components and then process each component one by one, which is an O(N) operation.
// Space Complexity: O(N) because we have the array that contains the split components and then we have the stack.
class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");
        for (String directory: components) {
            if (directory.equals(".") || directory.isEmpty()) {
                continue;
            } else if (directory.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.add(directory);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String dir: stack) {
            sb.append("/");
            sb.append(dir);
        }
        return sb.length() > 0 ? sb.toString() : "/";
    }
}
// @lc code=end

