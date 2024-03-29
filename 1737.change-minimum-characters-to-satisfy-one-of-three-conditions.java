/*
 * @lc app=leetcode id=1737 lang=java
 *
 * [1737] Change Minimum Characters to Satisfy One of Three Conditions
 */

// @lc code=start
class Solution {
    public int minCharacters(String a, String b) {
        int m = a.length();
        int n = b.length();

        // 统计字符数量
        int[] countA = new int[26];
        int[] countB = new int[26];
        for (char c : a.toCharArray()) {
            countA[c - 'a']++;
        }
        for (char c : b.toCharArray()) {
            countB[c - 'a']++;
        }

        // 前缀和preA[i]记录字符串a中<=('a'+i)的字符数
        int[] preA = new int[26];
        for (int i = 0; i < 26; i++) {
            preA[i] = i == 0 ? countA[0] : preA[i - 1] + countA[i];
        }
        // 前缀和preB[i]记录字符串b中<=('a'+i)的字符数
        int[] preB = new int[26];
        for (int i = 0; i < 26; i++) {
            preB[i] = i == 0 ? countB[0] : preB[i - 1] + countB[i];
        }

        // 遍历“分割字符”，收集答案
        int ans = Integer.MAX_VALUE;
        for (char i = 0; i < 26; i++) {
            // 当前分割字符c = 'a'+i
            if (i != 25) {
                // a中全部变成>c, b中全部变成<=c，需要的操作次数
                ans = Math.min(ans, preA[i] + (n - preB[i]));
                // b中全部变成>c, a中全部<=c
                ans = Math.min(ans, (m - preA[i]) + preB[i]);
            }

            // 都转成字符'a'+i，需要的操作次数
            int notEq1 = m - countA[i];
            int notEq2 = n - countB[i];
            ans = Math.min(ans, notEq1 + notEq2);
        }
        return ans;
    }
}
// @lc code=end

