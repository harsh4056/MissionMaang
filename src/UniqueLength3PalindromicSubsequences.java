public class UniqueLength3PalindromicSubsequences {

    public int countPalindromicSubsequence(String s) {
        int count=0;
        char[]cs= s.toCharArray();
        int n=cs.length;

        for(char fs='a';fs<='z';fs++) {
            boolean[] seen=new boolean[26];
            int start=-1;
            int end=-1;
            for (int i = 0; i < n; i++) {
                if(cs[i]==fs){
                    start=i;
                    break;
                }
            }

            for (int i = n-1; i >=0 ; i--) {
                if(cs[i]==fs){
                    end=i;
                    break;
                }
            }
            for (int i = start+1; i <= end-1; i++) {
                int idx=cs[i]-'a';
                if(!seen[idx]){
                    count++;
                    seen[idx]=true;
                }
            }
        }
        return count;
    }


}
