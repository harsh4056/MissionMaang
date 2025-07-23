import java.util.Arrays;

public class LongestStringChain {

    public int longestStrChain(String[] words) {
        int[]dp= new int[words.length];

        Arrays.fill(dp,1);

        Arrays.sort(words, (a, b) -> {
            if (a.length() != b.length())
                return Integer.compare(a.length(), b.length());
            return a.compareTo(b);
        });

        int maximum=-1;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <i ; j++) {
                String current=words[i];
                String child=words[j];
                if(dp[i] < 1 + dp[j]&&checkLetters(current,child)&& current.length()==child.length()+1 ){
                    dp[i]=1+dp[j];

                }
            }
            if(maximum<dp[i]){
                maximum=dp[i];
            }

        }
        return maximum;
    }
    public boolean checkLetters(String parent,String child){

        char[]c=child.toCharArray();
        char[]p=parent.toCharArray();
        if(p.length!=c.length+1){
            return false;
        }
        int index1=0,index2=0;
        while (index2<c.length&& index1<p.length) {
            if (c[index2] == p[index1]) {
                index2++;

            }
            index1++;
        }
        return index2==c.length;
    }

    public static void main(String[] args) {
        LongestStringChain solution = new LongestStringChain();

        String[] test1 = {"a","b","ba","bca","bda","bdca"};
        System.out.println(solution.longestStrChain(test1)); // Expected: 4

        String[] test2 = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        System.out.println(solution.longestStrChain(test2)); // Expected: 5

        String[] test3 = {"abcd","dbqca"};
        System.out.println(solution.longestStrChain(test3)); // Expected: 1
    }

}
