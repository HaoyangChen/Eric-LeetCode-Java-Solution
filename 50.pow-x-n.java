/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start

// Method 1: Brute Force (Exceed Time Limit)
// class Solution {
//     public double myPow(double x, int n) {
//         long N = n;
//         if (N < 0) {
//             x = 1 / x;
//             N = -N;
//         }
//         double ans = 1;
//         for (long i = 0; i < N; i++)
//             ans = ans * x;
//         return ans;
//     }
// };

// Method 2: Fast Power Algorithm Recursive
// Time Complexity: O(logn)
// Space Complexity: O(logn)
// class Solution {
//     public double myPow(double x, int n) {
//         long N = n;
//         if (N < 0) {
//             x = 1 / x;
//             N = -N;
//         }
//         return fastPow(x, N);
//     }

//     private double fastPow (double x, long n) {
//         if (n == 0) return 1.0;
//         double half = fastPow(x, n / 2);
//         if (n % 2 == 0) {
//             return half * half;
//         } else {
//             return half * half * x;
//         }
//     }
// }


// Method 3: Fast Power Algorithm Iterative
// Time Complexity: O(logn)
// Space Complexity: O(1), we only need two variables for the current product and the final result of x
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double current_product = x;
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                ans = ans * current_product;
            }
            current_product = current_product * current_product;
        }
        return ans;
    }
};

// @lc code=end

