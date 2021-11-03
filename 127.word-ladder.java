/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start
// Shangan Solution
// class Solution {
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//         Set<String> dict = new HashSet<>(wordList);
//         if (!dict.contains(endWord)) {
//             return 0;
//         } 
//         Queue<String> queue = new ArrayDeque<>();
//         queue.offer(beginWord);

//         int level = 1;
//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             for (int i = 0; i < size; i++) {
//                 String word = queue.poll();
//                 if (Objects.equals(word, endWord)) {
//                     return level;
//                 }
//                 int len = word.length();
//                 for (int j = 0; j < len; j++) {
//                     char[] array = word.toCharArray();
//                     for (int k = 0; k < 26; k++) {
//                         array[j] = (char)('a' + k);
//                         String newWord = new String(array);
//                         if (dict.contains(newWord)) {
//                             queue.offer(newWord);
//                             dict.remove(newWord);
//                         }
//                     }
//                 }
//             }
//             level++;
//         }
//         return 0;
//     }
// }

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int beginWordLength = beginWord.length();
        Map<String, List<String>> combinationMap = new HashMap<>();
        wordList.forEach(
            word -> {
                for (int i = 0; i < beginWordLength; i++) {
                    String genericWord = word.substring(0, i) + '*' + word.substring(i + 1, beginWordLength);
                    List<String> matchedWordList = combinationMap.getOrDefault(genericWord, new ArrayList<>());
                    matchedWordList.add(word);
                    combinationMap.put(genericWord, matchedWordList);
                }
            }
        );
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));
        
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < beginWordLength; i++) {
                String genericWord = word.substring(0, i) + '*' + word.substring(i + 1, beginWordLength);
                for (String matchedWord: combinationMap.getOrDefault(genericWord, new ArrayList<>())) {
                    if (matchedWord.equals(endWord)) return level + 1;
                    
                    if (!visited.containsKey(matchedWord)) {
                        visited.put(matchedWord, true);
                        queue.add(new Pair(matchedWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }
}
// @lc code=end

