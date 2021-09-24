/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int max = 0;
//         int count = 0;
//         Set<Character> visited = new HashSet<>();
//         int len = s.length();
//         for (int i = 0; i < len; i++) {
//             char c = s.charAt(i);
//             while (visited.contains(c)) {
//                 visited.remove(s.charAt(i - count));
//                 count--;
//             }
//             visited.add(c);
//             count++;
//             max = Math.max(max, count);
//         }
//         return max;
//     }
// }

// Method 2: Sliding Window Method
// public class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int[] chars = new int[128];

//         int left = 0;
//         int right = 0;

//         int res = 0;
//         while (right < s.length()) {
//             char r = s.charAt(right);
//             chars[r]++;

//             while (chars[r] > 1) {
//                 char l = s.charAt(left);
//                 chars[l]--;
//                 left++;
//             }

//             res = Math.max(res, right - left + 1);

//             right++;
//         }
//         return res;
//     }
// }


// Method 3: Sliding Window Optimized
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int j = 0, i = 0; j < length; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}

// @lc code=end

