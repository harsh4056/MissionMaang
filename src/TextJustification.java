import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        int wordsIdx = 0;
        List<String> list = new ArrayList<>();

        while (wordsIdx < words.length) {
            int length = 0;
            int start = wordsIdx;
            // Count how many words fit into this line
            while (wordsIdx < words.length) {
                int wordLen = words[wordsIdx].length();
                if (length + wordLen + (wordsIdx - start) > maxWidth) break; // (wordsIdx - start) is number of spaces needed
                length += wordLen;
                wordsIdx++;
            }

            int numWords = wordsIdx - start;
            int totalSpaces = maxWidth - length;
            StringBuilder sb = new StringBuilder();

            // Last line or single word line → left-justified
            if (wordsIdx == words.length || numWords == 1) {
                for (int i = start; i < wordsIdx; i++) {
                    sb.append(words[i]);
                    if (i != wordsIdx - 1) sb.append(" ");
                }
                // Fill the remaining spaces
                int remaining = maxWidth - sb.length();
                while (remaining-- > 0) sb.append(" ");
            } else {
                int spaces = totalSpaces / (numWords - 1);
                int extra = totalSpaces % (numWords - 1);

                for (int i = start; i < wordsIdx; i++) {
                    sb.append(words[i]);
                    if (i != wordsIdx - 1) {
                        for (int s = 0; s < spaces; s++) sb.append(" ");
                        if (extra-- > 0) sb.append(" ");
                    }
                }
            }

            list.add(sb.toString());
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
