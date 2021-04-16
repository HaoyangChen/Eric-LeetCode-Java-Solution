/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start

// Method 1: Stack of Value / Minimum Pairs
// Time Complexity: O(1) for all operations
// Space Complexity: O(n) - worst case is that all operations are push. In this case, there will be O(n) space used.
// class MinStack {
//     private Stack<int[]> stack = new Stack<>();

//     /** initialize your data structure here. */
//     public MinStack() {
//     }
    
//     public void push(int val) {
//         if (stack.isEmpty()) {
//             stack.push(new int[]{val, val});
//             return;
//         }
//         int currentMin = stack.peek()[1];
//         stack.push(new int[]{val, Math.min(currentMin, val)});
//     }
    
//     public void pop() {
//         stack.pop();
//     }
    
//     public int top() {
//         return stack.peek()[0];
//     }
    
//     public int getMin() {
//         return stack.peek()[1];
//     }
// }

// Method 2: Improved Two Stacks
// Time Complexity: O(1) for all operations
// Space Complexity: O(n) - worst case is that all operations are push. In this case, there will be O(n) space used.
class MinStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<int[]> minStack = new Stack<>();
    
    
    public MinStack() { }
    
    
    public void push(int val) {
        
        // We always put the number onto the main stack.
        stack.push(val);
        
        // If the min stack is empty, or this number is smaller than
        // the top of the min stack, put it on with a count of 1.
        if (minStack.isEmpty() || val < minStack.peek()[0]) {
            minStack.push(new int[]{val, 1});
        }
        
        // Else if this number is equal to what's currently at the top
        // of the min stack, then increment the count at the top by 1.
        else if (val == minStack.peek()[0]) {
            minStack.peek()[1]++;
        }
    }
    
    
    public void pop() {
        
        // If the top of min stack is the same as the top of stack
        // then we need to decrement the count at the top by 1.
        if (stack.peek().equals(minStack.peek()[0])) {
            minStack.peek()[1]--;
        }
        
        // If the count at the top of min stack is now 0, then remove
        // that value as we're done with it.
        if (minStack.peek()[1] == 0) {
            minStack.pop();
        }
        
        // And like before, pop the top of the main stack.
        stack.pop();
    }
    
    
    public int top() {
        return stack.peek();
    }

    
    public int getMin() {
        return minStack.peek()[0];
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

