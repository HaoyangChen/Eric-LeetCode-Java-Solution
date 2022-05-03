/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start
// class Solution {
//     public List<List<Integer>> permute(int[] nums) {
//         int len = nums.length;
//         List<List<Integer>> res = new ArrayList<>();
//         if (len == 0) {
//             return res;
//         }
//         boolean[] used = new boolean[len];
//         Deque<Integer> path = new ArrayDeque<>(len);
//         dfs(nums, len, 0, path, used, res);
//         return res;
//     }

//     private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
//         if (depth == len) {
//             res.add(new ArrayList<>(path));
//             return; 
//         }
//         for (int i = 0; i < len; i++) {
//             if (!used[i]) {
//                 path.addLast(nums[i]);
//                 used[i] = true;
//                 dfs(nums, len, depth + 1, path, used, res);
//                 path.removeLast();
//                 used[i] = false;
//             }
//         }
//     }
// }

// Shangan Solution
// class Solution {
//     List<List<Integer>> result;
//     public List<List<Integer>> permute(int[] nums) {
//         result = new ArrayList<>();
//         dfs(nums, new LinkedHashSet<>());
//         return result;
//     }

//     private void dfs(int[] nums, Set<Integer> set) {
//         if (set.size() == nums.length) {
//             result.add(new ArrayList<>(set));
//             return;
//         }
//         for (int num: nums) {
//             if (set.contains(num)) {
//                 continue;
//             }
//             set.add(num);
//             dfs(nums, set);
//             set.remove(num);
//         }
//     }
// }


// class Solution {
//     public void backtrack(int n,
//                           ArrayList<Integer> nums,
//                           List<List<Integer>> output,
//                           int first) {
//       // if all integers are used up
//       if (first == n)
//         output.add(new ArrayList<Integer>(nums));
//       for (int i = first; i < n; i++) {
//         // place i-th integer first 
//         // in the current permutation
//         Collections.swap(nums, first, i);
//         // use next integers to complete the permutations
//         backtrack(n, nums, output, first + 1);
//         // backtrack
//         Collections.swap(nums, first, i);
//       }
//     }
  
//     public List<List<Integer>> permute(int[] nums) {
//       // init output list
//       List<List<Integer>> output = new LinkedList();
  
//       // convert nums into list since the output is a list of lists
//       ArrayList<Integer> nums_lst = new ArrayList<Integer>();
//       for (int num : nums)
//         nums_lst.add(num);
  
//       int n = nums.length;
//       backtrack(n, nums_lst, output, 0);
//       return output;
//     }
//   }


class Solution {
  List<List<Integer>> res = new LinkedList<>();
  
  public List<List<Integer>> permute(int[] nums) {
      LinkedList<Integer> track = new LinkedList<>();
      boolean[] used = new boolean[nums.length];
      backtrack(nums, track, used);
      return res;
  }
  
  private void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
      if (track.size() == nums.length) {
          res.add(new LinkedList(track));
          return;
      }
      for (int i = 0; i < nums.length; i++) {
          if (used[i]) continue;
          track.add(nums[i]);
          used[i] = true;
          backtrack(nums, track, used);
          track.removeLast();
          used[i] = false;
      }
  }
}



// @lc code=end

