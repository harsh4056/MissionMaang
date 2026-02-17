import java.util.*;

public class MergeAdjacentEqualElements {
    public List<Long> mergeAdjacent(int[] nums) {
        Stack<Long> stack= new Stack<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            long num=nums[i];
            if(stack.isEmpty()|| stack.peek()!=num){
                stack.push(num);
                continue;
            }
            while(!stack.isEmpty() &&stack.peek()==num){
                long top=stack.pop();
                 num=top+num;

            }
            stack.push(num);

        }
        return new ArrayList<>(stack);
    }

    public static void main(String[] args) {
        MergeAdjacentEqualElements soln= new MergeAdjacentEqualElements();
        System.out.println(soln.mergeAdjacent(new int[]{2,1,1,2}));
        System.out.println(soln.mergeAdjacent(new int[]{3,1,1,2}));
        System.out.println(soln.mergeAdjacent(new int[]{2,2,4}));
        System.out.println(soln.mergeAdjacent(new int[]{3,7,5}));

    }
}
