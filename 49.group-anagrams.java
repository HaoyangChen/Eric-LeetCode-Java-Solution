/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start

// Time Complexity: O(NKlogK), where N is the length of strs, and K is the maximum length of a string in strs. The outer loop has complexity O(N) as we iterate through each string. Then, we sort each string in O(KlogK) time
// Space Complexity: O(NK) the total information content stored in ans
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String str: strs) {
            char[] characters = str.toCharArray();
            Arrays.sort(characters);
            String key = String.valueOf(characters);
            if(!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(str);
        }
        return new ArrayList(ans.values());
    }
}
// @lc code=end

