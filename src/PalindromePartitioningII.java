import java.util.Arrays;

public class PalindromePartitioningII {

    public int minCut(String s) {
        int[]dp= new int[s.length()];
        Arrays.fill(dp,-1);
        return solve(s.toCharArray(),0,dp)-1;
    }

    public int solve(char[] s, int index, int[] dp){
        if(index>=s.length) return 0;
        if(dp[index]!=-1) return dp[index];

        int minCuts=Integer.MAX_VALUE;
        int cuts=0;
        for(int i=index;i<s.length;i++){

            if(isPalindrome(s,index,i)){
                cuts = 1+solve(s,i+1, dp);
            }
            minCuts=Math.min(cuts,minCuts);
        }
        dp[index]=minCuts;
        return minCuts;
    }
    boolean isPalindrome(char[] arr, int start, int end) {
        while (start < end) {
            if (arr[start] != arr[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args) {
        PalindromePartitioningII solution = new PalindromePartitioningII();

        // Test case 1
        String test1 = "aab";
        System.out.println(solution.minCut(test1)); // Expected: 1

        // Test case 2
        String test2 = "a";
        System.out.println(solution.minCut(test2)); // Expected: 0

        // Test case 3
        String test3 = "abccbc";
        System.out.println(solution.minCut(test3)); // Expected: 2
    }

}
