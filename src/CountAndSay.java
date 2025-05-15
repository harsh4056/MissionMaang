import java.util.ArrayList;

public class CountAndSay {


    public String countAndSay(int n) {
        String base1="1";
        int nCount=1;
        String answer ="1";
        while (nCount < n) {
            String temp = "";
            char current = answer.charAt(0);
            int count = 1;

            for (int i = 1; i < answer.length(); i++) {
                if (answer.charAt(i) == current) {
                    count++;
                } else {
                    temp += count + "" + current;
                    current = answer.charAt(i);
                    count = 1;
                }
            }
            temp += count + "" + current;
            answer = temp;
            nCount++;
        }


        return answer;


    }


    public static void main(String[] args) {
        CountAndSay countAndSay= new CountAndSay();
        System.out.println(countAndSay.countAndSay(4));
    }

}
