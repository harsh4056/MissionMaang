public class IsSubsequence {



    public static boolean isSubsequence(String s, String t) {

        int pt1=0;
        int pt2=0;

        if(s.length()==0)
            return true;
        if(t.length()==0)
            return false;



        while (pt1<s.length() && pt2<t.length()){
            if (s.charAt(pt1) == t.charAt(pt2)) {
                pt1++;
                pt2++;

            }
            else {
                pt2++;

            }
        }
         return pt1 == s.length();


    }

    public static void main(String[] args) {
        System.out.println( isSubsequence("bc",  "cbddc"));
    }

}
