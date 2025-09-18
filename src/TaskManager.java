import java.util.*;

class TaskManager {
    MaxHeap maxHeap;
    public TaskManager(List<List<Integer>> tasks) {
        maxHeap= new MaxHeap();
        for(List<Integer> list:tasks){
            maxHeap.insert(list.get(0),list.get(1),list.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        maxHeap.insert(userId, taskId, priority);
    }

    public void edit(int taskId, int newPriority) {
        maxHeap.updatePriority(taskId, newPriority);
    }

    public void rmv(int taskId) {
        maxHeap.remove(taskId);
    }

    public int execTop() {
        MaxHeap.Task task= maxHeap.extractMax();
        if(task==null) return -1;
        return task.userId;
    }




    public class MaxHeap {
        public static class Task {
            int userId;
            int taskId;
            int priority;

            Task(int userId, int taskId, int priority) {
                this.userId = userId;
                this.taskId = taskId;
                this.priority = priority;
            }

            @Override
            public String toString() {
                return "(user:" + userId + ", task:" + taskId + ", priority:" + priority + ")";
            }
        }

        private final List<Task> heap;
        private final Map<Integer, Integer> indexMap; // taskId -> index

        public MaxHeap() {
            heap = new ArrayList<>();
            indexMap = new HashMap<>();
        }

        private void swap(int i, int j) {
            Task ti = heap.get(i);
            Task tj = heap.get(j);

            heap.set(i, tj);
            heap.set(j, ti);

            indexMap.put(ti.taskId, j);
            indexMap.put(tj.taskId, i);
        }

        /** Comparison: priority first (higher wins), then taskId (higher wins) */
        private boolean greater(Task a, Task b) {
            if (a.priority != b.priority) {
                return a.priority > b.priority;
            }
            return a.taskId > b.taskId;
        }

        private void bubbleUp(int i) {
            while (i > 0) {
                int parent = (i - 1) / 2;
                if (greater(heap.get(i), heap.get(parent))) {
                    swap(i, parent);
                    i = parent;
                } else break;
            }
        }

        private void heapifyDown(int i) {
            int n = heap.size();
            while (true) {
                int left = 2 * i + 1;
                int right = 2 * i + 2;
                int largest = i;

                if (left < n && greater(heap.get(left), heap.get(largest))) {
                    largest = left;
                }
                if (right < n && greater(heap.get(right), heap.get(largest))) {
                    largest = right;
                }

                if (largest != i) {
                    swap(i, largest);
                    i = largest;
                } else break;
            }
        }

        /** Insert new task */
        public void insert(int userId, int taskId, int priority) {
            if (indexMap.containsKey(taskId)) {
                throw new IllegalArgumentException("TaskId already exists: " + taskId);
            }
            Task task = new Task(userId, taskId, priority);
            heap.add(task);
            int idx = heap.size() - 1;
            indexMap.put(taskId, idx);
            bubbleUp(idx);
        }

        /** Peek task with highest priority (and highest taskId in tie) */
        public Task peekMax() {
            if (heap.isEmpty()) return null;
            return heap.get(0);
        }

        /** Remove a task by taskId */
        public Task remove(int taskId) {
            if (!indexMap.containsKey(taskId)) {
                throw new NoSuchElementException("TaskId not found: " + taskId);
            }

            int idx = indexMap.get(taskId);
            Task removedTask = heap.get(idx);
            Task last = heap.remove(heap.size() - 1);
            indexMap.remove(taskId);

            if (idx < heap.size()) { // if not removing last element
                heap.set(idx, last);
                indexMap.put(last.taskId, idx);

                // fix heap property
                bubbleUp(idx);
                heapifyDown(idx);
            }

            return removedTask;
        }


        /** Extract task with highest priority (and highest taskId in tie) */
        public Task extractMax() {
            if (heap.isEmpty()) return null;
            Task root = heap.get(0);
            Task last = heap.remove(heap.size() - 1);
            indexMap.remove(root.taskId);

            if (!heap.isEmpty()) {
                heap.set(0, last);
                indexMap.put(last.taskId, 0);
                heapifyDown(0);
            }
            return root;
        }

        /** Update priority of an existing task */
        public void updatePriority(int taskId, int newPriority) {
            if (!indexMap.containsKey(taskId)) {
                throw new NoSuchElementException("TaskId not found: " + taskId);
            }
            int idx = indexMap.get(taskId);
            int oldPriority = heap.get(idx).priority;
            heap.get(idx).priority = newPriority;

            if (newPriority > oldPriority) {
                bubbleUp(idx);
            } else if (newPriority < oldPriority) {
                heapifyDown(idx);
            } else {
                // same priority -> order may change due to taskId tie-break
                bubbleUp(idx);
                heapifyDown(idx);
            }
        }

        /** Debug print */
        public void printHeap() {
            for (Task task : heap) {
                System.out.print(task + " ");
            }
            System.out.println();
        }


    }



}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */