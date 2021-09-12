/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 */

// @lc code=start
// class Solution {
//     public boolean checkInclusion(String s1, String s2) {
//         HashMap<Character, Integer> need = new HashMap<Character, Integer>();
//         HashMap<Character, Integer> window = new HashMap<Character, Integer>();
//         for (char c: s1.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1);
//         int left = 0, right = 0;
//         int valid = 0;
//         while (right < s2.length()) {
//             char c = s2.charAt(right);
//             right++;
//             if (need.containsKey(c)) {
//                 window.put(c, window.getOrDefault(c, 0) + 1);
//                 if (window.get(c).equals(need.get(c))) {
//                     valid++;
//                 }
//             }
//             while (right - left >= s1.length()) {
//                 if (valid == need.size()) {
//                     return true;
//                 }
//                 char c1 = s2.charAt(left);
//                 left++;
//                 if (need.containsKey(c1)) {
//                     if (window.get(c1).equals(need.get(c1))) {
//                         valid--;
//                     }
//                     window.put(c1, window.getOrDefault(c1, 0) - 1);
//                 }
//             }
//         }
//         return false;
//     }
// }


// Method: arrays
// Use array to store frequencies
// Space Complexity: O(1)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] s1map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] s2map = new int[26];
            for (int j = 0; j < s1.length(); j++) {
                s2map[s2.charAt(i + j) - 'a']++;
            }
            if (matches(s1map, s2map)) return true;
        }
        return false;
    }

    public boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i]) return false;
        }
        return true;
    }
}

// @lc code=end

