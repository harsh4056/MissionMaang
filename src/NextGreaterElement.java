import java.util.Arrays;

public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        IntStack stack= new IntStack(nums2.length);

        IntHashMap hashMap= new IntHashMap();
        for (int i = nums2.length-1; i >=0; i--) {
            int num = nums2[i];
            while (!stack.isEmpty() && stack.peek()<num){
                stack.pop();
            }

            if(stack.isEmpty()){
                hashMap.put(num,-1);
            }
            else{
                hashMap.put(num, stack.peek());
            }
            stack.push(num);

        }
        int[]answer= new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int nums = nums1[i];
            answer[i]=hashMap.get(nums);

        }
        return answer;
    }

    public class IntStack {


        private final int[] data;
        private int top = -1;
        public IntStack(int capacity) { data = new int[capacity]; }
        public void push(int c) { data[++top] = c; }
        public int pop()    { return data[top--]; }
        public int peek()    {
            if(top == -1){
                return -1;
            }
            return data[top]; }
        public boolean isEmpty() { return top == -1; }
    }


    class IntHashMap {
        private int[] keys;
        private int[] values;
        private boolean[] used;
        private int size;
        private int capacity;
        private final double LOAD_FACTOR = 0.75;

        public IntHashMap() {
            this.capacity = 1024;
            this.keys = new int[capacity];
            this.values = new int[capacity];
            this.used = new boolean[capacity];
            this.size = 0;
        }

        private int hash(int key) {
            return (key % capacity + capacity) % capacity;
        }

        public void put(int key, int value) {
            if ((double) size / capacity >= LOAD_FACTOR) {
                resize();
            }
            int h = hash(key);
            int i = 0;
            while (used[h]) {
                if (keys[h] == key) {
                    values[h] = value;
                    return;
                }
                i++;
                h = (h + i * i) % capacity;
            }
            keys[h] = key;
            values[h] = value;
            used[h] = true;
            size++;
        }

        public int get(int key) {
            int h = hash(key);
            int i = 0;
            while (used[h]) {
                if (keys[h] == key) return values[h];
                i++;
                h = (h + i * i) % capacity;
            }
            return 0; // or any default you want
        }

        public boolean containsKey(int key) {
            int h = hash(key);
            int i = 0;
            while (used[h]) {
                if (keys[h] == key) return true;
                i++;
                h = (h + i * i) % capacity;
            }
            return false;
        }

        private void resize() {
            int oldCapacity = capacity;
            capacity *= 2;
            int[] oldKeys = keys;
            int[] oldValues = values;
            boolean[] oldUsed = used;

            keys = new int[capacity];
            values = new int[capacity];
            used = new boolean[capacity];
            size = 0;

            for (int i = 0; i < oldCapacity; i++) {
                if (oldUsed[i]) {
                    put(oldKeys[i], oldValues[i]);
                }
            }
        }
    }

    public static void main(String[] args) {
        NextGreaterElement solution = new NextGreaterElement();

        int[] nums1_1 = {4,1,2};
        int[] nums2_1 = {1,3,4,2};
        System.out.println(Arrays.toString(solution.nextGreaterElement(nums1_1, nums2_1))); // Expected: [-1,3,-1]

        int[] nums1_2 = {2,4};
        int[] nums2_2 = {1,2,3,4};
        System.out.println(Arrays.toString(solution.nextGreaterElement(nums1_2, nums2_2))); // Expected: [3,-1]

        int[] nums1_3 = {1,3,5,2,4};
        int[] nums2_3 = {6,5,4,3,2,1,7};
        System.out.println(Arrays.toString(solution.nextGreaterElement(nums1_3, nums2_3))); // Expected: [7,7,7,7,7]
    }

}
