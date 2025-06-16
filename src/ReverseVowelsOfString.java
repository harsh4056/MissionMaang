import java.util.Stack;

public class ReverseVowelsOfString {


    public String reverseVowels(String s) {
        StringBuilder answer= new StringBuilder(s);
        int left=0;
        int right=s.length()-1;
        while (left<=right){
            char l=s.charAt(left);
            if (l == 'A' || l == 'E' || l == 'I' || l == 'O' || l == 'U' || l == 'a' || l == 'e' || l == 'i' || l == 'o' || l == 'u') {


                char r=s.charAt(right);
                while (!(r == 'A' || r == 'E' || r == 'I' || r == 'O' || r == 'U' || r == 'a' || r == 'e' || r == 'i' || r == 'o' || r == 'u')) {

                    right--;
                    r=s.charAt(right);
                }
                answer.setCharAt(left,r);
                answer.setCharAt(right,l);
                right--;
            }
            left++;

        }
        return answer.toString();
    }
    public static void main(String[] args) {
        ReverseVowelsOfString rev = new ReverseVowelsOfString();

        /*System.out.println(rev.reverseVowels("hello")); // holle*/
        System.out.println(rev.reverseVowels("leetcode")); // leotcede
        System.out.println(rev.reverseVowels("aA")); // Aa
    }

}
