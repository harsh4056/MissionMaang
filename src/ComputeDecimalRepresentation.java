import java.util.*;

public class ComputeDecimalRepresentation {
    public int[] decimalRepresentation(int n) {
        List<Integer> list= new ArrayList<>();
        int count=0;
        while(n>0){
            int rem=n%10;
            if(rem!=0) count++;
            list.add(rem);
            n=n/10;

        }
        int[] arr= new int[count];
        int index=arr.length-1;
        int ten=1;
        for (int current : list) {
            if(current!=0)
             arr[index--] = current * ten;
            ten = ten * 10;

        }
        return arr;

    }

    public static void main(String[] args) {
        ComputeDecimalRepresentation soln= new ComputeDecimalRepresentation();
        System.out.println(Arrays.toString(soln.decimalRepresentation(102)));
        System.out.println(Arrays.toString(soln.decimalRepresentation(1000)));
    }
}
