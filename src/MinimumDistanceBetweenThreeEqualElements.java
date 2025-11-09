import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class MinimumDistanceBetweenThreeEqualElements {

    public int minimumDistance(int[] nums) {
        HashMap<Integer, int[]> setHashMap= new HashMap<>();
        int answer=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(setHashMap.containsKey(num)){
                int []curr= setHashMap.get(num);
                shift(curr,i);
            }
            else{
                int []curr= new int[3];
                Arrays.fill(curr,-1);
                shift(curr,i);
                setHashMap.put(num,curr);
            }

            if(setHashMap.get(num)[0]!=-1) {
                int[]value=setHashMap.get(num);
                int a = value[0];
                int b = value[1];
                int c = value[2];
                int sum = Math.abs(a - b) + Math.abs(a - c) + Math.abs(b - c);
                answer = Math.min(sum, answer);
            }
        }

        if(answer==Integer.MAX_VALUE) return -1;
        return answer;
    }
    public void shift(int[]triples, int nValue){
        triples[0]=triples[1];
        triples[1]=triples[2];
        triples[2]=nValue;
    }

    public static void main(String[] args) {
        MinimumDistanceBetweenThreeEqualElements soln= new MinimumDistanceBetweenThreeEqualElements();
        System.out.println(soln.minimumDistance(new int[]{5,3,5,5,5}));//4
        System.out.println(soln.minimumDistance(new int[]{1,1,2,3,2,1,2}));
    }
}
