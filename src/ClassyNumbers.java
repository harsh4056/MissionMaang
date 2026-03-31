import java.util.Scanner;

public class ClassyNumbers {

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        int T=scanner.nextInt();
        for (int i = 0; i < T; i++) {
            long left= scanner.nextLong();
            long right=scanner.nextLong();
            long a=getClassy(left);
            long b=getClassy(right);
            System.out.println(b-a);
        }
    }

    public static long getClassy(Long n){
        char[]cn= String.valueOf(n).toCharArray();
        Long[][][]dp= new Long[20][2][20];
        long ans=solve(0,true,0,cn,dp);
        return ans;
    }

    public static long solve(int i,boolean tight,int cnt,char[]cs,Long[][][]dp){
        if(i== cs.length){
            if(cnt<=3){
                return 1;
            }
            return 0;
        }

        if(dp[i][tight?1:0][cnt]!=null) return dp[i][tight?1:0][cnt];
        long count=0;

        int limit=tight?cs[i]-'0':9;

        for (int d = 0; d <= limit; d++) {
            boolean newTight= tight && (d==limit);
            int updatedCnt= d!=0?cnt+1:cnt;

            count+=solve(i+1,newTight,updatedCnt,cs,dp);

        }

        return dp[i][tight?1:0][cnt]=count;
    }



}
