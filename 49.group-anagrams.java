/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start

// Method 1: Categorize by Sorted String
// Time Complexity: O(NKlogK), where N is the length of strs, and K is the maximum length of a string in strs. The outer loop has complexity O(N) as we iterate through each string. Then, we sort each string in O(KlogK) time
// Space Complexity: O(NK) the total information content stored in ans
// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         if (strs.length == 0) return new ArrayList();
//         Map<String, List> ans = new HashMap<String, List>();
//         for (String str: strs) {
//             char[] characters = str.toCharArray();
//             Arrays.sort(characters);
//             String key = String.valueOf(characters);
//             if(!ans.containsKey(key)) ans.put(key, new ArrayList());
//             ans.get(key).add(str);
//         }
//         return new ArrayList(ans.values());
//     }
// }

// Method 2: Categorize by Count
// Time Complexity: O(NK), where N is the length of strs, and K is the maximum length of a string in strs. Counting each string is linear in the size of the string, and we count every string
// Space Complexity: O(NK), the total information content stored in map
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> map = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s: strs) {
            Arrays.fill(count, 0);
            for (char c: s.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!map.containsKey(key)) map.put(key, new ArrayList());
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}

// @lc code=end

