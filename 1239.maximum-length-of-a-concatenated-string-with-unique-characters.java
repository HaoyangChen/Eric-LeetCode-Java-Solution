/*
 * @lc app=leetcode id=1239 lang=java
 *
 * [1239] Maximum Length of a Concatenated String with Unique Characters
 */

// @lc code=start
class Solution {
    private int result;
    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0) {
            return 0;
        }
        dfs(arr, "", 0);
        return result;
    }
    
    private void dfs(List<String> arr, String path, int index) {
        boolean isUniquechar = isUniqueChars(path);
        
        if (isUniquechar) {
            result = Math.max(path.length(), result);
        }
        
        if (index == arr.size() || !isUniquechar) {
            return;
        }
        for (int i = index; i < arr.size(); i++) {
            dfs(arr, path + arr.get(i), i + 1);
        }
    }
    
    private boolean isUniqueChars(String s) {
        Set<Character> set = new HashSet<>();
        for (char c: s.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }
}
// @lc code=end

