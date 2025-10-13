import java.util.*;

public class MaximumTastinessOfCandyBasket {
    public int maximumTastiness(int[] price, int k) {
        int n=price.length;
        Arrays.sort(price);
        int left = 0;
        int right = price[n - 1] - price[0];
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int tasty = check(price, k, mid);
            if (tasty >= k) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;



    }
    public int check(int[]nums, int k,int s){
        int count=1;
        int prev=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]-prev>=s){
                prev=nums[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MaximumTastinessOfCandyBasket obj = new MaximumTastinessOfCandyBasket();

        int[] price1 = {106,195,138,127,79,119,46,198,166,10,41,151,68,198,126,46,140,35,127};
        int k1 = 12;
        System.out.println(obj.maximumTastiness(price1, k1)); // Expected output: 8

        int[] price2 = {1, 3, 1};
        int k2 = 2;
        System.out.println(obj.maximumTastiness(price2, k2)); // Expected output: 2

        int[] price3 = {7, 7, 7, 7};
        int k3 = 2;
        System.out.println(obj.maximumTastiness(price3, k3)); // Expected output: 0
    }

}
