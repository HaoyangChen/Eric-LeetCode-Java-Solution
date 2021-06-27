/*
 * @lc app=leetcode id=1007 lang=java
 *
 * [1007] Minimum Domino Rotations For Equal Row
 */

// @lc code=start

// Method 1: Greedy
// Time Complexity:  O(N) since here one iterates over the arrays not more than two times
// Space Complexity: O(1) since this is a constant space solution
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int rotations = check(tops[0], bottoms, tops, n);
        if (rotations != -1 || tops[0] == bottoms[0]) return rotations;
        else return check(bottoms[0], bottoms, tops, n);
    }

    public int check(int x, int[] tops, int[] bottoms, int n) {
        int rotation_a = 0, rotation_b = 0;
        for (int i = 0; i < n; i++) {
            if (tops[i] != x && bottoms[i] != x) return -1;
            else if (tops[i] != x) rotation_a++;
            else if (bottoms[i] != x) rotation_b++;
        }
        return Math.min(rotation_a, rotation_b);
    }
}
// @lc code=end

