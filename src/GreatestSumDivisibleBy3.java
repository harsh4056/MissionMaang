import java.util.PriorityQueue;

public class GreatestSumDivisibleBy3 {
    public int maxSumDivThree(int[] nums) {
        int one1=Integer.MAX_VALUE,one2=Integer.MAX_VALUE;
        int two1=Integer.MAX_VALUE,two2=Integer.MAX_VALUE;
        int sum=0;

        for(int num:nums){
            sum+=num;
            if(num%3==1){
                if(one1>=num) {
                    one2 = one1;
                    one1 = num;
                }
                else{
                    one2=Math.min(one2,num);
                }
            }
            else if(num%3==2){
                if(two1>=num) {
                    two2 = two1;
                    two1 = num;
                }
                else{
                    two2=Math.min(two2,num);
                }
            }
        }

        if(sum%3==1){
            int one=getForOne(one1,one2,two1,two2);
            sum-=one;
        }
        else if(sum%3==2){
            int two=getForTwo(one1,one2,two1,two2);
            sum-=two;
        }

        if(sum%3==0) return sum;

        return 0;
    }

    public int getForOne(int one1,int one2,int two1,int two2){
        int min=Math.min(one1,one2);
        if(two1!=Integer.MAX_VALUE && two2!=Integer.MAX_VALUE){
            min=Math.min(min,two1+two2);
        }
        if(min==Integer.MAX_VALUE) return 0;
        return min;
    }

    public int getForTwo(int one1,int one2,int two1,int two2){
        int min=Math.min(two1,two2);
        if(one1!=Integer.MAX_VALUE && one2!=Integer.MAX_VALUE){
            min=Math.min(min,one1+one2);
        }
        if(min==Integer.MAX_VALUE) return 0;
        return min;
    }

    public static void main(String[] args) {
        GreatestSumDivisibleBy3 soln= new GreatestSumDivisibleBy3();
        System.out.println(soln.maxSumDivThree(new int[]{3,6,5,1,8}));
        System.out.println(soln.maxSumDivThree(new int[]{1,2,3,4,4}));
        System.out.println(soln.maxSumDivThree(new int[]{4}));
    }
}
