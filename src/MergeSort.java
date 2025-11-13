public class MergeSort {
    // 1. Global counter variable
    public long count = 0;

    public void mergeSort(int[]nums){
        merge(nums,0,nums.length-1);

    }

    public void merge(int[]nums, int start,int end){
        if(start==end) return;
        int mid=(start+end)/2;


        int []left=new int[mid-start+1];
        int[]right=new int[end-mid];

        // Copy Loops (Not counted, as they are part of the flawed O(N) setup)
        for (int i=0;i<=mid;i++){
            left[i]=nums[i];
        }

        int j=0;
        for (int i=mid+1;i<=end;i++){
            right[j]=nums[i];
            j++;
        }
        mergeSort(left);
        mergeSort(right);
        int p1=0,p2=0;
        int i=start;

        // 2. Count increments inside the merging loops (O(N) work)
        while(p1<left.length && p2<right.length){
            if(left[p1]<right[p2]){
                nums[i]=left[p1];
                i++;
                p1++;
            }
            else{
                nums[i]=right[p2];
                i++;
                p2++;
            }
            count++; // Increment count for each merge operation/comparison
        }

        while (p1<left.length){
            nums[i]=left[p1];
            i++;
            p1++;
            count++; // Increment count for remaining elements
        }
        while (p2<right.length){
            nums[i]=right[p2];
            i++;
            p2++;
            count++; // Increment count for remaining elements
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        // Use a smaller N to make the count interpretable (N log N)
        int N = 100000;
        int[] nums = new int[N];

        // Populate the array in reverse-sorted order (Worst Case)
        for (int i = 0; i < N; i++) {
            nums[i] = N - i;
        }

        // --- Start Timing ---
        long startTime = System.currentTimeMillis();

        // Call your sorting method
        mergeSort.mergeSort(nums);

        // --- End Timing ---
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;

        System.out.println("Input Size (N): " + N);
        System.out.println("Total Merge Operations (Count): " + mergeSort.count);
        System.out.println("Theoretical N*log2(N): " + Math.round(N * (Math.log(N) / Math.log(2))));
        System.out.println("------------------------------------");
        System.out.println("Time taken: " + timeTaken + " ms");
        System.out.println("Finished sorting " + N + " elements.");
    }
}