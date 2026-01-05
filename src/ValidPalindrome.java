public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        char[]cs=s.toCharArray();
        StringBuilder sb= new StringBuilder();
        for(char c:cs){
            if(c>='a' && c<='z'){
                sb.append(c);
            }
        }
        String ss=sb.toString();
        cs=ss.toCharArray();
        int n=cs.length;
        for(int i=0;i<(n/2);i++){
            if (cs[i] != cs[n - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome= new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome("0P"));
        System.out.println(validPalindrome.isPalindrome("Was it a car or a cat I saw?"));
    }
}
