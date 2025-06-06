import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(beginWord, 1));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            if (current.word.equals(endWord)) return current.move;

            for (String neighbor : getNeighbors(current.word, wordSet)) {
                queue.offer(new Pair(neighbor, current.move + 1));
                wordSet.remove(neighbor);  // remove directly to mark as visited
            }
        }
        return 0;
    }

    public List<String> getNeighbors(String word, Set<String> wordSet) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char original = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == original) continue;
                chars[i] = c;
                String newWord = new String(chars);
                if (wordSet.contains(newWord)) neighbors.add(newWord);
            }
            chars[i] = original;
        }
        return neighbors;
    }


    class Pair{
        String word="";
        int move=0;

        public Pair(String word, int move) {
            this.word = word;
            this.move = move;
        }
    }
    public static void main(String[] args) {
        WordLadder wl = new WordLadder();

        // Test Case 1
        String beginWord1 = "hit";
        String endWord1 = "cog";
        List<String> wordList1 = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        int result1 = wl.ladderLength(beginWord1, endWord1, wordList1);
        printResult(result1);

        // Test Case 2
        String beginWord2 = "hit";
        String endWord2 = "cog";
        List<String> wordList2 = Arrays.asList("hot", "dot", "dog", "lot", "log");
        int result2 = wl.ladderLength(beginWord2, endWord2, wordList2);
        printResult(result2);

        // Test Case 3
        String beginWord3 = "game";
        String endWord3 = "math";
        List<String> wordList3 = Arrays.asList("gave", "gath", "mate", "math", "gate");
        int result3 = wl.ladderLength(beginWord3, endWord3, wordList3);
        printResult(result3);
    }

    public static void printResult(int result) {
        System.out.println("Ladder Length: " + result);
    }
}
