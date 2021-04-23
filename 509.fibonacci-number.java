/*
 * @lc app=leetcode id=509 lang=java
 *
 * [509] Fibonacci Number
 */

// @lc code=start

// Method: Iterative Top-Down Approach
// Time Complexity: O(n). Each value from 2 to n will be visited at least once. The time it takes to do so directly proportionate to n where n is the fibonacci number we are loooking to compute.
// Space Compelxity: O(1). This requires 1 unit of space for the integer N and 3 units of space to store the computed values (curr, prev1, and prev2) for each loop iteration. The amount of space does not change so it is constant space complexity.
// class Solution {
//     public int fib(int n) {
//         if (n <= 1) return n;
//         if (n == 2) return 1;
//         int current = 0;
//         int prev1 = 1;
//         int prev2 = 1;
//         for (int i = 3; i <= n; i++) {
//             current = prev1 + prev2;
//             prev2 = prev1;
//             prev1 = current;
//         }
//         return current;
//     }
// }

// Method 2: Bottom-Up Approach using Memorization
// Time Complexity: O(N) Each number, starting at 2 up to and including N, is visited, computed and then stored for O(1)
// Space Complexity: O(N) The size of the data structure is proportionate to N
// class Solution {
//     public int fib(int N) {
//         if (N <= 1) return N;
//         return memorize(N);
//     }

//     public int memorize(int N) {
//         int[] cache = new int[N + 1];
//         cache[1] = 1;
//         for (int i = 2; i <= N; i++) {
//             cache[i] = cache[i - 1] + cache[i - 2];
//         }
//         return cache[N];
//     }
// }

// Method 3: Top-Down Approach using Memorization
// Time Complexity: O(N) Each number, starting at 2 up to and including N, is visited, computed and then stored for O(1) access later on
// Space Complexity: O(N) The size of the stack in memory is proportionate to N
class Solution {
    private Integer[] cache = new Integer[31];
    public int fib(int N) {
        if (N <= 1) return N;
        cache[0] = 0;
        cache[1] = 1;
        return memorize(N);
    }

    public int memorize(int N) {
        if (cache[N] != null) return cache[N];
        cache[N] = memorize(N - 1) + memorize(N - 2);
        return memorize(N);
    }
}

// @lc code=end

