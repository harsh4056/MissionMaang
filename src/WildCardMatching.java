public class WildCardMatching {

    public boolean isMatch(String s, String p) {



        Boolean[][]memo= new Boolean[s.length()][p.length()];

       dfs(s,p,0,0,memo);

        return memo[0][0];
    }

    boolean dfs(String s, String pattern, int i, int j, Boolean[][] memo){
        if (i >= s.length() || j >= pattern.length()) return false;
        if(i==s.length()-1 && j==pattern.length()-1){
            return s.charAt(i)==pattern.charAt(j) ||pattern.charAt(j)=='?'||pattern.charAt(j)=='*';
        }
        if (memo[i][j] != null) return memo[i][j];

       if(s.charAt(i)== pattern.charAt(j) || pattern.charAt(j)=='?'){
           memo[i][j]= dfs(s, pattern, i + 1, j + 1, memo);
       }
       else {
           memo[i][j]= dfs(s, pattern, i + 1, j , memo);
       }
       /*else if(pattern.charAt(j)=='*'){
           memo[i][j]=dfs(s,pattern,i+1,j,memo);
       }*/


        return memo[i][j];

    }


        public static void main(String[] args) {
            WildCardMatching matcher = new WildCardMatching();

            System.out.println(matcher.isMatch("adceb", "*a*b"));    // true
            System.out.println(matcher.isMatch("adceb", "*a?b"));    // false
            System.out.println(matcher.isMatch("adceb", "?a*b"));    // false
            System.out.println(matcher.isMatch("adceb", "?a?b"));    // false
            System.out.println(matcher.isMatch("", "***"));          // true
            System.out.println(matcher.isMatch("", "*?*"));          // false
            System.out.println(matcher.isMatch("a", ""));            // false
            System.out.println(matcher.isMatch("a", "***"));         // true
            System.out.println(matcher.isMatch("a", "*?*"));         // true
            System.out.println(matcher.isMatch("a", "?**"));         // true
            System.out.println(matcher.isMatch("a", "**?"));         // true
            System.out.println(matcher.isMatch("", ""));             // true
            System.out.println(matcher.isMatch("aa", "*aaa*"));      // false
        }




}
