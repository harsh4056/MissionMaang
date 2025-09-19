import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {



    public int lengthOfLongestSubstring(String s) {


        int maxLen = 0;
        int l = 0, r = 0;
        int formed = 0;
        int[] freq = new int[128];
        char[] cs = s.toCharArray();
        int n = cs.length;
        while (r < n) {
            char c = cs[r];
            freq[c ]++;
            if (freq[c ] > 1)
                formed++;
            while (l <= r && formed > 0) {
                char cc = cs[l];
                freq[cc]--;
                if (freq[cc] == 1)
                    formed--;
                l++;
            }
            if(formed==0)
                maxLen = Math.max(r-l+1, maxLen);
            r++;

        }
        return maxLen;

    }
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters sol = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(sol.lengthOfLongestSubstring(" "));   // Expected: 3 ("wke")
        System.out.println(sol.lengthOfLongestSubstring("abcabcbb")); // Expected: 3 ("abc")
        System.out.println(sol.lengthOfLongestSubstring("bbbbb"));    // Expected: 1 ("b")

        System.out.println(sol.lengthOfLongestSubstring("dvdf"));     // Expected: 3 ("vdf")
    }


}
