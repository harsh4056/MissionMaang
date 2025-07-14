public class BackSpaceStringCompare {

    public boolean backspaceCompare(String s, String t) {
        int m=s.length();
        int n=t.length();
        StringBuilder ss= new StringBuilder();
        StringBuilder st= new StringBuilder();
        for (int i = 0; i < m; i++) {
            char c=s.charAt(i);
            if(c=='#' ){
                if(!ss.isEmpty())
                 ss.deleteCharAt(ss.length()-1);
            }
            else{
                ss.append(c);
            }
        }

        for (int i = 0; i < n; i++) {
            char c=t.charAt(i);
            if(c=='#'){
                if(!st.isEmpty())
                 st.deleteCharAt(st.length()-1);
            }
            else{
                st.append(c);
            }
        }
        return ss.compareTo(st)==0;
    }

    public static void main(String[] args) {
        BackSpaceStringCompare solution = new BackSpaceStringCompare();

      /*  String s1 = "ab#c", t1 = "ad#c";
        System.out.println(solution.backspaceCompare(s1, t1)); // Expected: true

        String s2 = "ab##", t2 = "c#d#";
        System.out.println(solution.backspaceCompare(s2, t2)); // Expected: true*/

        String s3 = "y#fo##f", t3 = "y#f#o##f";
        System.out.println(solution.backspaceCompare(s3, t3)); // Expected: false
    }

}
