import java.util.*;


public class MostProfitAssigningWork {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        sortBoth(difficulty,profit);
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < difficulty.length; i++) {
            max=Math.max(max,profit[i]);
            profit[i]=max;
        }
        int m=profit.length;
        int n=worker.length;
        int sum=0;
        for(int w:worker){
            int left=0;
            int right=m;
            while(left<right){
                int mid=left+(right-left)/2;
                if(difficulty[mid]>w){
                    right=mid;
                }
                else left=mid+1;
            }
            sum+=  (left-1>=0?profit[left-1]:0);
        }
        return sum;
    }

    public static void sortBoth(int[] arr1, int[] arr2) {
        int n = arr1.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) indices[i] = i;

        Arrays.sort(indices, Comparator.comparingInt(i -> arr1[i]));

        int[] temp1 = new int[n];
        int[] temp2 = new int[n];
        for (int i = 0; i < n; i++) {
            temp1[i] = arr1[indices[i]];
            temp2[i] = arr2[indices[i]];
        }

        System.arraycopy(temp1, 0, arr1, 0, n);
        System.arraycopy(temp2, 0, arr2, 0, n);
    }

    /*
    * difficulty =
[68,35,52,47,86]
profit =
[67,17,1,81,3]
worker =
[92,10,85,84,82]
    * */
    public static void main(String[] args) {
        MostProfitAssigningWork obj = new MostProfitAssigningWork();

        int[] difficulty1 = {68,35,52,47,86};
        int[] profit1 = {67,17,1,81,3};
        int[] worker1 = {92,10,85,84,82};
        System.out.println(obj.maxProfitAssignment(difficulty1, profit1, worker1));
        // Expected: 100

        int[] difficulty2 = {85, 47, 57};
        int[] profit2 = {24, 66, 99};
        int[] worker2 = {40, 25, 25};
        System.out.println(obj.maxProfitAssignment(difficulty2, profit2, worker2));
        // Expected: 0 (no worker can take any job)

        int[] difficulty3 = {13, 37, 58};
        int[] profit3 = {4, 90, 96};
        int[] worker3 = {34, 73, 45};
        System.out.println(obj.maxProfitAssignment(difficulty3, profit3, worker3));
        // Expected: 190
    }

}
