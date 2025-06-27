public class LongestCommonSubstring {

    public String longestCommonSubstring(String string1,String string2){

        char[]str1=string1.toCharArray();
        char[]str2=string2.toCharArray();
        int[][] memo= new int[str1.length][str2.length];
        int str1LI=-1;
        int str2LJ=-1;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {

                if(str1[i]==str2[j]){
                    memo[i][j]=1+ ((i-1<0 || j-1<0)?0:memo[i-1][j-1]);
                    if(max<=memo[i][j]){
                        str1LI=i;
                        str2LJ=j;
                        max=memo[i][j];
                    }
                }
                else{
                    memo[i][j]=0;
                }
            }

        }
        return String.valueOf(str2,str2LJ-max+1,max);

    }

    public static void main(String[] args) {
        LongestCommonSubstring lcs= new LongestCommonSubstring();
        System.out.println(lcs.longestCommonSubstring("abac","cab"));
    }

}
