package codeforces;

import java.util.HashSet;
import java.util.Scanner;

public class MEX {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int t= scanner.nextInt();
        while(t>0) {
            int n = scanner.nextInt();
            int ex = scanner.nextInt();
            int[]arr= new int[n];
            for (int i = 0; i < n; i++) {
                arr[i]=scanner.nextInt();
            }
            int ans=giveMexOps(arr,ex);
            System.out.println(ans);
            t--;
        }
    }
    public static int giveMexOps(int[]nums,int excluded){
        int exCount=0;
        int missingCount=0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num == excluded) exCount++;
            set.add(num);
        }
        for (int i = 0; i < excluded; i++) {
            if (!set.contains(i)) missingCount++;
        }

        return Math.max(exCount,missingCount);
    }
}
