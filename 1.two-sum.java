/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         Map<Integer, Integer> map = new HashMap();
//         for (int i = 0; i < nums.length; i++) {
//             int complement = target - nums[i];
//             if (map.containsKey(complement)) {
//                 return new int[] {map.get(complement), i};
//             }
//             map.put(nums[i], i);
//         }
//         throw new IllegalArgumentException("No two sum solution");
//     }
// }

// Shangan Solution
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null) {
            return null;
        }
        Integer[] indexArray = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indexArray[i] = i;
        }
        Arrays.sort(indexArray, (i1, i2) -> Integer.compare(nums[i1], nums[i2]));
        int left = 0;
        int right = indexArray.length - 1;
        
        while (left < right) {
            if (nums[indexArray[left]] + nums[indexArray[right]] == target) {
                return new int[]{indexArray[left], indexArray[right]};
            }
            if (nums[indexArray[left]] + nums[indexArray[right]] < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }
}
// @lc code=end

