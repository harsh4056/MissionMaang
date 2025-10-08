import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallestPrimeFraction {

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n=arr.length;

        int[]pos= new int[n-1];
        pos[0]=n-1;
        for(int i=1;i<n-1;i++){
            pos[i]=pos[i-1]+(n-1-i);
        }
        int left=0;
        int right=pos.length;
        while (left<right){
            int mid=left+(right-left)/2;
            if(pos[mid]<k){
                left=mid+1;
            }
            else {
                right=mid;
            }
        }
        int index2=pos[left]-(left-1>=0?pos[left-1]:0);
        int index1=k-((left-1>=0?pos[left-1]:0))-1;
        return new int[]{arr[index1],arr[index2]};


    }

    public static void main(String[] args) {
        KthSmallestPrimeFraction soln= new KthSmallestPrimeFraction();
        for(int i=1;i<=6;i++)
         System.out.println(Arrays.toString(soln.kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, i)));
        System.out.println(Arrays.toString(soln.kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3)));
    }

}
