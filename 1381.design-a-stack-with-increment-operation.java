/*
 * @lc app=leetcode id=1381 lang=java
 *
 * [1381] Design a Stack With Increment Operation
 */

// @lc code=start

// Method 1:
// class CustomStack {
//     int[] stack;
//     int top;

//     public CustomStack(int maxSize) {
//         stack = new int[maxSize];
//         top = -1;
//     }
    
//     public void push(int x) {
//         if (top != stack.length - 1) {
//             ++top;
//             stack[top] = x;
//         }
//     }
    
//     public int pop() {
//         if (top == -1) return -1;
//         --top;
//         return stack[top + 1];
//     }
    
//     public void increment(int k, int val) {
//         int limit = Math.min(k, top + 1);
//         for (int i = 0; i < limit; ++i) {
//             stack[i] += val;
//         }
//     }
// }


// Method 2: with optimization
class CustomStack {
    int[] stack;
    int[] add;
    int top;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        add = new int[maxSize];
        top = -1;
    }
    
    public void push(int x) {
        if (top != stack.length - 1) {
            ++top;
            stack[top] = x;
        }
    }
    
    public int pop() {
        if (top == -1) return -1;
        int result = stack[top] + add[top];
        if (top != 0) {
            add[top - 1] += add[top];
        }
        add[top] = 0;
        --top;
        return result;
    }
    
    public void increment(int k, int val) {
        int limit = Math.min(k - 1, top);
        if (limit >= 0) {
            add[limit] += val;
        }
    }
}


/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
// @lc code=end

