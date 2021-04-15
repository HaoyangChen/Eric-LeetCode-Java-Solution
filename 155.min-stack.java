/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start

// Method 1: Stack of Value / Minimum Pairs
// Time Complexity: O(1) for all operations
// Space Complexity: O(n) - worst case is that all operations are push. In this case, there will be O(n) space used.
class MinStack {
    private Stack<int[]> stack = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new int[]{val, val});
            return;
        }
        int currentMin = stack.peek()[1];
        stack.push(new int[]{val, Math.min(currentMin, val)});
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

