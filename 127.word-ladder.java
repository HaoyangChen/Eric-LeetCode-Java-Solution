/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start
// Shangan Solution
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        } 
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);

        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (Objects.equals(word, endWord)) {
                    return level;
                }
                int len = word.length();
                for (int j = 0; j < len; j++) {
                    char[] array = word.toCharArray();
                    for (int k = 0; k < 26; k++) {
                        array[j] = (char)('a' + k);
                        String newWord = new String(array);
                        if (dict.contains(newWord)) {
                            queue.offer(newWord);
                            dict.remove(newWord);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
// @lc code=end

