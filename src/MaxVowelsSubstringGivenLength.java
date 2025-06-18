import java.util.HashSet;

public class MaxVowelsSubstringGivenLength {

    public int maxVowels(String s, int k) {
        int maxCount=0;
        int currentCount=0;
        char []sChars= s.toCharArray();
        for (int i = 0; i < k; i++) {
            char c=sChars[i];
            if(c=='a' ||c=='e' ||c=='i' ||c=='o' ||c=='u' )
                currentCount++;
        }
        maxCount=Math.max(currentCount,maxCount);
        for (int i = k; i < sChars.length; i++) {
            char c=sChars[i];
            if(c=='a' ||c=='e' ||c=='i' ||c=='o' ||c=='u' ) {
                currentCount++;
                if(currentCount>k){
                    currentCount=k;
                }
            }
            char d=sChars[i-k];
           if(d=='a' ||d=='e' ||d=='i' ||d=='o' ||d=='u' ){
               currentCount--;
               if(currentCount<0){
                   currentCount=0;
               }
           }
            maxCount=Math.max(currentCount,maxCount);
        }
        return maxCount;

    }

    public static void main(String[] args) {
        MaxVowelsSubstringGivenLength solution = new MaxVowelsSubstringGivenLength();

       /* System.out.println(solution.maxVowels("abciiidef", 3)); // Expected: 3
        System.out.println(solution.maxVowels("aeiou", 2)); // Expected: 2
        System.out.println(solution.maxVowels("leetcode", 3)); // Expected: 2*/
        System.out.println(solution.maxVowels("tnfazcwrryitgacaabwm", 4)); // Expected: 3
    }

}
