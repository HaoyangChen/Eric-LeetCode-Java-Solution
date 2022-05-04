/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */

// @lc code=start
// class Solution {
//     List<List<Integer>> result = new LinkedList<>();
//     int n;
//     int k;

//     public List<List<Integer>> combine(int n, int k) {
//         this.n = n;
//         this.k = k;
//         backtrack(1, new LinkedList<Integer>());
//         return result;
//     }

//     private void backtrack(int first, LinkedList<Integer> curr) {
//         if (curr.size() == k) {
//             result.add(new LinkedList<>(curr));
//         }
//         for (int i = first; i < n + 1; i++) {
//             curr.add(i);
//             backtrack(i + 1, curr);
//             curr.removeLast();
//         }
//     }
// }


class Solution {
    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    
    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k);
        return result;
    }
    
    private void backtrack(int start, int n, int k) {
        if (track.size() == k) {
            result.add(new LinkedList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            track.addLast(i);
            backtrack(i + 1, n, k);
            track.removeLast();
        }
    }
}
// @lc code=end

