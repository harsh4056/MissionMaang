import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordDictHashSet = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];
        boolean ans= checkWord(s, 0, wordDictHashSet, memo);
        return ans;
        //return dfs( 0, s,wordDictHashSet);
    }

    public boolean checkWord(String s, int position, HashSet<String> wordDict, Boolean[] memo) {


        if(position>s.length()){
            return false;
        }
        if(position==s.length()){
            return true;
        }
        if(memo[position]!=null) {
            return  memo[position];
        }
        boolean ans=false;
        for (int j = position+1; j <=s.length() ; j++) {
            String word=s.substring(position,j);

            ans = wordDict.contains(word) && checkWord(s,j,wordDict,memo);
            memo[position]=ans;
            if(ans){
                return true;
            }

        }
        return ans;
    }
    boolean dfs(int i, String s, HashSet<String> dict){
        if(i>s.length()){
            return false;
        }
        if(i==s.length()){
            return true;
        }
        for (int j = i+1; j <=s.length() ; j++) {
            String word=s.substring(i,j);
            if(dict.contains(word) && dfs(j,s,dict)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();

        List<TestCase> tests = List.of(
                new TestCase("leetcode", List.of("leet", "code"))
                ,new TestCase("applepenapple", List.of("apple", "pen")),
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
