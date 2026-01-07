import java.util.ArrayList;
import java.util.List;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        char[]sArr= s2.toCharArray();
        char[]pArr= s1.toCharArray();
        int[]maps= new int[26];
        int n =sArr.length;
        int k =pArr.length;

        if (n < k) return false;
        for (int i = 0; i < k; i++) {
            maps[pArr[i]-'a']++;
            maps[sArr[i]-'a']--;
        }
        int diffCount = 0;
        for (int f : maps) {
            if (f > 0) {
                diffCount++;
            }
        }
        if(diffCount==0)
            return true;

        for (int i = k; i <n ; i++) {
            if(++maps[sArr[i-k]-'a']==1) diffCount++;
            if(--maps[sArr[i]-'a']==0) diffCount--;
            if(diffCount==0)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        PermutationInString soln= new PermutationInString();
        System.out.println(soln.checkInclusion("abc","cccccbabbbaaaa"));
    }
}
