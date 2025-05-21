import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
            int wordsIdx=0;
            List<String> list= new ArrayList<>();
        while(wordsIdx<words.length){
            int length=0;
            int width=maxWidth;
            List<String> temp=new ArrayList<>();
            while(wordsIdx<words.length && length+words[wordsIdx].length()<=maxWidth){
                    temp.add(words[wordsIdx]);
                    length+=words[wordsIdx].length()+1;
                    width-=words[wordsIdx].length();
                    wordsIdx++;
            }

            int spaces=width;
            int totalWordsInAline=temp.size();
            int space=totalWordsInAline>1?spaces/(totalWordsInAline-1):0;
            StringBuilder stringBuilder= new StringBuilder();
            for (int i = 0; i < totalWordsInAline; i++) {
                String word = temp.get(i);
                stringBuilder.append(word);

                if(totalWordsInAline>1 &&spaces>0){
                    for (int j = 0; j < space; j++) {
                        stringBuilder.append(" ");
                        spaces--;
                    }


                }

                if(i==totalWordsInAline-1){
                    while (spaces>0){
                        stringBuilder.append(" ");
                        spaces--;
                    }
                }

            }
            list.add(stringBuilder.toString());



        }
        return list;


    }

    public static void main(String[] args) {
        String[] words = {"What","must","be","acknowledgment","shall","be"};
        int maxWidth = 16;
        TextJustification textJustification= new TextJustification();
        List<String> result = textJustification.fullJustify(words, maxWidth);

        for (String line : result) {
            System.out.println("\"" + line + "\"");
        }
    }



}
