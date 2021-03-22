/*
 * @lc app=leetcode id=692 lang=java
 *
 * [692] Top K Frequent Words
 */

// @lc code=start

// Method1: Sorting
// Time Complexity: O(NlogN) - where N is the length of words. We count the frequency of each word in O(N) time, then we sort the given word in O(NlogN) time
// Space Complexity: O(N) - the space used to store our candidates
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        List<String> candidates = new ArrayList(count.keySet());
        Collections.sort(candidates, (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                w1.compareTo(w2) : count.get(w2) - count.get(w1));
        return candidates.subList(0, k);
    }
}
// @lc code=end

