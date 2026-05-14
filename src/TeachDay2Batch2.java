public class TeachDay2Batch2 {

    public static void main(String[] args) {
        int[]nums= new int[]{5,6,7,8,9,9};
        double average= findAverage(nums);
        System.out.println(average);
        System.out.println(reverseADigit(321));
        System.out.println(findSumOfDigits(321));
        System.out.println(countDigits(321));
    }

    public static double findAverage(int[]nums){
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum=sum+num;
        }
        double average= (double) sum / nums.length;
        return average;
    }


    public static int reverseADigit(int num){
        int reverse=0;
        while (num>0){
            int rem=num%10;
            num=num/10;
            reverse=reverse*10 +rem;
        }
        return reverse;
    }

    public static int findSumOfDigits(int num){
        int sum=0;
        while (num>0){
            int rem=num%10;
            num=num/10;
            sum+=rem;
        }
        return sum;
    }



    public static int countDigits(int num){
        int count=0;
        while (num>0){
            count++;
            num=num/10;
        }
        return count;
    }
}




