import java.util.*;

public class WordLadderII {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        List<List<String>> answer= new ArrayList<>();
        if (!wordSet.contains(endWord)) return answer;
        int min=Integer.MAX_VALUE;
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(beginWord, 1));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            if (current.word.equals(endWord)) {
                min=Math.min(min,current.move);
                if(current.move==min) {
                    String[] arr = new String[current.move];

                    Pair traverse = current;
                    int data = traverse.move;
                    for (int i = data - 1; i >= 0; i--) {
                        arr[i] = traverse.word;
                        traverse = traverse.previous;
                    }
                    answer.add(new ArrayList<>(Arrays.asList(arr)));
                }
            }
            List<String > neighbours=getNeighbors(current.word, wordSet);
            for (String neighbor : neighbours) {
                Pair newPair=new Pair(neighbor, current.move + 1);
                newPair.previous=current;
                queue.offer(newPair);
                if(!neighbor.equals(endWord))
                    wordSet.remove(neighbor);  // remove directly to mark as visited
            }
        }
        return answer;
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
        Pair previous=null;
        public Pair(String word, int move) {
            this.word = word;
            this.move = move;
        }
    }



    public static void main(String[] args) {
        WordLadderII wl = new WordLadderII();

        // Test Case 1
        String beginWord1 = "red";
        String endWord1 = "tax";
        List<String> wordList1 = Arrays.asList("ted","tex","red","tax","tad","den","rex","pee");
        List<List<String>> result1 = wl.findLadders(beginWord1, endWord1, wordList1);
        System.out.println(result1);

        // Test Case 2
        String beginWord2 = "hit";
        String endWord2 = "cog";
        List<String> wordList2 = Arrays.asList("hot", "dot", "dog", "lot", "log");
        List<List<String>> result2 = wl.findLadders(beginWord2, endWord2, wordList2);
        System.out.println(result2);

        // Test Case 3
        String beginWord3 = "game";
        String endWord3 = "math";
        List<String> wordList3 = Arrays.asList("gave", "gath", "mate", "math", "gate");
        List<List<String>> result3 = wl.findLadders(beginWord3, endWord3, wordList3);
        System.out.println(result3);
    }




}
