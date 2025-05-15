import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordDictHashSet = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];
        return checkWord(s, 0, wordDictHashSet, memo);
    }

    public boolean checkWord(String s, int position, HashSet<String> wordDict, Boolean[] memo) {
        if (position == s.length()) return true;
        if (memo[position] != null) return memo[position];

        for (int i = position; i < s.length(); i++) {
            String sub = s.substring(position, i + 1);
            if (wordDict.contains(sub)) {
                if (checkWord(s, i + 1, wordDict, memo)) {
                    memo[position] = true;
                    return true;
                }
            }
        }

        memo[position] = false;
        return false;
    }

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();

        List<TestCase> tests = List.of(
                new TestCase("leetcode", List.of("leet", "code")),
                new TestCase("applepenapple", List.of("apple", "pen")),
                new TestCase("catsandog", List.of("cats", "dog", "sand", "and", "cat")),
                new TestCase("aaaaaaa", List.of("aaaa", "aaa")),
                new TestCase("abcd", List.of("a", "abc", "b", "cd"))
        );

        for (TestCase t : tests) {
            boolean result = wb.wordBreak(t.s, t.wordDict);
            System.out.println("Input: " + t.s);
            System.out.println("Dict: " + t.wordDict);
            System.out.println("Can be segmented? " + result);
            System.out.println("------------");
        }
    }

    // Helper class for test cases
    static class TestCase {
        String s;
        List<String> wordDict;

        TestCase(String s, List<String> wordDict) {
            this.s = s;
            this.wordDict = wordDict;
        }
    }
}
