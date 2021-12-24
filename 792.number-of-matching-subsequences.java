/*
 * @lc app=leetcode id=792 lang=java
 *
 * [792] Number of Matching Subsequences
 */

// @lc code=start
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int answer = 0;
        ArrayList<Node>[] heads = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            heads[i] = new ArrayList<Node>();
        }
        for (String word: words) {
            heads[word.charAt(0) - 'a'].add(new Node(word, 0));
        }
        for (char c: s.toCharArray()) {
            ArrayList<Node> oldBucket = heads[c - 'a'];
            heads[c - 'a'] = new ArrayList<Node>();
            for (Node node: oldBucket) {
                node.index++;
                if (node.index == node.word.length()) {
                    answer++;
                } else {
                    heads[node.word.charAt(node.index) - 'a'].add(node);
                }
            }
            oldBucket.clear();
        }
        return answer;
    }
}

class Node {
    String word;
    int index;
    public Node(String w, int i) {
        word = w;
        index = i;
    }
}
// @lc code=end

