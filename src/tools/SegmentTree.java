package tools;

public class SegmentTree {
    int[] seg;
    int[]arr;
    SegmentTree(int[]arr){
        seg= new int[arr.length*4];
        this.arr=arr;
        build(0,arr.length-1,0);
    }

    public void build(int index,int high,int low){
        if(low==high){
            seg[index]=arr[low];
            return;
        }

        int mid=low+high/2;
        build((index*2)+1,mid,low);
        build((index*2)+2,mid,low);
        seg[index]=seg[(index*2)+1]+seg[(index*2)+2];
    }

    public int query(int low ,int high){
        return query(0,low,high,0,arr.length-1);
    }

    public int query(int segNode,int low ,int high,int start,int end){
        if(low<=start && end<=high) return seg[segNode];
        if(low<start|| high>end) return 0;
        int mid=(start+end)/2;
        int left=query(segNode*2+1,low,high,start,mid);
        int right=query(segNode*2+2,low,high,mid+1,high);
        return left+right;
    }

    public  void update(int segNode,int start,int end,int idx,int val){
        if (start == end) {
            seg[segNode] = val;
            return;
        }
        int mid = (start + end) / 2;
        if (idx <= mid)
            update(2 * segNode + 1, start, mid, idx, val);
        else
            update(2 * segNode + 2, mid + 1, end, idx, val);
        seg[segNode] = seg[2 * segNode + 1] + seg[2 * segNode + 2];
    }
    public void update(int idx, int val) {
        update(0, 0, arr.length-1, idx, val);
    }


}
