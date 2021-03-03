/*
 * @lc app=leetcode id=819 lang=java
 *
 * [819] Most Common Word
 */

// @lc code=start

// Approach 1: String Processing in Pipeline
// Let N be the number of characters in the input string and M be the number of characters in the banned list.
// Time Complexity: O(N + M)
// Space Complexity: O(N + M)
// class Solution {
//     public String mostCommonWord(String paragraph, String[] banned) {
//         String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9]", " ").toLowerCase();
//         String[] words = normalizedStr.split("\\s+");
//         Set<String> bannedWords = new HashSet();
//         for (String word: banned) {
//             bannedWords.add(word);
//         }
//         Map<String, Integer> wordCount = new HashMap<>();
//         for (String word: words) {
//             if (!bannedWords.contains(word)) {
//                 wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
//             }
//         }
//         return Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();
//     }
// }

// Character Processing in One-Pass
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedWords = new HashSet();
        for (String word: banned) {
            bannedWords.add(word);
        }

        String ans = "";
        int maxCount = 0;
        Map<String, Integer> wordCount = new HashMap();
        StringBuilder wordBuffer = new StringBuilder();
        char[] chars = paragraph.toCharArray();

        for (int p = 0; p < chars.length; p++) {
            char currChar = chars[p];
            // 1). consume the character in a word
            if (Character.isLetter(currChar)) {
                wordBuffer.append(Character.toLowerCase(currChar));
                if (p != chars.length - 1) {
                    // skip the rest of processing
                    continue;
                }
            }
            // 2). at the end of one word or at the end of paragraph
            if (wordBuffer.length() > 0) {
                String word = wordBuffer.toString();
                if (!bannedWords.contains(word)) {
                    int newCount = wordCount.getOrDefault(word, 0) + 1;
                    wordCount.put(word, newCount);
                    // identify the maximum count while updating the wordCount table
                    if (newCount > maxCount) {
                        ans = word;
                        maxCount = newCount;
                    }
                }
            }
            // reset the buffer for the next word
            wordBuffer = new StringBuilder();
        }
        return ans;
    }
}

// @lc code=end

