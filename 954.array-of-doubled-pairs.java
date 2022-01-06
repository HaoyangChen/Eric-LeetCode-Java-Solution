/*
 * @lc app=leetcode id=954 lang=java
 *
 * [954] Array of Doubled Pairs
 */

// @lc code=start
class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> count = new HashMap();
        for (int x: arr) count.put(x, count.getOrDefault(x, 0) + 1);
        
        Integer[] B = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) B[i] = arr[i];
        Arrays.sort(B, Comparator.comparingInt(Math::abs));
        
        for (int x: B) {
            if (count.get(x) == 0) continue;
            if (count.getOrDefault(2 * x, 0) == 0) return false;
            
            count.put(x, count.get(x) - 1);
            count.put(2 * x, count.get(2 * x) - 1);
        }
        return true;
    }
}
// @lc code=end

