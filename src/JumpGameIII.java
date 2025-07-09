public class JumpGameIII {


    public boolean canReach(int[] arr, int start) {
        if(start<0 ||start>=arr.length|| arr[start]==-1){
            return false;
        }
        if(arr[start]==0){
            return true;
        }

        int temp=arr[start];
        arr[start]=-1;
        if(canReach(arr,start+temp)||canReach(arr,start-temp)){
            return true;
        }
        arr[start]=temp;
        return false;


    }
    public static void main(String[] args) {
        JumpGameIII solution = new JumpGameIII();

    /*    int[] arr1 = {4,2,3,0,3,1,2};
        System.out.println(solution.canReach(arr1, 5)); // true

        int[] arr2 = {4,2,3,0,3,1,2};
        System.out.println(solution.canReach(arr2, 0)); // true
*/
        int[] arr3 = {3,0,2,1,2};
        System.out.println(solution.canReach(arr3, 2)); // false
    }


}
