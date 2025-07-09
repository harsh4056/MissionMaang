package drils.returnvaluerecursion;

public class PhaseEasy {

    public int sum(int num){
        if(num==0)
            return 0;
        return num%10+sum(num/10);
    }
    public int factorial(int num){
        if(num==0||num==1 ){
            return 1;
        }
        return num * factorial(num-1);
    }
    public int fibonacci(int num){
        if(num==0){
            return 0;
        }
        if(num==1){
            return 1;
        }

       return fibonacci(num-1)+fibonacci(num-2);
    }
    public int power(int x,int n){
        if(n==0){
            return 1;
        }
        return x*power(x,n-1);
    }
    public int minInArray(int[]nums){
        return findMin(nums,0);
    }
    public int findMin(int[]nums,int index){
        if(index>=nums.length){
            return Integer.MAX_VALUE;
        }
        return Math.min(nums[index],findMin(nums,index+1));

    }

    public int sumArray(int[]nums){
        return findSum(nums,0);
    }
    public int findSum(int[]nums,int index){
        if(index>=nums.length){
            return 0;
        }
        return nums[index]+findSum(nums,index+1);

    }

    public static void main(String[] args) {
        PhaseEasy easy= new PhaseEasy();
        System.out.println(easy.sum(199));
        System.out.println(easy.factorial(10));
        System.out.println(easy.fibonacci(6));
        System.out.println(easy.power(3,4));
        System.out.println(easy.minInArray(new int[]{2,18,7,5,3,31,-8,-5}));
        System.out.println(easy.sumArray(new int[]{2,18,10,17,3}));
    }

}
