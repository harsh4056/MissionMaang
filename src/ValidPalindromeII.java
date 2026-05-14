public class ValidPalindromeII {

    public boolean validPalindrome(String s) {
        char[]cs=s.toCharArray();
        int l=0;
        int r=cs.length-1;

        while(l<r){
            if(cs[l]==cs[r]){
                l++;
                r--;
            }
            else{
                boolean ans=check(l+1,r,cs)|| check(l,r-1,cs);
                return ans;

            }
        }
        return true;


    }

    public boolean check(int l,int r,char[]cs){
        while(l<r){
            if(cs[l]==cs[r]){
                l++;
                r--;
            }
            else return false;
        }
        return true;
    }
    public static void main(String[] args) {
        ValidPalindromeII soln= new ValidPalindromeII();
        System.out.println(soln.validPalindrome("eedede"));
    }
}
