/*
 * @lc app=leetcode id=901 lang=java
 *
 * [901] Online Stock Span
 */

// @lc code=start

// Push every pair of <price, result> to a stack.
// Pop lower price from the stack and accumulate the count.

// One price will be pushed once and popped once.
// So 2 * N times stack operations and N times calls.
// class StockSpanner {
//     Stack<int[]> stack = new Stack<>();

//     public StockSpanner() {
//     }
    
//     public int next(int price) {
//         int res = 1;
//         while (!stack.isEmpty() && stack.peek()[0] <= price) {
//             res += stack.pop()[1];
//         }
//         stack.push(new int[]{price, res});
//         return res;
//     }
// }

class StockSpanner {
    Stack<Integer> prices, weights;

    public StockSpanner() {
        prices = new Stack();
        weights = new Stack();
    }

    public int next(int price) {
        int w = 1;
        while (!prices.isEmpty() && prices.peek() <= price) {
            prices.pop();
            w += weights.pop();
        }

        prices.push(price);
        weights.push(w);
        return w;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
// @lc code=end

