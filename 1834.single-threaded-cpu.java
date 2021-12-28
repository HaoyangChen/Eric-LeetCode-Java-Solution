/*
 * @lc app=leetcode id=1834 lang=java
 *
 * [1834] Single-Threaded CPU
 */

// @lc code=start
class Solution {
    class Task {
        int id;
        int enqueueTime;
        int processingTime;
        
        public Task(int id, int enqueueTime, int processingTime) {
            this.id = id;
            this.enqueueTime = enqueueTime;
            this.processingTime = processingTime;
        }
    }
    public int[] getOrder(int[][] tasks) {
        int len = tasks.length;
        List<Task> taskList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            taskList.add(new Task(i, tasks[i][0], tasks[i][1]));
        }
        Collections.sort(taskList, (t1, t2) -> t1.enqueueTime - t2.enqueueTime);
        PriorityQueue<Task> minHeap = new PriorityQueue<>((t1, t2) -> {
            if (t1.processingTime == t2.processingTime) {
                return t1.id - t2.id;
            } else {
                return t1.processingTime - t2.processingTime;
            }
        });
        long currentTime = 0;
        int taskListIndex = 0;
        int[] result = new int[len];
        int resultIndex = 0;
        while (taskListIndex < len) {
            while (taskListIndex < len && taskList.get(taskListIndex).enqueueTime <= currentTime) {
                minHeap.offer(taskList.get(taskListIndex));
                taskListIndex++;
            }
            if (minHeap.isEmpty()) {
                currentTime = (long) taskList.get(taskListIndex).enqueueTime;
                while (taskListIndex < len && taskList.get(taskListIndex).enqueueTime <= currentTime) {
                    minHeap.offer(taskList.get(taskListIndex));
                    taskListIndex++;
                }
            }
            Task task = minHeap.poll();
            result[resultIndex++] = task.id;
            currentTime += task.processingTime;
        }
        while (!minHeap.isEmpty()) {
            result[resultIndex++] = minHeap.poll().id;
        }
        return result;
    }
}
// @lc code=end

