import java.util.*;

public class NumberOfMatchingSubsequences {
    public int numMatchingSubseq(String s, String[] words) {
        int count=0;
        HashMap<Character, List<Integer>> map = new HashMap<>();

        char[]main=s.toCharArray();
        for (int i = 0; i < main.length; i++) {
            char c = main[i];
            if(map.containsKey(c)){
                map.get(c).add(i);
            }
            else{
                List<Integer> list= new ArrayList<>();
                list.add(i);
                map.put(c,list);
            }

        }
        for (String word : words) {
            char[] candidate = word.toCharArray();
            int prevIndex = -1;
            int i = 0;

            for (; i < candidate.length; i++) {
                char c = candidate[i];

                if (!map.containsKey(c)) break;

                List<Integer> list = map.get(c);

                // Binary search: find first index > prevIndex
                int lo = 0, hi = list.size() - 1;
                int nextPos = -1;

                while (lo <= hi) {
                    int mid = lo + (hi - lo) / 2;
                    if (list.get(mid) > prevIndex) {
                        nextPos = list.get(mid);
                        hi = mid - 1;
                    } else {
                        lo = mid + 1;
                    }
                }

                if (nextPos == -1) break;

                prevIndex = nextPos;
            }

            if (i == candidate.length) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfMatchingSubsequences obj = new NumberOfMatchingSubsequences();

     /*   String s1 = "abc";
        String[] words1 = { "abc","acb"};
        System.out.println(obj.numMatchingSubseq(s1, words1)); // Expected: 3*/

        String s2 = "dsahjpjauf";
        String[] words2 = {"ahjpjau","ja"};
        System.out.println(obj.numMatchingSubseq(s2, words2)); // Expected: 2

        String s3 = "abcdef";
        String[] words3 = {"abc", "def", "abcd", "ef"};
        System.out.println(obj.numMatchingSubseq(s3, words3)); // Expected: 4
    }

}
