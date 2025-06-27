import java.util.Arrays;

public class OnesAndZeros {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][]memo= new int[strs.length][n+1][m+1];
        for (int[][] ints : memo) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt,-1);
            }
        }
        dfs(strs,memo,n,m,0);
        return memo[0][n][m];
    }

    public int dfs(String[] strs,int[][][] memo, int ones, int zeros,int index){

        if( index>= strs.length){
            return 0;
        }
        if(memo[index][ones][zeros]!=-1){
            return memo[index][ones][zeros];
        }
        int[] count=countZeros(strs[index]);


        int use = 0;
        if (zeros >= count[0] && ones >= count[1]) {
            use = 1 +dfs(strs,memo,ones-count[1],zeros-count[0],index+1);
        }
        int skip = dfs(strs,memo,ones,zeros,index+1);


        return memo[index][ones][zeros]=Math.max(use,skip);

    }

    public int[] countZeros(String binary){
        int []count= new int[]{0,0};

        for(char c:binary.toCharArray()){
            count[c-'0']++;
        }
        return count;
    }

    public static void main(String[] args) {
        OnesAndZeros solution = new OnesAndZeros();

        String[] strs1 = {"10", "0001", "111001", "1", "0"};
        int m1 = 5, n1 = 3;
        System.out.println(solution.findMaxForm(strs1, m1, n1)); // Expected: 4

        String[] strs2 = {"10", "0", "1"};
        int m2 = 1, n2 = 1;
        System.out.println(solution.findMaxForm(strs2, m2, n2)); // Expected: 2

        String[] strs3 = {"10", "11", "00", "01"};
        int m3 = 2, n3 = 2;
        System.out.println(solution.findMaxForm(strs3, m3, n3)); // Expected: 2
    }

}
