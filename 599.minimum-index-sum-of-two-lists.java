/*
 * @lc app=leetcode id=599 lang=java
 *
 * [599] Minimum Index Sum of Two Lists
 */

// @lc code=start

// Method: Using HashMap (linear)
// Time Complexity: O(l1 + l2) Every item of list2 is checked in a map of list1. l1 and l2 are the lengths of list1 and list2 respectively
// Space Complexity: O(l1 * x) hashmap size grows upto l1 * x, where x refers to average string length
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        List<String> result = new ArrayList<>();
        int min_sum = Integer.MAX_VALUE, sum;

        for (int j = 0; j < list2.length && j <= min_sum; j++) {
            if (map.containsKey(list2[j])) {
                sum = j + map.get(list2[j]);
                if (sum < min_sum) {
                    result.clear();
                    result.add(list2[j]);
                    min_sum = sum;
                } else if (sum == min_sum) {
                    result.add(list2[j]);
                }
            }
        }
        return result.toArray(new String[result.size()]);
    }
}
// @lc code=end

