import java.util.Arrays;
import java.util.HashMap;

public class LongestIdealSubsequence {
    public int longestIdealString(String s, int k) {
        char[]cs = s.toCharArray();
        int n = cs.length;
        char[] seq= new char[n];
        seq[0]=cs[0];
        int r=0;
        for (int i = 1; i < n; i++) {
            if(cs[i]>seq[r]){
                seq[++r]=cs[i];
            }
            else{
                int index=lowerBound(cs,r,cs[i]);
                seq[index]=cs[i];
            }

        }
        return r+1;

    }

    public int lowerBound(char []nums,int r,char target){
        int l=0;
        while(l<r){
            int mid=l+(r-l)/2;
            if(nums[mid]>=target){
                r=mid;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }



    public static void main(String[] args) {
        LongestIdealSubsequence sol = new LongestIdealSubsequence();

        // Test case 1
        System.out.println(sol.longestIdealString("acfgbd", 2));
        // Expected: 4  (a → c → e/g → ? depending on valid chain)

        // Test case 2
        System.out.println(sol.longestIdealString("abcd", 3));
        // Expected: 4  (whole string)

        // Test case 3
        System.out.println(sol.longestIdealString("pvjcci", 4));//2
        System.out.println(sol.longestIdealString("eduktdb", 15));//5
        System.out.println(sol.longestIdealString("aaaabzzze", 15));//5
        //
    }


}
