import java.util.*;


public class MinimumNumberofPushestoTypeWordII {

    public int minimumPushes(String word) {


        char[]cword= word.toCharArray();
        int[] freq= new int[26];
        for(char c:cword){
            freq[c-'a']++;
        }
        int count=1;
        int sum=0;
        Arrays.sort(freq);
        for(int i=25;i>=0;i--){
            int press=Math.ceilDiv(count,8);
            sum+=freq[i]*press;
            count++;
        }



        return sum;
    }


    public static void main(String[] args) {
        MinimumNumberofPushestoTypeWordII soln= new MinimumNumberofPushestoTypeWordII();
        System.out.println(soln.minimumPushes("aabbccddeeffgghhiiiiii"));//24
        System.out.println(soln.minimumPushes("xyzxyzxyzxyz"));//12
        System.out.println(soln.minimumPushes("abcde"));//5
    }
}
