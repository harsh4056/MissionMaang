public class Sqrt {
    public int mySqrt(int x) {
        long left=1;
        long right=x;
        long mid;
        while (left<=right){
            mid=left+((right-left)/2);
           if(mid*mid<x){
               left=mid+1;
           }
           else{
               right=mid-1;
           }
        }
        return Math.toIntExact(right);
    }

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        System.out.println(
        sqrt.mySqrt(100));
    }




}
