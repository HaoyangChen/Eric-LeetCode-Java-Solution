/*
 * @lc app=leetcode id=986 lang=java
 *
 * [986] Interval List Intersections
 */

// @lc code=start

// Time Complexity: O(M + N) where M and N are the lengths of A and B respectively
// Space Complexity: O(M + N) which is the maximum size of the answer
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ans = new ArrayList();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int lowValue = Math.max(firstList[i][0], secondList[j][0]);
            int highValue = Math.min(firstList[i][1], secondList[j][1]);
            if (lowValue <= highValue) {
                ans.add(new int[]{lowValue, highValue});
            }
            
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
// @lc code=end

