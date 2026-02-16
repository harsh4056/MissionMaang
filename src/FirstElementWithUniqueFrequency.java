import java.util.*;

public class FirstElementWithUniqueFrequency {
    public int firstUniqueFreq(int[] nums) {
        HashMap<Integer,Integer> countMap= new HashMap<>();
        for(int num:nums){
            countMap.putIfAbsent(num,0);
            countMap.put(num,countMap.get(num)+1);
        }
        HashMap<Integer,Integer> countCountMap= new HashMap<>();

        for(Map.Entry<Integer,Integer> entry:countMap.entrySet()){
            int value=entry.getValue();
            countCountMap.putIfAbsent(value,0);
            countCountMap.put(value,countCountMap.get(value)+1);

        }

        for(int num:nums){
            int value=countMap.get(num);
            if(countCountMap.get(value)==1){
                return num;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        FirstElementWithUniqueFrequency soln= new FirstElementWithUniqueFrequency();
        System.out.println(soln.firstUniqueFreq(new int[]{20,10,30,30}));
        System.out.println(soln.firstUniqueFreq(new int[]{20,20,10,30,30,30}));
    }
}
