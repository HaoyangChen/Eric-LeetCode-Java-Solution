/*
 * @lc app=leetcode id=374 lang=java
 *
 * [374] Guess Number Higher or Lower
 */

// @lc code=start
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */


 // Method: Binary Search
 // Time Complexity: O(logN) Binary search is used
 // Space Complexity: O(1) No extra space is used
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = guess(mid);
            if (res < 0) {
                high = mid - 1;
            } else if (res == 0) {
                return mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
// @lc code=end

