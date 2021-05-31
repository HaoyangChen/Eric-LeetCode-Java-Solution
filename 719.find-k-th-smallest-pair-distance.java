/*
 * @lc app=leetcode id=719 lang=java
 *
 * [719] Find K-th Smallest Pair Distance
 */

// @lc code=start
// class Solution {
//     public int smallestDistancePair(int[] nums, int k) {
//         Arrays.sort(nums);
//         PriorityQueue<Node> heap = new PriorityQueue<Node>(nums.length,
//             Comparator.<Node> comparingInt(node -> nums[node.nei] - nums[node.root]));
//         for (int i = 0; i + 1 < nums.length; ++i) {
//             heap.offer(new Node(i, i+1));
//         }

//         Node node = null;
//         for (; k > 0; --k) {
//             node = heap.poll();
//             if (node.nei + 1 < nums.length) {
//                 heap.offer(new Node(node.root, node.nei + 1));
//             }
//         }
//         return nums[node.nei] - nums[node.root];
//     }
// }
// class Node {
//     int root;
//     int nei;
//     Node(int r, int n) {
//         root = r;
//         nei = n;
//     }
// }

// Method 2: Binary Search + Sliding Window
// Time Complexity: O(NlogW+NlogN), where N is the length of nums, and WW is equal to nums[nums.length - 1] - nums[0]. 
// Space Complexity: O(1). No additional space is used except for integer variables.
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int lo = 0;
        int hi = nums[nums.length - 1] - nums[0];
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            int count = 0, left = 0;
            for (int right = 0; right < nums.length; ++right) {
                while (nums[right] - nums[left] > mi) left++;
                count += right - left;
            }
            //count = number of pairs with distance <= mi
            if (count >= k) hi = mi;
            else lo = mi + 1;
        }
        return lo;
    }
}

// @lc code=end

