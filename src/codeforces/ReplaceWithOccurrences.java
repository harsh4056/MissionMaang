package codeforces;

import java.util.*;


public class ReplaceWithOccurrences {

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int t=scanner.nextInt();

        for(int i=0;i<t;i++){
            int n=scanner.nextInt();
            int[]arr= new int[n];
            for (int j = 0; j < n; j++) {
                arr[j]=scanner.nextInt();
            }
            int []answer= findArr(arr);
            System.out.println();
            for (int a : answer) {
                System.out.print(a+ " ");

            }

        }

    }
    public static int[] findArr(int []nums){
        HashMap<Integer,Integer> hashMap= new HashMap<>();
        int count=0;
        for(int num:nums){
            if(!hashMap.containsKey(num)){
                count+=num;
            }
            hashMap.put(num,hashMap.getOrDefault(num,0)+1);
        }
        if(count>nums.length) return new int[]{-1};
        int []answer= new int[nums.length];
        for (int i = 0; i <nums.length; i++) {
            answer[i]=hashMap.get(nums[i]);
        }
        return answer;

    }
}
