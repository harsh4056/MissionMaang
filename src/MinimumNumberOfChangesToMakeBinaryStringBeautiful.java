public class MinimumNumberOfChangesToMakeBinaryStringBeautiful {
    public int minChanges(String s) {
        char[] cs=s.toCharArray();
        int a=0;

        for (int i = 0; i < cs.length; i=i+2) {
            char first = cs[i];
            char second = cs[i+1];
            if(first!=second){
                a++;
            }

        }
        return a;
    }

    public static void main(String[] args) {
        MinimumNumberOfChangesToMakeBinaryStringBeautiful soln= new MinimumNumberOfChangesToMakeBinaryStringBeautiful();
        System.out.println(soln.minChanges("1010011101"));
        System.out.println(soln.minChanges("101010"));
        System.out.println(soln.minChanges("1001"));
    }
}
