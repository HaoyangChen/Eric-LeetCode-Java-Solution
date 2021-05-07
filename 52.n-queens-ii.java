/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 */

// @lc code=start

// Method: Backtracking
// Time Complexity: O(N!)
// Space Complexity: O(N), where N is the number of queens (which is the same as the width and height of the board)
class Solution {
    private int size;

    public int totalNQueens(int n) {
        size = n;
        return backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }

    private int backtrack(int row, Set<Integer> diagonals, Set<Integer> antiDiagonals, Set<Integer> cols) {
        if (row == size) {
            return 1;
        }
        int solutions = 0;
        for (int col = 0; col < size; col++) {
            int currDiagnal = row - col;
            int currAntiDiagnal = row + col;
            if (cols.contains(col) || diagonals.contains(currDiagnal) || antiDiagonals.contains(currAntiDiagnal)) {
                continue;
            }
            cols.add(col);
            diagonals.add(currDiagnal);
            antiDiagonals.add(currAntiDiagnal);
            solutions += backtrack(row + 1, diagonals, antiDiagonals, cols);
            cols.remove(col);
            diagonals.remove(currDiagnal);
            antiDiagonals.remove(currAntiDiagnal);
        }
        return solutions;
    }
}
// @lc code=end

