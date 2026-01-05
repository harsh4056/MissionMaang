public class LongestRepeatingCharacterReplacement {


        public int characterReplacement(String s, int k) {
            int ans=-1;
            char[]cs=s.toCharArray();
            for(char rep='A';rep<='Z';rep++){
                int l=0;
                int rem=k;
                for(int r=0;r<cs.length;r++){
                    if(cs[r]!=rep){
                        rem--;
                    }
                    while(rem<0 && l<r){
                        if(cs[l]!=rep){
                            rem++;
                        }
                        l++;
                    }

                    ans=Math.max(ans,r-l+1);
                }
            }
            return ans;
        }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement soln= new LongestRepeatingCharacterReplacement();
        System.out.println(soln.characterReplacement("AAABABB",1));
    }


}
