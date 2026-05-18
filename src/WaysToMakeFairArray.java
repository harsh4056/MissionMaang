public class WaysToMakeFairArray {

    public int waysToMakeFair(int[] nums) {
        int n=nums.length;

        int[]prefix=new int[n];
        prefix[0]=nums[0];
        prefix[1]=nums[1];
        for (int i = 2; i < nums.length; i++) {
            prefix[i]=prefix[i-2]+nums[i];
        }
        int count=0;
        for (int i = 0; i < nums.length; i++) {
                int last=prefix[n-1];
                int secondLast=prefix[n-2];
                int prevprev=i-2>=0?prefix[i-2]:0;
                int prev=i-1>=0?prefix[i-1]:0;
                if(n%2==0) {
                    if (i % 2 == 0) {
                        secondLast -= prevprev;
                        last -= prev;
                        secondLast -= nums[i];
                        secondLast += prev;
                        last += prevprev;

                    } else {
                        secondLast -= prev;
                        last -= prevprev;
                        last -= nums[i];
                        secondLast += prevprev;
                        last += prev;
                    }
                }
                else{
                    if (i % 2 == 0) {

                        secondLast -= prev;
                        last -= prevprev;
                        last -= nums[i];
                        secondLast += prevprev;
                        last += prev;
                    } else {




                        secondLast -= prevprev;
                        last -= prev;
                        secondLast -= nums[i];
                        secondLast += prev;
                        last += prevprev;
                    }
                }
            if(last==secondLast){
                count++;
            }
        }

        return count;
    }



    public static void main(String[] args) {
        WaysToMakeFairArray soln= new WaysToMakeFairArray();
        System.out.println(soln.waysToMakeFair(new int[]{1,1,1}));
    }
}
