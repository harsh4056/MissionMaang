import java.util.ArrayList;
import java.util.List;

public class TeachDay3 {

    public static void main(String[] args) {
        int[] arr= leadersInAnArray(new int[]{16,17,4,3,5,2});
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
    public static int[] leadersInAnArray(int[]nums){
        List<Integer> list= new ArrayList<>();
        int m=nums[nums.length-1];
        list.add(m);
        for (int i = nums.length-2;i>=0 ; i--) {
            if(m<nums[i]){
                m=nums[i];
                list.add(m);
            }
        }
        int[]arr= new int[list.size()];
        int index=0;
        for (int i = list.size()-1; i >=0 ; i--) {
            arr[index]=list.get(i);
            index++;
        }
        return arr;






    }
}
