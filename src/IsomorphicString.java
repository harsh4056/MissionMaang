import java.util.HashMap;
import java.util.HashSet;

public class IsomorphicString {

    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) return false;

        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> usedChars = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char from = s.charAt(i);
            char to = t.charAt(i);

            if (map.containsKey(from)) {
                // Check if previously mapped character matches current
                if (map.get(from) != to) return false;
            } else {
                // If 'to' char is already used by some other 'from' char
                if (usedChars.contains(to)) return false;

                map.put(from, to);
                usedChars.add(to);
            }
        }

        return true;

    }

    /*
    *
    * class Solution {
    public boolean isIsomorphic(String s, String t) {
        // Create arrays to store the index of characters in both strings
        int[] indexS = new int[200]; // Stores index of characters in string s
        int[] indexT = new int[200]; // Stores index of characters in string t

        // Get the length of both strings
        int len = s.length();

        // If the lengths of the two strings are different, they can't be isomorphic
        if(len != t.length()) {
            return false;
        }

        // Iterate through each character of the strings
        for(int i = 0; i < len; i++) {
            // Check if the index of the current character in string s
            // is different from the index of the corresponding character in string t
            if(indexS[s.charAt(i)] != indexT[t.charAt(i)]) {
                return false; // If different, strings are not isomorphic
            }

            // Update the indices of characters in both strings
            indexS[s.charAt(i)] = i + 1; // updating index of current character
            indexT[t.charAt(i)] = i + 1; // updating index of current character
        }

        // If the loop completes without returning false, strings are isomorphic
        return true;
    }
}
    * */

    public static void main(String[] args) {
        IsomorphicString isomorphicString= new IsomorphicString();
        System.out.println(
        isomorphicString.isIsomorphic("badc",
                 "baba"));
    }



}
