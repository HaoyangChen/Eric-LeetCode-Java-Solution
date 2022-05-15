/*
 * @lc app=leetcode id=1024 lang=java
 *
 * [1024] Video Stitching
 */

// @lc code=start

import java.util.*;

class Solution {
    public int videoStitching(int[][] clips, int time) {
        if (time == 0) return 0;
        Arrays.sort(clips, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int result = 0, currentEnd = 0, nextEnd = 0, i = 0, n = clips.length;
        while (i < n && clips[i][0] <= currentEnd) {
            while (i < n && clips[i][0] <= currentEnd) {
                nextEnd = Math.max(nextEnd, clips[i][1]);
                i++;
            }
            result++;
            currentEnd = nextEnd;
            if (currentEnd >= time) return result;
        }
        return -1;
    }
}
// @lc code=end

