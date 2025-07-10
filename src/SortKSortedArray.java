import java.util.PriorityQueue;

public class SortKSortedArray {

    public void nearlySorted(int[] arr, int k) {

        PriorityQueue<Integer> minHeap= new PriorityQueue<>();
        for (int i = 0; i <=k; i++) {
            minHeap.add(arr[i]);
        }

        for (int i = k+1; i < arr.length; i++) {

            arr[i-k-1]=minHeap.poll();
            minHeap.add(arr[i]);

        }
        for (int i = arr.length-minHeap.size(); i < arr.length; i++) {

            arr[i]=minHeap.poll();

        }

    }

    public static void main(String[] args) {
        SortKSortedArray solution = new SortKSortedArray();

        int[] arr1 = {6, 5, 3, 2, 8, 10, 9};
        solution.nearlySorted(arr1, 3);
        // Expected sorted array: [2, 3, 5, 6, 8, 9, 10]
        System.out.println(java.util.Arrays.toString(arr1));

        int[] arr2 = {10, 9, 8, 7, 4, 70, 60, 50};
        solution.nearlySorted(arr2, 4);
        // Expected sorted array: [4, 7, 8, 9, 10, 50, 60, 70]
        System.out.println(java.util.Arrays.toString(arr2));

        int[] arr3 = {3, 1, 2, 5, 4, 6};
        solution.nearlySorted(arr3, 2);
        // Expected sorted array: [1, 2, 3, 4, 5, 6]
        System.out.println(java.util.Arrays.toString(arr3));
    }

}
