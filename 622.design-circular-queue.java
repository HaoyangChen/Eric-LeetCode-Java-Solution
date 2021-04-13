/*
 * @lc app=leetcode id=622 lang=java
 *
 * [622] Design Circular Queue
 */

// @lc code=start
// Method 1: Array
// Time Complexity: O(1). All of the methods in our circular data structure is of constant time complexity
// Space Complexity: O(N) -  The overall space complexity of the data structure is linear, where N is the pre-assigned capacity of the queue.
class MyCircularQueue {
    private int[] queue;
    private int headindex;
    private int count;
    private int capacity;
    
    public MyCircularQueue(int k) {
        this.capacity = k;
        this.queue = new int[k];
        this.headindex = 0;
        this.count = 0;
    }
    
    public boolean enQueue(int value) {
        if (this.count == this.capacity) {
            return false;
        }
        this.queue[(this.headindex + this.count) % this.capacity] = value;
        this.count += 1;
        return true;
    }
    
    public boolean deQueue() {
        if (this.count == 0) return false;
        this.headindex = (this.headindex + 1) % this.capacity;
        this.count -= 1;
        return true;
    }
    
    public int Front() {
        if (this.count == 0) return -1;
        return this.queue[this.headindex];
    }
    
    public int Rear() {
        if (this.count == 0) return -1;
        int tailIndex = (this.headindex + this.count - 1) % this.capacity;
        return this.queue[tailIndex];
    }
    
    public boolean isEmpty() {
        return (this.count == 0);
    }
    
    public boolean isFull() {
        return (this.count == this.capacity);
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
// @lc code=end

