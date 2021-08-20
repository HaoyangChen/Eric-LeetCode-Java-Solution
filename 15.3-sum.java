/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start

// Method: Two Pointers
// Time Complexity: O(n^2)
// Space Complexity: from O(logn) to O(n), depending on the implementation of the sorting algorithm. For the purpose of complexity analysis, we ignore the memory required for the output.
// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         Arrays.sort(nums);
//         List<List<Integer>> res= new ArrayList<>();
//         for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
//             if (i == 0 || nums[i - 1] != nums[i]) {
//                 twoSumII(nums, i, res);
//             }
//         }
//         return res;
//     }

//     void twoSumII(int[] nums, int i, List<List<Integer>> res) {
//         int lo = i + 1, hi = nums.length - 1;
//         while (lo < hi) {
//             int sum = nums[i] + nums[lo] + nums[hi];
//             if (sum < 0) {
//                 ++lo;
//             } else if (sum > 0) {
//                 hi--;
//             } else {
//                 res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
//                 while (lo < hi && nums[lo] == nums[lo - 1]) {
//                     lo++;
//                 }
//             }
//         }
//     }
// }

// Method 2: HashSet
// Time Complexity: O(n ^ 2), twoSum is O(n) and we call it n times.
// Space Complexity: O(n) for the hashset
// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         Arrays.sort(nums);
//         List<List<Integer>> res = new ArrayList<>();
//         for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
//             if (i == 0 || nums[i - 1] != nums[i]) {
//                 twoSum(nums, i, res);
//             }
//         }
//         return res;
//     }

//     void twoSum(int[] nums, int i, List<List<Integer>> res) {
//         var seen = new HashSet<Integer>();
//         for (int j = i + 1; j < nums.length; j++) {
//             int complement = -nums[i] - nums[j];
//             if (seen.contains(complement)) {
//                 res.add(Arrays.asList(nums[i], nums[j], complement));
//                 while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
//                     ++j;
//                 }
//             }
//             seen.add(nums[j]);
//         }
//     }
// }

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Set<Integer> dups = new HashSet<>();
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; ++i)
            if (dups.add(nums[i])) {
                for (int j = i + 1; j < nums.length; ++j) {
                    int complement = -nums[i] - nums[j];
                    if (seen.containsKey(complement) && seen.get(complement) == i) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                        Collections.sort(triplet);
                        res.add(triplet);
                    }
                    seen.put(nums[j], i);
                }
            }
        return new ArrayList(res);
    }
}
// @lc code=end

