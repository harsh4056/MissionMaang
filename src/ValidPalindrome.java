public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if(s.length()==0 || s.length()==1)
            return true;
        char a='a';
        char A='A';

        char z='z';
        char Z='Z';
        int left=0;
        int right=s.length()-1;
        while(left<=right){
            char leftChar= s.charAt(left);
            char rightChar= s.charAt(right);
            if(leftChar>=A && leftChar<=Z || leftChar>=a && leftChar<=z || (leftChar >= '0' && leftChar <= '9')) {
                if(rightChar>=A && rightChar<=Z || rightChar>=a && rightChar<=z || (rightChar >= '0' && rightChar <= '9')) {
                    if(leftChar>=A && leftChar<=Z) {
                        leftChar= (char) (leftChar+(a-A));
                    }
                    if(rightChar>=A && rightChar<=Z){
                        rightChar= (char) (rightChar+(a-A));
                    }
                    if(leftChar==rightChar){
                        if(left==right || Math.abs(left-right)==1){
                            return true;
                        }
                        else{
                            left++;
                            right--;
                        }
                    }
                    else {
                        return false;
                    }
                }
                else{
                    right--;
                }
            }else{
                left++;
            }


        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome= new ValidPalindrome();
        validPalindrome.isPalindrome(",.");
    }
}
