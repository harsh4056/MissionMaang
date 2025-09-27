public class ValidPalindromeII {

    public boolean validPalindrome(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int l = 0;
        int r = n - 1;
        int count = 0;
        while (l <= r) {
            char left=cs[l];
            char right=cs[r];
            if (cs[l] != cs[r]) {
                if (cs[l + 1] == cs[r]) {
                    l++;
                    count++;
                } else if (cs[l] == cs[r - 1]) {
                    r--;
                    count++;
                }
                else
                return false;
            } else {
                r--;
                l++;
            }
        }
        return count <= 1;
    }

    public static void main(String[] args) {
        ValidPalindromeII soln= new ValidPalindromeII();
        System.out.println(soln.validPalindrome("eedede"));
    }
}
