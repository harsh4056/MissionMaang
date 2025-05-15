import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutiveSequence {

     static int longestConsecutive(int[] nums) {
        HashSet<Integer> set= new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        int max=0;
         for (int num : set) {
             if (!set.contains(num - 1)) {
                 int temp=num;
                 int count=0;
                 while(set.contains(temp)){
                     count++;
                     temp++;
                 }
               max=  Math.max(count,max);
             }
         }

                return max;
     }

    public static void main(String[] args) {
        LongestConsecutiveSequence.longestConsecutive(new int[]{100,4,200,1,3,2});
    }

}
