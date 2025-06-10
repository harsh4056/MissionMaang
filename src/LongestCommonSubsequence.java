import java.lang.foreign.StructLayout;

public class LongestCommonSubsequence {


    public int longestCommonSubsequence(String text1, String text2) {
        if(text2.length()>text1.length()){
           return longestCommonSubsequence(text2,text1);
        }

        int p1=0;
        int p2=0;
        for (int i = 0; i < text1.length(); i++) {
            if(text1.charAt(p1)==text2.charAt(p2)){
                p2++;
            }
            if(p2>=text2.length()){
                return text2.length();
            }
            p1++;
        }
        return p2;
    }


    public static void main(String[] args) {
        LongestCommonSubsequence commonSubsequence = new LongestCommonSubsequence();

       /* System.out.println(commonSubsequence.longestCommonSubsequence("abcde", "ace")); // Expected: 3
        System.out.println(commonSubsequence.longestCommonSubsequence("abc", "abc"));   // Expected: 3
        System.out.println(commonSubsequence.longestCommonSubsequence("abc", "def"));   // Expected: 0
        System.out.println(commonSubsequence.longestCommonSubsequence("abcdef", "acf")); // Expected: 3*/

        System.out.println(commonSubsequence.longestCommonSubsequence("psnw", "vozsh"));  // Expected: 2
    }


}
