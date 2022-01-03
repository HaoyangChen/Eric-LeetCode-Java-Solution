/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */

// @lc code=start
// class Solution {
//     public List<List<String>> solveNQueens(int n) {
//         char[][] chess = new char[n][n];
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 chess[i][j] = '.';
//             }
//         }
//         List<List<String>> res = new ArrayList<>();
//         solve(res, chess, 0);
//         return res;
//     }

//     private void solve(List<List<String>> res, char[][] chess, int row) {
//         if (row == chess.length) {
//             res.add(construct(chess));
//             return;
//         }
//         for (int col = 0; col < chess.length; col++) {
//             if (valid(chess, row, col)) {
//                 chess[row][col] = 'Q';
//                 solve(res, chess, row + 1);
//                 chess[row][col] = '.';
//             }
//         }
//     }

//     private boolean valid(char[][] chess, int row, int col) {
//         // check if above contains queen
//         for (int i = 0; i < row; i++) {
//             if (chess[i][col] == 'Q') {
//                 return false;
//             }
//         }

//         // check if top-right contains queen
//         for (int i = row - 1, j = col + 1; i >=0 && j < chess.length; i--, j++) {
//             if (chess[i][j] == 'Q') {
//                 return false;
//             }
//         }

//         // check if top-left contains queen
//         for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
//             if (chess[i][j] == 'Q') {
//                 return false;
//             }
//         }
//         return true;
//     }

//     private List<String> construct(char[][] chess) {
//         List<String> path = new ArrayList<>();
//         for (int i = 0; i < chess.length; i++) {
//             path.add(new String(chess[i]));
//         }
//         return path;
//     }
// }

class Solution {
    private int size;
    private List<List<String>> solutions = new ArrayList<List<String>>();
    
    public List<List<String>> solveNQueens(int n) {
        size = n;
        char board[][] = new char[size][size];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), board);
        return solutions;
    }
    
    private List<String> createBoard(char[][] state) {
        List<String> board = new ArrayList<String>();
        for (int row = 0; row < size; row++) {
            String currentRow = new String(state[row]);
            board.add(currentRow);
        }
        return board;
    }
    
    private void backtrack(int row, Set<Integer> diagonals, Set<Integer> antiDiagonals, Set<Integer> cols, char[][] state) {
        if (row == size) {
            solutions.add(createBoard(state));
            return;
        }
        for (int col = 0; col < size; col++) {
            int currentDiagonal = row - col;
            int currentAntiDiagonal = row + col;
            if (cols.contains(col) || diagonals.contains(currentDiagonal) || antiDiagonals.contains(currentAntiDiagonal)) continue;
            
            cols.add(col);
            diagonals.add(currentDiagonal);
            antiDiagonals.add(currentAntiDiagonal);
            state[row][col] = 'Q';
            backtrack(row + 1, diagonals, antiDiagonals, cols, state);
            cols.remove(col);
            diagonals.remove(currentDiagonal);
            antiDiagonals.remove(currentAntiDiagonal);
            state[row][col] = '.';
            
        }
    }
}
// @lc code=end

