public class CountTheNumberOfComputerUnlockingPermutations {
    public int countPermutations(int[] complexity) {
        int n=complexity.length;
        int count=0;
        for(int i=1;i<n;i++){
            if(complexity[0]<complexity[i]) count++;
        }
        int div=1_000_000_007;
        long data=1;
        if(count==n-1){

            for(int i=1;i<=n-1;i++){
                data=((data*i)%div);
            }
            return Math.toIntExact(data);

        }
        return 0;
    }

}
