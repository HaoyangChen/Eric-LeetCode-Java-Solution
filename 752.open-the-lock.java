/*
 * @lc app=leetcode id=752 lang=java
 *
 * [752] Open the Lock
 */

// @lc code=start
// class Solution {
//     public int openLock(String[] deadends, String target) {
//         Set<String> deads = new HashSet<>();
//         for (String s: deadends) deads.add(s);
//         Set<String> visited = new HashSet<>();
//         Queue<String> q = new LinkedList<>();
//         int step = 0;
//         q.offer("0000");
//         visited.add("0000");

//         while (!q.isEmpty()) {
//             int size = q.size();
//             for (int i = 0; i < size; i++) {
//                 String curr = q.poll();

//                 if (deads.contains(curr)) {
//                     continue;
//                 }
//                 if (curr.equals(target)) {
//                     return step;
//                 }

//                 for (int j = 0; j < 4; j++) {
//                     String up = plusOne(curr, j);
//                     if (!visited.contains(up)) {
//                         q.offer(up);
//                         visited.add(up);
//                     }
//                     String down = minusOne(curr, j);
//                     if (!visited.contains(down)) {
//                         q.offer(down);
//                         visited.add(down);
//                     }
//                 }
//             }
//             step++;
//         }
//         return -1;
//     }

//     private String plusOne(String s, int j) {
//         char[] ch = s.toCharArray();
//         if (ch[j] == '9') {
//             ch[j] = '0';
//         } else {
//             ch[j] += 1;
//         }
//         return new String(ch);
//     }

//     private String minusOne(String s, int j) {
//         char[] ch = s.toCharArray();
//         if (ch[j] == '0') {
//             ch[j] = '9';
//         } else {
//             ch[j] -= 1;
//         }
//         return new String(ch);
//     }
// }

// class Solution {
    
//     private static final String START = "0000";
//     public int openLock(String[] deadends, String target) {
//         Set<String> set = new HashSet<>(Arrays.asList(deadends));
//         if (set.contains(START)) {
//             return -1;
//         }
        
//         Queue<String> queue = new ArrayDeque<>();
//         queue.offer(START);
//         set.add(START);
//         int level = 0;
        
//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             for (int i = 0; i < size; i++) {
//                 String current = queue.poll();
//                 if (target.equals(current)) {
//                     return level;
//                 }

//                 for (String next : nextLocks(current)) {
//                     if (!set.contains(next)) {
//                         set.add(next);
//                         queue.offer(next);
//                     }
//                 }
//             }
//             level++;
//         }
        
//         return -1;
//     }
    
//     private List<String> nextLocks(String lock) {
//         List<String> locks = new ArrayList<>();
//         char[] arr = lock.toCharArray();
//         char c;
//         for (int i = 0; i < arr.length; i++) {
//             c = arr[i];
//             arr[i] = c == '9' ? '0' : (char) (c + ((char) 1));
//             locks.add(new String(arr));
            
//             arr[i] = c == '0' ? '9' : (char) (c - ((char) 1));
//             locks.add(new String(arr));
            
//             arr[i] = c;
//         }
//         return locks;
//     }
// }


// Method: Breath-first Search
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet();
        for (String d: deadends) dead.add(d);
        Queue<String> queue = new LinkedList();
        queue.offer("0000");
        queue.offer(null);

        Set<String> seen = new HashSet();
        seen.add("0000");
        int depth = 0;
        while (!queue.isEmpty()) {
            String node = queue.poll();
            if (node == null) {
                depth++;
                if (queue.peek() != null) {
                    queue.offer(null);
                }
            } else if (node.equals(target)) {
                return depth;
            } else if (!dead.contains(node)) {
                for (int i = 0; i < 4; ++i) {
                    for (int d = -1; d <= 1; d +=2) {
                        int y = ((node.charAt(i) - '0') + d + 10) % 10;
                        String nei = node.substring(0, i) + ("" + y) + node.substring(i + 1);
                        if (!seen.contains(nei)) {
                            seen.add(nei);
                            queue.offer(nei);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
// @lc code=end

