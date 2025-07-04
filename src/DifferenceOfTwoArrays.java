import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class DifferenceOfTwoArrays {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

       int[] numsRecord1=new int[2001];
       int[] numsRecord2=new int[2001];

        for (int i : nums1) {
            numsRecord1[i+1000]++;
        }
        for (int i : nums2) {
            numsRecord2[i+1000]++;
        }
        List<Integer> list1= new ArrayList<>();
        for (int i : nums1) {
            if(numsRecord2[i+1000]==0){
            list1.add(i);
            }
            numsRecord2[i+1000]++;
        }
        List<Integer> list2= new ArrayList<>();
        for (int i : nums2) {
            if(numsRecord1[i+1000]==0){
                list2.add(i);
            }
            numsRecord1[i+1000]++;
        }

        List<List<Integer>> arrayLists= new ArrayList<>();
        arrayLists.add(list1);
        arrayLists.add(list2);
        return  arrayLists;
    }
    public static void main(String[] args) {
        DifferenceOfTwoArrays solver = new DifferenceOfTwoArrays();

        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4, 6};

        List<List<Integer>> result = solver.findDifference(nums1, nums2);
        System.out.println("Test Case 1:");
        printResult(result);

        int[] nums3 = {1, 2, 3, 3};
        int[] nums4 = {1, 1, 2, 2};

        result = solver.findDifference(nums3, nums4);
        System.out.println("Test Case 2:");
        printResult(result);

        int[] nums5 = {1, 2, 2};
        int[] nums6 = {3};

        result = solver.findDifference(nums5, nums6);
        System.out.println("Test Case 3:");
        printResult(result);
    }




    private static void printResult(List<List<Integer>> result) {
        for (List<Integer> list : result) {
            System.out.println(Arrays.toString(list.toArray()));
        }
        System.out.println();
    }
}
