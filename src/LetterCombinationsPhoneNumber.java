import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsPhoneNumber {

    List<String> answer;
    HashMap<Character, String> digitLetter;
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty())
            return answer;
        answer=new ArrayList<>();
        digitLetter = new HashMap<>();
        digitLetter.put('2', "abc");
        digitLetter.put('3', "def");
        digitLetter.put('4', "ghi");
        digitLetter.put('5', "jkl");
        digitLetter.put('6', "mno");
        digitLetter.put('7', "pqrs");
        digitLetter.put('8', "tuv");
        digitLetter.put('9', "wxyz");
        combinate(new StringBuilder(),digits.toCharArray(),0);
        return answer;

    }

    public void combinate(StringBuilder combo ,char[] digits,int start){

        if(digits.length== combo.length()){
            answer.add(combo.toString());
            return;

        }
            for (int j = 0; j <digitLetter.get(digits[start]).length(); j++) {
                combo.append(digitLetter.get(digits[start]).charAt(j));
                combinate(combo,digits,start+1);
                combo.deleteCharAt(combo.length()-1);
            }

    }

    public static void main(String[] args) {
        LetterCombinationsPhoneNumber soln=new LetterCombinationsPhoneNumber();
        System.out.println(soln.letterCombinations("677"));
    }

}
