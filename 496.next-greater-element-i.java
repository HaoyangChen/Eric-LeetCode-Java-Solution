/*
 * @lc app=leetcode id=496 lang=java
 *
 * [496] Next Greater Element I
 */

// @lc code=start

// Method: Monotonous Stack
// Time Complexity: O(m + n) -The entire nums2 array(of size n) is scanned only once. The stack's n elements are popped only once. The nums1 array is also scanned only once.
// Space Complexity: O(m + n) stack and map of size n is used. res array of size m is used, where n refers to the size of the nums2 array and m refers to the size of the nums1 array
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }

        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
// @lc code=end

