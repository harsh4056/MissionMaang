package tools;

class  FenwickTree{
    int[]arr;
    FenwickTree(int[]nums){
        arr=new int[nums.length+1];
    }
    public void update(int i,int delta){
        while(i<arr.length){
            arr[i]+=delta;

        }
    }

    public static void main(String[] args) {
        FenwickTree soln= new FenwickTree(new int[]{1,3,5});
        //System.out.println(soln.query(0,2));
        soln.update(1,-1);
        soln.update(2,-3);
        //System.out.println(soln.query(0,2));
    }
}