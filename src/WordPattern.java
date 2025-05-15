import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class WordPattern {

    public boolean wordPattern(String pattern, String s) {

        String []sArray=s.split(" ");

        if (pattern.length() != sArray.length) return false;
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> usedChars = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {
            char from = pattern.charAt(i);
            String to = sArray[i];

            if (map.containsKey(from)) {
                // Check if previously mapped character matches current
                if (!Objects.equals(map.get(from), to)) return false;
            } else {
                // If 'to' char is already used by some other 'from' char
                if (usedChars.contains(to)) return false;

                map.put(from, to);
                usedChars.add(to);
            }
        }

        StringBuilder stringBuilder= new StringBuilder();
        for (char c :pattern.toCharArray()) {
            stringBuilder.append(map.get(c)+" ");
        }
        String generatedS= stringBuilder.toString().trim();
        return generatedS.equals(s);
    }

    public static void main(String[] args) {
        WordPattern wordPattern = new WordPattern();
        System.out.println(wordPattern.wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern.wordPattern("abba", "dog cat cat fish"));
        System.out.println(wordPattern.wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(wordPattern.wordPattern("aaa", "aa aa aa aa"));
        System.out.println(wordPattern.wordPattern("jquery", "jquery"));

    }

}
