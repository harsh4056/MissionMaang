import tools.SegmentTree;

import java.util.Arrays;

public class CountNonInversions {


    public static class SegmentTree {
        long[] seg;
        int[]arr;
        int n;
        SegmentTree( int[]arr){
            n=arr.length;
            seg= new long[n*4];
            this.arr=arr;
            build(0,0,n-1);
        }


        public void build(int node,int start,int end){
            if(start==end){
                seg[node]=1;
                return;
            }
            int mid=(start+end)/2;
            build(node*2+1,start,mid);
            build(node*2+2,mid+1,end);
            int nonInv=compareAndGive(start,mid,mid+1,end);

            seg[node]=seg[node*2+1]+seg[node*2+2]+nonInv;

        }
        public long query(int left,int right){

            return query(0,left,right,0,n-1);
        }

        public long query(int node,int left,int right,int start,int end){
            if(start>=left && end<=right) return seg[node];
            if(start>right || end<left) return 0;
            int mid=(start+end)/2;

            long l=query(node*2+1,left,right,start,mid);
            long r=query(node*2+2,left,right,mid+1,end);

            return l+r;
        }
        public int compareAndGive(int l1,int r1,int l2,int r2){
            int i = l1, j = l2;
            int count = 0;

            // count non-inversions
            while (i <= r1 && j <= r2) {
                if (arr[i] <= arr[j]) {
                    count += (r1 - i + 1);
                    j++;
                } else {
                    i++;
                }
            }

            // merge descending
            int p1 = l1, p2 = l2;
            int k = 0;
            int[] temp = new int[(r1 - l1 + 1) + (r2 - l2 + 1)];

            while (p1 <= r1 && p2 <= r2) {
                if (arr[p1] >= arr[p2]) temp[k++] = arr[p1++];
                else temp[k++] = arr[p2++];
            }
            while (p1 <= r1) temp[k++] = arr[p1++];
            while (p2 <= r2) temp[k++] = arr[p2++];

            // write back
            k = 0;
            for (int idx = l1; idx <= r2; idx++) arr[idx] = temp[k++];

            return count;  // non-inversion count
        }




    }

    public long[] countStableSubarrays(int[] nums, int[][] queries) {
        SegmentTree segmentTree= new SegmentTree(nums);
        long[]answer= new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            answer[i]=segmentTree.query(query[0], query[1]);
        }
        return answer;
    }
    public static void main(String[] args) {
        CountNonInversions sol = new CountNonInversions();

        int[] nums1 = {21,3,4,17};
        int[][] q1 = {{1, 3}};
        long[] res1 = sol.countStableSubarrays(nums1, q1);
        System.out.println(Arrays.toString(res1)); // expected: [6]

        int[] nums2 = {3, 1, 2};
        int[][] q2 = {{0, 1}, {1, 2},{0,2}};
        long[] res2 = sol.countStableSubarrays(nums2, q2);
        System.out.println(Arrays.toString(res2)); // expected: [4, 3]

        int[] nums3 = {2,2};
        int[][] q3 = {{0, 1}, {0, 0}};
        long[] res3 = sol.countStableSubarrays(nums3, q3);
        System.out.println(Arrays.toString(res3)); // expected: [5, 3]
    }


}
