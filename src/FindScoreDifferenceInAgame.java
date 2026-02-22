public class FindScoreDifferenceInAgame {
    public int scoreDifference(int[] nums) {
        int[] p1= new int[1];
        int[] p2= new int[1];
        int[]curr=p1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==1){
                if(curr==p2){
                    curr=p1;
                }
                else{
                    curr=p2;
                }
            }

            if((i+1)%6==0){
                if(curr==p2){
                    curr=p1;
                }
                else{
                    curr=p2;
                }
            }
            curr[0]+=nums[i];
        }

        return p1[0]-p2[0];


    }

    public static void main(String[] args) {
        FindScoreDifferenceInAgame soln= new FindScoreDifferenceInAgame();
        System.out.println(soln.scoreDifference(new int[]{2,4,2,1,2,1}));
    }
}
