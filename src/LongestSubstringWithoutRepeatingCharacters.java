import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {



    public int lengthOfLongestSubstring(String s) {

        int start=0;
        int end=0;
        HashSet<Character> set= new HashSet<>();
        char []arr= s.toCharArray();
        int maxLength=0;

        for (char c : arr) {
            while (set.contains(c)) {
                set.remove(arr[start]);
                start++;

            }
            end++;
            set.add(c);
            maxLength = Math.max(maxLength, end - start);
        }

        return maxLength;


    }
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();

        String s1 = "abcabcbb";
        System.out.println("Input: " + s1 + " | Output: " + obj.lengthOfLongestSubstring(s1));

        String s2 = "bbbbb";
        System.out.println("Input: " + s2 + " | Output: " + obj.lengthOfLongestSubstring(s2));

        String s3 = "pwwkew";
        System.out.println("Input: " + s3 + " | Output: " + obj.lengthOfLongestSubstring(s3));

        String s4 = "abbac";
        System.out.println("Input: " + s4 + " | Output: " + obj.lengthOfLongestSubstring(s4));

        String s5 = "abbdc";
        System.out.println("Input: " + s5 + " | Output: " + obj.lengthOfLongestSubstring(s5));


        String s6 = "dvdf";
        System.out.println("Input: " + s6 + " | Output: " + obj.lengthOfLongestSubstring(s6));

    }

}
