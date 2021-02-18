/*
 * @lc app=leetcode id=841 lang=java
 *
 * [841] Keys and Rooms
 */

// @lc code=start

// Shangan Solution
// class Solution {
//     public boolean canVisitAllRooms(List<List<Integer>> rooms) {
//         if (rooms == null || rooms.isEmpty()) {
//             return true;
//         }
//         Set<Integer> set = new HashSet<>(rooms.get(0));
//         set.add(0);
//         Deque<Integer> stack = new ArrayDeque<>(rooms.get(0));
        
//         while (!stack.isEmpty()) {
//             int room = stack.pop();
//             for (int key: rooms.get(room)) {
//                 if (set.contains(key)) {
//                     continue;
//                 }
//                 set.add(key);
//                 if (set.size() == rooms.size()) {
//                     return true;
//                 }
//                 stack.push(key);
//             }
//         }
//         return set.size() == rooms.size();
//     }
// }


// LeetCode Solution
// Time Complexity: O(N + E), where N is the number of rooms, and E is the total number of keys
// Space Complexity: O(N) in addtional space complexity, to store seen and stack
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] seen = new boolean[rooms.size()];
        seen[0] = true;
        Stack<Integer> stack = new Stack();
        stack.push(0);
        
        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (int nei: rooms.get(node)) {
                if (!seen[nei]) {
                    seen[nei] = true;
                    stack.push(nei);
                }
            }
        }
        
        for (boolean v: seen) {
            if (!v) return false;
        }
        return true;
    }
}
// @lc code=end

