/*
 * @lc app=leetcode id=729 lang=java
 *
 * [729] My Calendar I
 */

// @lc code=start
import java.util.*;

class MyCalendar {
    
    TreeMap<Integer, Integer> calendar;
    
    public MyCalendar() {
        calendar = new TreeMap();    
    }
    
    public boolean book(int start, int end) {
         Integer prev = calendar.floorKey(start), next = calendar.ceilingKey(start);
         if ((prev == null || calendar.get(prev) <= start) && (next == null || end <= next)) {
             calendar.put(start, end);
             return true;
         }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
// @lc code=end

