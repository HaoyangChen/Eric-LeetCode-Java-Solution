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
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9]", " ").toLowerCase();
        String[] words = normalizedStr.split("\\s+");
        Set<String> bannedWords = new HashSet();
        for (String word: banned) {
            bannedWords.add(word);
        }
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word: words) {
            if (!bannedWords.contains(word)) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        return Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
// @lc code=end

