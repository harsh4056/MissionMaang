package practice;

public class FenwickTree1 {
    int[]fenTree;
    int[]nums;
    FenwickTree1(int[] nums){
        this.nums=nums;
        fenTree= new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            updateTree(i,nums[i]);

        }
    }
    public void update(int index,int value){
        int diff=nums[index]-value;
        nums[index]=value;
        updateTree(index,diff);
    }


    public void updateTree(int i, int value){
        i=i+1;
        while (i< fenTree.length){
            fenTree[i]+=value;
            i+=(i & -i);

        }
    }
    public int query(int l,int r){
        int left=prefix(l-1);
        int right=prefix(r);
        return right-left;
    }


    public int prefix(int i){
        int sum=0;
        i=i+1;
        while (i>0){
            sum+=fenTree[i];
            i-=(i & -i);
        }
        return sum;
    }


    public static void main(String[] args) {
        int[]nums= new int[]{4,3,1,7,8};
        FenwickTree1 soln= new FenwickTree1(nums);
        System.out.println(soln.query(2,4));
        System.out.println(soln.query(1,4));
        soln.update(2,-1);
        soln.update(1,4);
        System.out.println(soln.query(2,4));
        System.out.println(soln.query(1,4));
    }
}
