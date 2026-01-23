public class DistinctSubsequences {

    public int numDistinct(String s, String t) {
        int ans= solve(s.toCharArray(),t.toCharArray(),0,0);
        return ans;
    }
    public int solve(char[]cs,char[]ct,int is,int it){
        if(it==ct.length){
            return 1;
        }
        int take=0;
        if(is<cs.length && cs[is]==ct[it]){
            take= solve(cs,ct,is+1,it+1);
        }

        int skip=0;
        if(is<cs.length){
            skip=solve(cs,ct,is+1,it);
        }

        return take+skip;
    }

    public static void main(String[] args) {
        DistinctSubsequences soln= new DistinctSubsequences();
        System.out.println(soln.numDistinct("caaat","cat"));
        System.out.println(soln.numDistinct("xxyxy","xy"));
    }
}
