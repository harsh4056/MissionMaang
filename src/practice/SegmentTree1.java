package practice;

public class SegmentTree1 {

    int[] seg;
    int[]nums;
    SegmentTree1(int[]nums){
        seg = new int[nums.length*4];
        this.nums=nums;
        build(0,0,nums.length-1,nums);
    }

    public void build(int i,int left,int right,int[]nums){
        int mid=(left+right)>>>1;

        if(left==right){


            seg[i]=nums[left];
            return;
        }
        build((i<<1)+1,left,mid,nums);
        build((i<<1)+2,mid+1,right,nums);
         seg[i]= seg[i*2+1]+ seg[i*2+2];
    }

    public int query(int left,int right){
       return query(0,left,right,0,nums.length-1);
    }
    public int query(int node,int left,int right,int start ,int end){
        if(start>=left && end<=right) return seg[node];
        if(start>right || end<left) return 0;
        int mid=(start+end)>>>1;
        int l= query(node*2+1,left,right,start,mid);
        int r= query(node*2+2,left,right,mid+1,end);
        return l+r;
    }
    public void update(int index,int value){
        update(0,index,value,0,nums.length-1);
    }
    public void update(int node,int index,int value,int left,int right){
        if(left==right){
            seg[node]=value;
            nums[index]=value;
            return;
        }
        int mid=(left+right)>>1;
        if(index<=mid){
            update(node*2+1,index,value,left,mid);
        }
        else{
            update(node*2+2,index,value,mid+1,right);
        }
        seg[node]= seg[node*2+1]+ seg[node*2+2];
    }


    public static void main(String[] args) {
        int[]nums= new int[]{4,3,1,7,8};
        SegmentTree1 segmentTree= new SegmentTree1(nums);
        System.out.println(segmentTree.query(2,4));
        System.out.println(segmentTree.query(1,4));
        segmentTree.update(2,-1);
        segmentTree.update(1,4);
        System.out.println(segmentTree.query(2,4));
        System.out.println(segmentTree.query(1,4));


    }

}
