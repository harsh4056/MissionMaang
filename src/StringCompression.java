public class StringCompression {

    public int compress(char[] chars) {
        int count=0;

        char prevChar=chars[0];
        char c='0';
        StringBuilder answer= new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
             c = chars[i];
            if(c==prevChar){
                count++;
            }
            else{
                answer.append(prevChar);
                if(count>1){

                    answer.append(count);

                }
                count=1;

                prevChar=c;
            }
        }
        answer.append(prevChar);
        if(count>1){
            answer.append(count);
        }
        char[]answerChar=answer.toString().toCharArray();
        for (int i = 0; i < chars.length && i<answerChar.length; i++) {
             chars[i]=answerChar[i];

        }
        return answer.length();
    }

    public static void main(String[] args) {
        StringCompression sc = new StringCompression();

        char[] test1 = {'a','a','b','b','c','c','c'};
        System.out.println(sc.compress(test1)); // Expected: 6

        char[] test2 = {'a'};
        System.out.println(sc.compress(test2)); // Expected: 1

        char[] test3 = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(sc.compress(test3)); // Expected: 4
    }

}
