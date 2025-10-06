import java.util.Arrays;

public class KWeakestRowsInMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[][] ones=new int[mat.length][2];
        int index=0;
        for(int[]arr:mat){
            int left=0;
            int right=arr.length;
            while(left<right){
                int mid=left+(right-left)/2;
                if(arr[mid]==0){
                    right=mid;
                }
                else{
                    left=mid+1;
                }
            }
            ones[index]= new int[]{left,index};
            index++;

        }
        Arrays.sort(ones,(a, b)->{
            if( a[0]==b[0]) {
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });
        int[]ans= new int[k];
        for(int i=0;i<k;i++){
            ans[i]=ones[i][1];
        }
        return ans;
    }

    public static void main(String[] args) {
        KWeakestRowsInMatrix sol = new KWeakestRowsInMatrix();

        int[][] mat1 = {
                {1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}
        };
        int k1 = 3;
        System.out.println(Arrays.toString(sol.kWeakestRows(mat1, k1)));
        // Expected Output: [2, 0, 3]

        int[][] mat2 = {
                {1,0,0,0},
                {1,1,1,1},
                {1,0,0,0},
                {1,0,0,0}
        };
        int k2 = 2;
        System.out.println(Arrays.toString(sol.kWeakestRows(mat2, k2)));
        // Expected Output: [0, 2]

        int[][] mat3 = {
                {1,1},
                {1,0},
                {0,0},
                {1,1}
        };
        int k3 = 2;
        System.out.println(Arrays.toString(sol.kWeakestRows(mat3, k3)));
        // Expected Output: [2, 1]
    }

}
