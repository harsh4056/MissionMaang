import java.util.HashMap;

public class CountSpecialTriplets {

    public int specialTriplets(int[] nums) {
        HashMap<Integer,Integer> left= new HashMap<>();
        HashMap<Integer,Integer> right= new HashMap<>();

        int div=1_000_000_007;
        long count=0;
        int n=nums.length;
        for(int i=n-1;i>=0;i--){
            right.putIfAbsent(nums[i],0);
            right.put(nums[i],right.get(nums[i])+1);

        }
        for(int i=0;i<n;i++){

            int curr=nums[i];

            int dble=curr<<1;
            right.put(nums[i],right.get(nums[i])-1);
            int l=left.getOrDefault(dble,0);
            int r=right.getOrDefault(dble,0);
            //if(curr!=0)
             count=(count+((long) l *r))%div;
            left.putIfAbsent(nums[i],0);
            left.put(nums[i],left.get(nums[i])+1);


        }
        int z=left.getOrDefault(0,0);
        int zc=(z*(z-1)*(z-2))/6;
        if(zc>0){
            //count+=zc;
        }
        return Math.toIntExact(count);
    }

    public static void main(String[] args) {
        CountSpecialTriplets soln= new CountSpecialTriplets();
        //System.out.println(soln.specialTriplets(new int[]{6,3,6}));
        //System.out.println(soln.specialTriplets(new int[]{8,4,2,8,4}));
        System.out.println(soln.specialTriplets(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
    }
}
