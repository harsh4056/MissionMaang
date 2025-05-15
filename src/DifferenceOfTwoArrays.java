import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class DifferenceOfTwoArrays {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

       int[] numsRecord1=new int[2001];
       int[] numsRecord2=new int[2001];
        for (int i : nums1) {
            if(i<0){
                numsRecord1[i+2001]+=1;
            }
            else{
                numsRecord1[i]+=1;
            }
        }

        for (int i : nums2) {
            if(i<0){
                numsRecord2[i+2001]+=1;
            }
            else{
                numsRecord2[i]+=1;
            }
        }
        HashSet<Integer> numbers1= new HashSet<>();
        for (int i : nums1) {
            if(i<0){
                 if(numsRecord1[i+2001]>=1 && numsRecord2[i+2001]==0){
                     numbers1.add(i);
                 }
            }
            else{
                if(numsRecord1[i]>=1 && numsRecord2[i]==0)
                    numbers1.add(i);
            }
        }
        HashSet<Integer> numbers2= new HashSet<>();
        for (int i : nums2) {
            if(i<0){
                if(numsRecord2[i+2001]>=1 && numsRecord1[i+2001]==0){
                    numbers2.add(i);
                }
            }
            else{
                if(numsRecord2[i]>=1 && numsRecord1[i]==0)
                    numbers2.add(i);
            }
        }
        List<List<Integer>> arrayLists= new ArrayList<>();
        arrayLists.add(numbers1.stream().toList());
        arrayLists.add(numbers2.stream().toList());
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
    }

    private static void printResult(List<List<Integer>> result) {
        for (List<Integer> list : result) {
            System.out.println(Arrays.toString(list.toArray()));
        }
        System.out.println();
    }
}
