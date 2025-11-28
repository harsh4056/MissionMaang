class NumArray {
    FenwickTree fw;
    int []nums;
    public NumArray(int[] nums) {
        this.nums=nums;
        fw= new FenwickTree(nums);
    }

    public void update(int index, int val) {

        fw.update(index,val-nums[index]);
        nums[index]=val;
    }

    public int sumRange(int left, int right) {
        return fw.query(left,right);
    }

    static class FenwickTree {
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
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        NumArray numArray = new NumArray(nums);

        System.out.println(numArray.sumRange(0, 2)); // expected 9

        numArray.update(1, 2); // nums becomes [1,2,5]

        System.out.println(numArray.sumRange(0, 2)); // expected 8

        // More test cases
        numArray.update(2, -1); // nums becomes [1,2,-1]
        System.out.println(numArray.sumRange(1, 2)); // expected 1

        numArray.update(0, 5); // nums becomes [5,2,-1]
        System.out.println(numArray.sumRange(0, 1)); // expected 7
    }


}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */