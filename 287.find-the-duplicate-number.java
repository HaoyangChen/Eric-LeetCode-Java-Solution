/*
 * @lc app=leetcode id=287 lang=java
 *
 * [287] Find the Duplicate Number
 */

// @lc code=start
// Method 1: Sorting
// Time Complexity: O(nlogn) - The sort invocation costs O(nlogn) time in python and java, so it dominates the subsequent linear scan
// Space Complexity: O(1) (or O(n)) - We sort the nums in place, so the memory footprint is constant. If we cannot modify the input array, then we must allocate linear space for a copy of nums and sort that instead.
// class Solution {
//     public int findDuplicate(int[] nums) {
//         Arrays.sort(nums);
//         for (int i = 1; i < nums.length; i++) {
//             if (nums[i] == nums[i - 1]) {
//                 return nums[i - 1];
//             }
//         }
//         return -1;
//     }
// }


// Method 2: Set
// Time Complexity: O(n) - set in both Python and java rely on underlying hashtables, so insertions and lookup have amortized constant time complexities. The algorithm is therefore linear, as it consists of a for loop that performs constant work n times.
// Space Complexity: O(n) - in the worst case the duplicate element appears twice, with one of its appearances at array index n - 1. Seen will contain n - 1 distinct values, and will therefore occupy O(n) space.
// class Solution {
//     public int findDuplicate(int[] nums) {
//         Set<Integer> seen = new HashSet<Integer>();
//         for (int num: nums) {
//             if (seen.contains(num)) {
//                 return num;
//             }
//             seen.add(num);
//         }
//         return -1;
//     }
// }

// Method 3: Floyd's Tortoise and Hare (Cycle Detection)
// Time Complexity: O(n)
// Space Complexity: O(1)

// class Solution {
//     public int findDuplicate(int[] nums) {
//         int tortoise = nums[0];
//         int hare = nums[0];
//         do {
//             tortoise = nums[tortoise];
//             hare = nums[nums[hare]];
//         } while (tortoise != hare);

//         tortoise = nums[0];
//         while (tortoise != hare) {
//             tortoise = nums[tortoise];
//             hare = nums[hare];
//         }
//         return hare;
//     }
// }


// Method 4: Binary Search
class Solution {
    public int findDuplicate(int[] nums) {
        int low = 1, high = nums.length - 1;
        while (low <= high) {
            int mid = (int) (low + (high - low) * 0.5);
            int cnt = 0;
            for (int a : nums) {
                if (a <= mid) ++cnt;
            }
            if (cnt <= mid) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
}
// @lc code=end

