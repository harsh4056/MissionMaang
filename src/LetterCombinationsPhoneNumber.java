import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsPhoneNumber {

    List<String> answer;

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty())
            return answer;
        answer=new ArrayList<>();
        String[] mapping =new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wzyz"};
        combinate(new StringBuilder(),digits.toCharArray(),0,mapping);
        return answer;

    }

    public void combinate(StringBuilder combo ,char[] digits,int start,String[] mapping){

        if(digits.length== combo.length()){
            answer.add(combo.toString());
            return;

        }
            for (int j = 0; j <mapping[digits[start]-'0'].length(); j++) {
                combo.append(mapping[digits[start]-'0'].charAt(j));
                combinate(combo,digits,start+1,mapping);
                combo.deleteCharAt(combo.length()-1);
            }

    }

    public static void main(String[] args) {
        LetterCombinationsPhoneNumber soln=new LetterCombinationsPhoneNumber();
        System.out.println(soln.letterCombinations("677"));
    }

}
