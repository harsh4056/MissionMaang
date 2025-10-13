public class MaximumNumberOfGroupsEnteringCompetitionSolved {
    public int maximumGroups(int[] grades) {
        int n=grades.length;
        double sqrt= Math.sqrt(n);
        int a=(int)Math.ceil(sqrt);
        int b=(int)Math.floor(sqrt);
        int x=(a*(a+1))/2;
        int y=(b*(b+1))/2;
        if(x<=n) return a;
        else return b;
    }

    public static void main(String[] args) {
        MaximumNumberOfGroupsEnteringCompetitionSolved soln= new MaximumNumberOfGroupsEnteringCompetitionSolved();
        System.out.println(soln.maximumGroups(new int[]{2,31,41,31,36,46,33,45,47,8,31,6,12,12,15,35}));
    }
}
