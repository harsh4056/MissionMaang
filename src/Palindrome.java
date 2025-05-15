import java.text.Collator;

public class Palindrome {
    public boolean isPalindrome(int x) {
        StringBuilder xBuilder= new StringBuilder(x+"");
        int left=0;
        int right=xBuilder.length()-1;
        while (left<right){
            char leftChar= xBuilder.charAt(left);
            char rightChar= xBuilder.charAt(right);
            if(leftChar!=rightChar)
                return false;
            left++;
            right--;

        }
        return true;

    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        System.out.println(
        palindrome.isPalindrome(121));
    }
}
