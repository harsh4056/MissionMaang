import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {




    public static List<String> letterCombinations(String digits) {

        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
        List<String> answers= new ArrayList<>();
        if( digits.length()>0){
            String characterSet= phoneMap.get(digits.charAt(0));
            for (int k = 0; k < characterSet.length(); k++) {
                char tc = characterSet.charAt(k);
                answers.add(String.valueOf(tc));
            }
        }
        for (int i = 1; i < digits.length(); i++) {
            List<String> temp=new ArrayList<>();

            String characterSet= phoneMap.get(digits.charAt(i));
            for (int j = 0; j < characterSet.length(); j++) {
                char c=characterSet.charAt(j);

                    for (String t : answers) {
                        String answer = t + c;
                        temp.add(answer);
                    }
            }
            answers.clear();
            answers=temp;


        }
        return answers;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("79"));

    }
}
