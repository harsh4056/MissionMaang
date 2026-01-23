public class InterleavingStrings {

    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()) return false;
        Boolean [][]dp= new Boolean[s1.length()+1][s2.length()+1];
        return solve(s1.toCharArray(),s2.toCharArray(),s3.toCharArray(),0,0,0,dp);

    }
    public boolean solve(char[]s1, char[]s2, char[]s3, int i1, int i2, int i3, Boolean[][] dp){
        if(i3==s3.length){
            return true;
        }
        if(dp[i1][i2]!=null) return dp[i1][i2];
        return dp[i1][i2]= (i1<s1.length && s1[i1]==s3[i3] && solve(s1,s2,s3,i1+1,i2,i3+1, dp))||
                (i2<s2.length && s2[i2]==s3[i3] && solve(s1,s2,s3,i1,i2+1,i3+1, dp));
    }







    public static void main(String[] args) {
        InterleavingStrings obj = new InterleavingStrings();


        System.out.println(obj.isInterleave("aab", "axy", "aaxaby")); // true
        System.out.println(obj.isInterleave("aab", "axy", "abaaxy")); // false
        System.out.println(obj.isInterleave("abc", "def", "adbcef")); // true
        System.out.println(obj.isInterleave("", "", ""));             // true
        System.out.println(obj.isInterleave("abc", "", "abc"));       // true
    }
}
