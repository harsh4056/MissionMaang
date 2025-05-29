import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IntersectionOfTwoArrays {


    public int[] intersection(int[] nums1, int[] nums2) {
        int[]num1Holder= new int[1001];
        int[]num2Holder= new int[1001];

        int counter1=0;int counter2=0;

        while(counter2<nums2.length || counter1<nums1.length){
            if(counter2<nums2.length ){
                num2Holder[nums2[counter2]]++;
                counter2++;
            }

            if(counter1<nums1.length){
                num1Holder[nums1[counter1]]++;
                counter1++;
            }

        }
        List<Integer> list= new ArrayList<>();
        for (int i = 0; i < num2Holder.length; i++) {
           if(num2Holder[i]>0 && num1Holder[i]>0){
               list.add(i);
           }

        }

       return list.stream().mapToInt(i->i).toArray();


    }
}
