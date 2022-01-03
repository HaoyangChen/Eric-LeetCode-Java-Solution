/*
 * @lc app=leetcode id=1293 lang=java
 *
 * [1293] Shortest Path in a Grid with Obstacles Elimination
 */

// @lc code=start
class StepState {
    public int steps, row, col, k;
    
     public StepState(int steps, int row, int col, int k) {
        this.steps = steps;
        this.row = row;
        this.col = col;
        this.k = k;
    }
    
    @Override
    public int hashCode() {
        // needed when we put objects into any container class
        return (this.row + 1) * (this.col + 1) * this.k;
    }
    
    @Override
    public boolean equals(Object other) {
        /**
         * only (row, col, k) matters as the state info
         */
        if (!(other instanceof StepState)) {
            return false;
        }
        StepState newState = (StepState) other;
        return (this.row == newState.row) && (this.col == newState.col) && (this.k == newState.k);
    }
}

class Solution {
    public int shortestPath(int[][] grid, int k) {
        int rows = grid.length, cols = grid[0].length;
        int[] target = {rows - 1, cols - 1};
        
        if (k >= rows + cols - 2) {
            return rows + cols - 2;
        }
        
        Deque<StepState> queue = new LinkedList<>();
        HashSet<StepState> seen = new HashSet<>();
        
        StepState start = new StepState(0, 0, 0, k);
        queue.addLast(start);
        seen.add(start);
        
        while (!queue.isEmpty()) {
            StepState curr = queue.pollFirst();
            if (target[0] == curr.row && target[1] == curr.col) {
                return curr.steps;
            }
            int[] nextSteps = {curr.row, curr.col + 1, curr.row + 1, curr.col, curr.row + 1, curr.col, curr.row, curr.col - 1, curr.row - 1, curr.col};
            for (int i = 0; i < nextSteps.length; i += 2) {
                int nextRow = nextSteps[i];
                int nextCol = nextSteps[i + 1];
                
                if (nextRow < 0 || nextRow == rows || nextCol < 0 || nextCol == cols) continue;
                int nextElimination = curr.k - grid[nextRow][nextCol];
                StepState newState = new StepState(curr.steps + 1, nextRow, nextCol, nextElimination);
                
                if (nextElimination >= 0 && !seen.contains(newState)) {
                    seen.add(newState);
                    queue.addLast(newState);
                }
            }
        }
        return -1;
    }
}
// @lc code=end

