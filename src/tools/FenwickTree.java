package tools;

class  FenwickTree{
    int[] arr;
    public FenwickTree(int[]nums) {
        arr= new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            update(i,nums[i]);

        }
    }
    public int query(int l,int r){
        int left=prefixQuery(l);
        int right=prefixQuery(r+1);
        return right-left;
    }


    public int prefixQuery(int index){
        int i=index;
        int sum=0;
        while(i>0){
            sum+=arr[i];
            int comp=-i;
            int leftMostSetBit=i&comp;
            i-=leftMostSetBit;
        }
        return sum;
    }
    public void update(int index,int value){
        int i=index+1;
        while(i< arr.length){
            arr[i]+=value;
            int comp=-i;
            int leftMostSetBit=i&comp;
            i+=leftMostSetBit;
        }
    }

    public static void main(String[] args) {
        FenwickTree soln= new FenwickTree(new int[]{1,3,5});
        System.out.println(soln.query(0,2));
        soln.update(1,-1);
        soln.update(2,-3);
        System.out.println(soln.query(0,2));
    }
}