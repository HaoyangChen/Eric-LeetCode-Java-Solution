/*
 * @lc app=leetcode id=295 lang=java
 *
 * [295] Find Median from Data Stream
 */

// @lc code=start


// Two Heaps
// Time Complexity: O(logn) - at worst, there are 3 heap insertions and two heap deletions from the top. Each of these takes about O(logn) time
// Space Complexity: O(n) - Linear space to to hold input in containers
class MedianFinder {
    private int count;
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        count = 0;
        maxHeap = new PriorityQueue<>((x, y) -> y - x);
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        count += 1;
        maxHeap.offer(num);
        minHeap.add(maxHeap.poll());
        if ((count & 1) != 0) {
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if ((count & 1) == 0) {
            return (double)(minHeap.peek() + maxHeap.peek()) / 2;
        } else {
            return (double) maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end

