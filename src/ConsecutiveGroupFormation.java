import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ConsecutiveGroupFormation {

   public boolean canFormGroups(int[]nums,int k){
       PriorityQueue<Integer> minHeap=new PriorityQueue<>();
       for (int num : nums) {
           minHeap.offer(num);
       }
       List<int[]> lists= new ArrayList<>();
       while (!minHeap.isEmpty()){
           int value= minHeap.poll();
           if(lists.isEmpty()){
               lists.add(new int[]{value,1});

           }
           else{
               boolean added=false;
              for(int[] arr:lists){
                  int last=arr[0];
                  if(last+1==value && arr[1]<k){
                      arr[0]=value;
                      arr[1]++;
                      added=true;
                      break;
                  }
              }
              if(!added){
                  lists.add(new int[]{value,1});

              }
           }
       }
       for(int[] arr:lists){
           if(arr[1]!=k){
               return false;
           }
       }
       return true;

    }

    public static void main(String[] args) {

        ConsecutiveGroupFormation solution = new ConsecutiveGroupFormation();
        int[] nums = new int[1000000];
        for (int i = 0; i < 1000000; i++) nums[i] = i * 2;  // gaps between numbers
        int k = 3;
        System.out.println(solution.canFormGroups(nums,k));
        // Test Case 1: Expected result -> true
        int[] nums1 = {1,2,3,3,3,2};
        int k1 = 3;
        System.out.println(solution.canFormGroups(nums1, k1)); // true

        // Test Case 2: Expected result -> false
        int[] nums2 = {1,2,3,4,5};
        int k2 = 4;
        System.out.println(solution.canFormGroups(nums2, k2)); // false

        // Test Case 3: Expected result -> true
        int[] nums3 = {1,2,3,6,7,8};
        int k3 = 3;
        System.out.println(solution.canFormGroups(nums3, k3)); // true
    }

}
