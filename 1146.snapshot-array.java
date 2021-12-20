/*
 * @lc app=leetcode id=1146 lang=java
 *
 * [1146] Snapshot Array
 */

// @lc code=start
class SnapshotArray {
    TreeMap<Integer, Integer>[] record;
    int snapId = 0;
    
    public SnapshotArray(int length) {
        record = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            record[i] = new TreeMap<Integer, Integer>();
            record[i].put(0, 0);
        }
    }
    
    public void set(int index, int val) {
        record[index].put(snapId, val);
    }
    
    public int snap() {
        return snapId++;
    }
    
    public int get(int index, int snap_id) {
        return record[index].floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
// @lc code=end

