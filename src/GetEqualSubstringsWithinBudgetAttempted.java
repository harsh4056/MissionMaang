public class GetEqualSubstringsWithinBudgetAttempted {
    public int equalSubstring(String s, String t, int maxCost) {
        char[]cs=s.toCharArray();
        char[]ct=t.toCharArray();
        int l=0;
        int ans=0;
        int window=0;
        for(int r=0;r<cs.length;r++){
            window+=Math.abs(cs[r]-ct[r]);
            while(l<r && window>maxCost){
                window-=Math.abs(cs[l]-ct[l]);
                l++;
            }
            if(r-l==0 && Math.abs(cs[r]-ct[r])>maxCost) continue;
            ans=Math.max(ans,r-l+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        GetEqualSubstringsWithinBudgetAttempted soln= new GetEqualSubstringsWithinBudgetAttempted();
        System.out.println(soln.equalSubstring("krrgw","zjxss",19));
    }
}
