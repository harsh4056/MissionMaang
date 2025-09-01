import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<Pair> list = new ArrayList<>();
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> {
            if (a.frequency == b.frequency) {
                return a.word.compareTo(b.word);
            }
            return a.frequency - b.frequency;
        });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            minHeap.add(new Pair(entry.getKey(), entry.getValue()));
            if (minHeap.size() > k) {
                minHeap.poll(); // remove least frequent
            }
        }


        List<String> result = new ArrayList<>();
        while(!minHeap.isEmpty()){
            Pair p= minHeap.poll();
            result.add(p.word);
        }
        Collections.reverse(result);


        return result;

    }

    class Pair {
        String word;
        int frequency;

        public Pair(String word, int frequency) {
            this.word = word;
            this.frequency = frequency;
        }
    }
    public static void main(String[] args) {
        TopKFrequentWords solution = new TopKFrequentWords();

        // Test case 1
        String[] words1 = {"i", "love", "leetcode", "i", "love", "coding"};
        int k1 = 2;
        System.out.println(solution.topKFrequent(words1, k1));
        // Expected: ["i", "love"]

        // Test case 2
        String[] words2 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k2 = 4;
        System.out.println(solution.topKFrequent(words2, k2));
        // Expected: ["the", "is", "sunny", "day"]

        // Test case 3
        String[] words3 = {"a", "aa", "aaa"};
        int k3 = 2;
        System.out.println(solution.topKFrequent(words3, k3));
        // Expected: ["a", "aa"]
    }

}
