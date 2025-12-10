public class TransformArrayToAllEqualElements {
    public boolean canMakeEqual(int[] nums, int k) {
        int n=nums.length;
        int count1=0;
        int[] arr1= new int[n];
        int[] arr2= new int[n];

        for(int i=0;i<n ;i++){
            arr1[i]=nums[i];
            arr2[i]=nums[i];
        }
        for(int i=0;i<n-1 ;i++){
            if(arr1[i]==-1){
                arr1[i]=1;
                arr1[i+1]=-1*arr1[i+1];
                count1++;
            }
        }


        int count2=0;
        for(int i=0;i<n-1 ;i++){
            if(arr2[i]==1){
                arr2[i]=-1;
                arr2[i+1]=-1*arr2[i+1];
                count2++;
            }
        }

        return (count1<=k && arr1[n-1]==1 || count2<=k && arr2[n-1]==-1);

    }

    public static void main(String[] args) {
        TransformArrayToAllEqualElements soln= new TransformArrayToAllEqualElements();
        System.out.println(soln.canMakeEqual(new int[]{-1,1,1,1,-1,-1,-1,1,1},3));
        System.out.println(soln.canMakeEqual(new int[]{1,-1,1},2));
    }
}
