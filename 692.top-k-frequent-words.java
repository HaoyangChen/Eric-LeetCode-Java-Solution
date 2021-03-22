/*
 * @lc app=leetcode id=692 lang=java
 *
 * [692] Top K Frequent Words
 */

// @lc code=start

// Method1: Sorting
// Time Complexity: O(NlogN) - where N is the length of words. We count the frequency of each word in O(N) time, then we sort the given word in O(NlogN) time
// Space Complexity: O(N) - the space used to store our candidates
// class Solution {
//     public List<String> topKFrequent(String[] words, int k) {
//         Map<String, Integer> count = new HashMap();
//         for (String word: words) {
//             count.put(word, count.getOrDefault(word, 0) + 1);
//         }
//         List<String> candidates = new ArrayList(count.keySet());
//         Collections.sort(candidates, (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
//                 w1.compareTo(w2) : count.get(w2) - count.get(w1));
//         return candidates.subList(0, k);
//     }
// }

// Method 2: Heap
// Time Complexity: O(NlogK) - where N is the length of words. We count the frequency of each word in O(n) time, then we add N words to the heap, each in O(logk) time. Finally, we pop from the heap up to k times. As k <= N, this is O(Nlogk) in total.
// Space Complexity: O(N), the space complexity used to store our count.
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> heap = new PriorityQueue<String>(
            (w1, w2) -> count.get(w1).equals(count.get(w2)) ? 
            w2.compareTo(w1) : count.get(w1) - count.get(w2)
        );

        for (String word: count.keySet()) {
            heap.offer(word);
            if (heap.size() > k) heap.poll();
        }

        List<String> ans = new ArrayList();
        while (!heap.isEmpty()) ans.add(heap.poll());
        Collections.reverse(ans);
        return ans;
    }
}

// @lc code=end

