/*
 * @lc app=leetcode id=119 lang=java
 *
 * [119] Pascal's Triangle II
 */

// @lc code=start

// Method 1: Brute Force Recursion
// class Solution {
//     public List<Integer> getRow(int rowIndex) {
//         List<Integer> ans = new ArrayList<>();
//         for (int i = 0; i <= rowIndex; i++) {
//             ans.add(getNum(rowIndex, i));
//         }
//         return ans;
//     }

//     private int getNum(int row, int col) {
//         if (row == 0 || col == 0 || row == col) {
//             return 1;
//         }
//         return getNum(row - 1, col - 1) + getNum(row - 1, col);
//     }
// }

// Method 2: Memory Efficient Dynamic Programming
// Time Complexity: O(k^2)
// Space Complexity: O(k) - no extra space is used other than that required to hold the output
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>(rowIndex + 1) {
            {add(1);};
        };
        for (int i = 0; i < rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            row.add(1);
        }
        return row;
    }
}
// @lc code=end

