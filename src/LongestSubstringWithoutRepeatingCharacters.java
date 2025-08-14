import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {



    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set= new HashSet<>();
        char []arr=s.toCharArray();
        int size=0;
        int start=0;
        for(char c:arr){
            if(set.contains(c)){
                while(set.contains(c)){

                    set.remove(arr[start++]);
                }
                set.add(c);
            }
            else{
                set.add(c);
            }
            size=Math.max(size, set.size());


        }
        return size;

    }
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters sol = new LongestSubstringWithoutRepeatingCharacters();

        System.out.println(sol.lengthOfLongestSubstring("abcabcbb")); // Expected: 3 ("abc")
        System.out.println(sol.lengthOfLongestSubstring("bbbbb"));    // Expected: 1 ("b")
        System.out.println(sol.lengthOfLongestSubstring("pwwkew"));   // Expected: 3 ("wke")
        System.out.println(sol.lengthOfLongestSubstring("dvdf"));     // Expected: 3 ("vdf")
    }


}
