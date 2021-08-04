/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */

// @lc code=start

// Hash Set
// Time Complexity: O(N^2) because we need to traverse every position in the board, and each of the four check steps is an O(1) operation
// Space Complexity: O(N^2) because in the worst-case scenario, if the board is full, we need a hash set each with size N to store all seen numbers for each of the N rows, N columns, and N boxes, respectively
// class Solution {
//     public boolean isValidSudoku(char[][] board) {
//         int N = 9;

//         // Use hash set to record the status
//         HashSet<Character>[] rows = new HashSet[N];
//         HashSet<Character>[] cols = new HashSet[N];
//         HashSet<Character>[] boxes = new HashSet[N];
//         for (int r = 0; r < N; r++) {
//             rows[r] = new HashSet<Character>();
//             cols[r] = new HashSet<Character>();
//             boxes[r] = new HashSet<Character>();
//         }

//         for (int r = 0; r < N; r++) {
//             for (int c = 0; c < N; c++) {
//                 char val = board[r][c];

//                 // Check if the position is filled with number
//                 if (val == '.') {
//                     continue;
//                 }

//                 // Check the row
//                 if (rows[r].contains(val)) {
//                     return false;
//                 }
//                 rows[r].add(val);

//                 // Check the column
//                 if (cols[c].contains(val)) {
//                     return false;
//                 }
//                 cols[c].add(val);

//                 // Check the box
//                 int idx = (r / 3) * 3 + c / 3;
//                 if (boxes[idx].contains(val)) {
//                     return false;
//                 }
//                 boxes[idx].add(val);
//             }
//         }
//         return true;
//     }
// }


// Method 2: Array of Fixed Size
// Time Complexity: O(N^2) because we need to traverse every position in the board, and each of the four check steps is an O(1) operation
// Space Complexity: O(N^2) because we need to create 3N arrays each with size N to store all previously seen numbers for all rows, columns, and boxes
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;

        int[][] rows = new int[N][N];
        int[][] cols = new int[N][N];
        int[][] boxes = new int[N][N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (board[r][c] == '.') continue;

                int pos = board[r][c] - '1';
                if (rows[r][pos] == 1) return false;
                rows[r][pos] = 1;

                if (cols[c][pos] == 1) return false;
                cols[c][pos] = 1;

                // check the box
                int index = (r / 3) * 3 + (c / 3);
                if (boxes[index][pos] == 1) return false;
                boxes[index][pos] = 1;
            }
        }
        return true;
    }
}
// @lc code=end

