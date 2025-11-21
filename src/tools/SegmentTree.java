package tools;

public class SegmentTree {
    int[] seg;
    int[]arr;
    int n;
    SegmentTree( int[]arr){
         n=arr.length;
        seg= new int[n*4];
        this.arr=arr;
        build(0,0,n-1);
    }


    public void build(int node,int start,int end){
        if(start==end){
            seg[node]=arr[end];
            return;
        }
        int mid=(start+end)/2;
        build(node*2+1,start,mid);
        build(node*2+2,mid+1,end);
        seg[node]=seg[node*2+1]+seg[node*2+2];

    }
    public int query(int left,int right){

        return query(0,left,right,0,n-1);
    }

    public int query(int node,int left,int right,int start,int end){
        if(start>=left && end<=right) return seg[node];
        if(start>right || end<left) return 0;
        int mid=(start+end)/2;

        int l=query(node*2+1,left,right,start,mid);
        int r=query(node*2+2,left,right,mid+1,end);
        return l+r;
    }


    public static void main(String[] args) {
        int[]arr= new int[]{1,2,1,3,4};
        SegmentTree segmentTree= new SegmentTree(arr);
        //System.out.println(segmentTree.query(0,2));
        System.out.println(segmentTree.query(0,4));
        System.out.println(segmentTree.query(3,4));

    }


}
