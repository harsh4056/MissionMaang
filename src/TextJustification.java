import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
            int wordsIdx=0;
            List<String> list= new ArrayList<>();
        while(wordsIdx<words.length){
            List<String >  data= new ArrayList<>();
            int width=maxWidth;
            while(width>0){
                width=width-words[wordsIdx].length();
                data.add(words[wordsIdx]);
                wordsIdx++;
            }




        }
        return list;


    }

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        TextJustification textJustification= new TextJustification();
        List<String> result = textJustification.fullJustify(words, maxWidth);

        for (String line : result) {
            System.out.println("\"" + line + "\"");
        }
    }



}
