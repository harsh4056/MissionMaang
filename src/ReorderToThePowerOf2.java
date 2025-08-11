public class ReorderToThePowerOf2 {

    public boolean reorderedPowerOf2(int n) {

        int[][] map= new int[31][10];
        int gen=1;
        for (int i = 0; i < 31; i++) {
            int current=gen<<i;
            int[] arr=map[i];
            while(current>0){
                int digit=current%10;
                arr[digit]++;
                current=current/10;
            }

        }

        for (int i = 0; i < 31; i++) {
           int []can=map[i];
           int num=n;
           while(num>0){
               int temp=num%10;
               num=num/10;
               can[temp]--;
           }
           boolean found=true;
           for(int j:can){
               if (j != 0) {
                   found = false;
                   break;
               }
           }
           if(found)
               return true;

        }

        return false;
    }

    public static void main(String[] args) {
        ReorderToThePowerOf2 soln= new ReorderToThePowerOf2();
        System.out.println(soln.reorderedPowerOf2(4213));

    }
}
