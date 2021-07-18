/*
 * @lc app=leetcode id=202 lang=java
 *
 * [202] Happy Number
 */

// @lc code=start

// Method 1: Detect Cycle with Hash Set
// Time Complexity: O(logn) - finding the next value for a given number has a cost of O(logn) because we're processing each digit in the number
// Space Complexity: O(logn) 
// class Solution {
//     private int getNext(int n) {
//         int totalSum = 0;
//         while (n > 0) {
//             int d= n % 10;
//             n = n / 10;
//             totalSum += d * d;
//         }
//         return totalSum;
//     }

//     public boolean isHappy(int n) {
//         Set<Integer> seen = new HashSet<>();
//         while (n != 1 && !seen.contains(n)) {
//             seen.add(n);
//             n = getNext(n);
//         }
//         return n == 1;
//     }
// }


// Method 2:  Floyd's Cycle-Finding Algorithm
// Time Complexity: O(logn)
// Space Complexity: O(1) we don't need a hashset to detect the cycle. The pointers require constant extra space
class Solution {
    public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }
}

// @lc code=end

