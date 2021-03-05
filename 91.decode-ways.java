/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 */

// @lc code=start

// Time Complexity: O(N) - where N is the length of the string. Memorization helps in pruning the recursion tree and hence decoding for an index only once. The solution is linear time complexity
// Space Complexity: O(N) - The dictionary used for memorization would take the space equal to the length of the string. There would be an entry for each index value. The recursion stack would also be equal to the length of the string.
class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    public int numDecodings(String s) {
        return recursiveWithMemo(0, s);
    }
    
    private int recursiveWithMemo(int index, String str) {
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        
        if (index == str.length()) {
            return 1;
        }
        
        if (str.charAt(index) == '0') {
            return 0;
        }
        
        if (index == str.length() - 1) {
            return 1;
        }
        
        int ans = recursiveWithMemo(index + 1, str);
        if (Integer.parseInt(str.substring(index, index + 2)) <= 26) {
            ans += recursiveWithMemo(index + 2, str);
        }
        memo.put(index, ans);
        return ans;
    }
}
// @lc code=end

