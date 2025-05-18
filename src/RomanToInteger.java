import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public int romanToInt(String s) {

        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        int answer=0;
        int bit=0;
        for(int i=0;i<s.length();){
            char c=s.charAt(i);
            if(i+1<s.length() && romanMap.get(s.charAt(i + 1))>romanMap.get(c)) {
                char cNext = s.charAt(i + 1);
                answer=answer+(romanMap.get(cNext)-romanMap.get(c));
                i=i+2;
            }
            else{

                answer=answer+romanMap.get(s.charAt(i));
                i++;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        RomanToInteger romanToInteger= new RomanToInteger();
        System.out.println(romanToInteger.romanToInt("LVIII"));
    }
}
