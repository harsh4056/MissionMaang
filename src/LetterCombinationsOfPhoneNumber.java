import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {





        public List<String> letterCombinations(String digits) {
            String[] map = new String[10];

            map[2] = "abc";
            map[3] = "def";
            map[4] = "ghi";
            map[5] = "jkl";
            map[6] = "mno";
            map[7] = "pqrs";
            map[8] = "tuv";
            map[9] = "wxyz";
            List<String> answer= new ArrayList<>();
            solve(digits.toCharArray(),0,map,new StringBuilder(),answer);
            return answer;



        }
        public void solve(char[] digits,int index,String[]map,StringBuilder sb,List<String> ans){
            if(sb.length()==digits.length){
                if(!sb.isEmpty())
                 ans.add(sb.toString());
                return;
            }
            for(int i=index;i<digits.length;i++){
                char[] letters = map[digits[i]-'0'].toCharArray();
                for(char c:letters){
                    sb.append(c);
                    solve(digits,i+1,map,sb,ans);
                    sb.deleteCharAt(sb.length()-1);
                }
            }

        }

    public static void main(String[] args) {
            LetterCombinationsOfPhoneNumber soln= new LetterCombinationsOfPhoneNumber();
        System.out.println(soln.letterCombinations(""));
        System.out.println(soln.letterCombinations("23"));

    }
}
