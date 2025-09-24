import java.util.*;

public class DIStringMatch {
    public int[] diStringMatch(String s) {
        Stack<Integer> stack= new Stack<>();
        char[]cs= s.toCharArray();
        int n=cs.length;
        int []ans= new int[n+1];
        int count=0;
        for(int i=0;i<=n;i++){
            stack.push(i);
            if(i==n||cs[i]=='I'){
                while(!stack.isEmpty()){
                    ans[count++]=stack.pop();
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        DIStringMatch diStringMatch= new DIStringMatch();
        System.out.println(Arrays.toString(diStringMatch.diStringMatch("IDID")));
    }
}
