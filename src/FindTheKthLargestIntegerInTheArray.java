import java.util.Arrays;
import java.util.PriorityQueue;

public class FindTheKthLargestIntegerInTheArray {
    public String kthLargestNumber(String[] nums, int k) {

        PriorityQueue<String> minHeap= new PriorityQueue<>((a,b)->{
            if(a.length()<b.length()) return -1;
            if(a.length()==b.length()){
                for (int i = 0; i < a.length(); i++) {
                    if(a.charAt(i)==b.charAt(i)) continue;
                    if(a.charAt(i)<b.charAt(i)){
                        return -1;
                    }
                    return 1;
                }
                return 0;
            }
            return 1;


        });
        for(String num:nums){
            minHeap.offer(num);
            while(minHeap.size()>k){
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }

    public static void main(String[] args) {
        FindTheKthLargestIntegerInTheArray obj = new FindTheKthLargestIntegerInTheArray();

        String[] nums1 = {"3", "6", "7", "10"};
        System.out.println(obj.kthLargestNumber(nums1, 4));
        // Expected: 3

        String[] nums2 = {"2", "21", "12", "1"};
        System.out.println(obj.kthLargestNumber(nums2, 3));
        // Expected: 2

        String[] nums3 = {"0", "0"};
        System.out.println(obj.kthLargestNumber(nums3, 2));
        // Expected: 0
    }
}
