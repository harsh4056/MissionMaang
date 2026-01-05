import java.util.*;

public class PointOfIntersectionOfCars {
    public int numberOfPoints(List<List<Integer>> nums) {
        PriorityQueue<int[]> minHeap=new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for(List<Integer> list:nums){
            int s=list.get(0);
            int e=list.get(1);
            minHeap.offer(new int[]{s,+1});
            minHeap.offer(new int[]{e,-1});
        }
        int ans=0;
        int last=0;
        int count=0;
        while(!minHeap.isEmpty()){
            int []curr=minHeap.poll();
            int t=curr[0];
            int p=curr[1];
            count+=p;
            if(last==0 && count>0){
                last=t;
            }
            if(count==0){
                ans+=t-last+1;
                last=0;
            }

        }
        return ans;
    }

    public static void main(String[] args) {

        PointOfIntersectionOfCars solution = new PointOfIntersectionOfCars();
        // Test case 1
        List<List<Integer>> nums1 = new ArrayList<>();
        nums1.add(Arrays.asList(3, 6));
        nums1.add(Arrays.asList(1, 5));
        nums1.add(Arrays.asList(4, 7));
        System.out.println(solution.numberOfPoints(nums1));
        // Expected output: 6 (points 1 to 6)

        // Test case 2
        List<List<Integer>> nums2 = new ArrayList<>();
        nums2.add(Arrays.asList(1, 3));
        nums2.add(Arrays.asList(4, 4));
        nums2.add(Arrays.asList(5, 8));

        System.out.println(solution.numberOfPoints(nums2));
        // Expected output: 3 (points 1, 4, 7)

        // Test case 3
        List<List<Integer>> nums3 = new ArrayList<>();
        nums3.add(Arrays.asList(1, 10));
        nums3.add(Arrays.asList(2, 3));
        nums3.add(Arrays.asList(5, 7));
        System.out.println(solution.numberOfPoints(nums3));
        // Expected output: 9 (points 1 to 9)
    }

}
