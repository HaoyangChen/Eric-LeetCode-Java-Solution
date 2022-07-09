/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int upper_bound = 0, lower_bound = m - 1;
        int left_bound = 0, right_bound = n - 1;
        List<Integer> result = new LinkedList<>();
        while (result.size() < m * n) {
            if (upper_bound <= lower_bound) {
                for (int j = left_bound; j <= right_bound; j++) {
                    result.add(matrix[upper_bound][j]);
                }                
                upper_bound++;
            }
            
            if (left_bound <= right_bound) {
                for (int i = upper_bound; i <= lower_bound; i++) {
                    result.add(matrix[i][right_bound]);
                }
                right_bound--;
            }
            
            if (upper_bound <= lower_bound) {
                for (int j = right_bound; j >= left_bound; j--) {
                    result.add(matrix[lower_bound][j]);
                }
                lower_bound--;
            }
            
            if (left_bound <= right_bound) {
                for (int i = lower_bound; i >= upper_bound; i--) {
                    result.add(matrix[i][left_bound]);
                }
                left_bound++;
            }
        }
        return result;
    }
}
// @lc code=end

