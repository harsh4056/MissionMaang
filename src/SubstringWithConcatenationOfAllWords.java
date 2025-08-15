import java.util.*;

public class SubstringWithConcatenationOfAllWords {




    public List<Integer> findSubstring(String s, String[] words) {Trie trie = new Trie();

        // Assign IDs sequentially
        Map<String, Integer> wordToId = new HashMap<>();
        int nextId = 0;
        for (String word : words) {
            if (!wordToId.containsKey(word)) {
                wordToId.put(word, nextId++);
            }
            trie.insert(word, wordToId.get(word));
        }

        int wordTypes = nextId;
        int[] originalCount = new int[wordTypes];
        for (String word : words) {
            originalCount[wordToId.get(word)]++;
        }

        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int wordTotalLen = Arrays.stream(words).mapToInt(String::length).sum();

        for (int start = 0; start <= n - wordTotalLen; start++) {
            int[] currentCount = new int[wordTypes];
            int index = start;
            Trie current = trie;
            int matchedWords = 0;

            while (index < n) {
                char c = s.charAt(index);
                current = current.tries[c - 'a'];
                if (current == null)
                    break;
                index++;

                if (current.present) {
                    int matchedId = current.wordId;
                    currentCount[matchedId]++;

                    if (currentCount[matchedId] > originalCount[matchedId])
                        break;

                    matchedWords++;
                    current = trie;

                    if (matchedWords == words.length) {
                        ans.add(start);
                        break;
                    }
                }
            }
        }

        return ans;
    }

    public class Trie {
        boolean present = false;
        Trie[] tries;
        Trie root;
        int wordId; // store ID at terminal node

        public Trie() {
            this.tries = new Trie[26];
            this.root = this;
        }

        public Trie(boolean present) {
            this.present = present;
            this.tries = new Trie[26];
        }

        public void insert(String word, int id) {
            Trie current = root;
            for (char c : word.toCharArray()) {
                if (current.tries[c - 'a'] == null) {
                    current.tries[c - 'a'] = new Trie(false);
                }
                current = current.tries[c - 'a'];
            }
            current.present = true;
            current.wordId = id;
        }


    }
    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords obj = new SubstringWithConcatenationOfAllWords();

        // Test case 1
        System.out.println(obj.findSubstring("barfoothefoobarman", new String[]{"foo","bar"}));
        // Expected: [0, 9]

        // Test case 2
        System.out.println(obj.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"}));
        // Expected: [] (no concatenation found)

        // Test case 3
        System.out.println(obj.findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"}));
        // Expected: [6, 9, 12]
    }

}
