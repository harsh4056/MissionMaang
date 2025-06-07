import java.util.*;

public class SubstringWithConcatenationAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list= new ArrayList<>();
        if (words.length == 0 || s.isEmpty()) return list;

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        // use HashMap instead of HashSet, to handle duplicate words
        HashMap<String, Integer> mainMap = new HashMap<>();
        for (String word : words) {
            mainMap.put(word, mainMap.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i <= s.length() - totalLen; i++) {
            HashMap<String, Integer> tempMap = new HashMap<>(mainMap);
            int j = 0;
            while (j < wordCount) {
                int wordIndex = i + j * wordLen;
                String word = s.substring(wordIndex, wordIndex + wordLen);
                if (tempMap.containsKey(word)) {
                    tempMap.put(word, tempMap.get(word) - 1);
                    if (tempMap.get(word) == 0) {
                        tempMap.remove(word);
                    }
                } else {
                    break;
                }
                j++;
            }
            if (tempMap.isEmpty()) {
                list.add(i);
            }
        }

        return list;
    }
}
