/*
 * @lc app=leetcode id=881 lang=java
 *
 * [881] Boats to Save People
 */

// @lc code=start
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1, ans = 0;
        while (i <= j) {
            ans++;
            if (people[i] + people[j] <= limit) i++;
            j--;
        }
        return ans;
    }
}
// @lc code=end

