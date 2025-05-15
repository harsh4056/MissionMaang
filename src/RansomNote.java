import java.util.HashMap;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {


        HashMap<Character,Integer> dictionary= new HashMap<>();

        for (char c:magazine.toCharArray()) {
            dictionary.put(c,dictionary.getOrDefault(c,0)+1);
        }

        for (char c:ransomNote.toCharArray()) {
           int count = dictionary.getOrDefault(c,0);
           if(count==0) {
               return false;
           }
           else{
               dictionary.put(c,dictionary.getOrDefault(c,0)-1);
           }
        }
        return true;
    }


    /*public boolean canConstruct(String ransomNote, String magazine) {
        int[] counts = new int[26];

        // Step 1: Count characters in magazine
        for (char c : magazine.toCharArray()) {
            counts[c - 'a']++;
        }

        // Step 2: Check if ransomNote can be formed
        for (char c : ransomNote.toCharArray()) {
            if (counts[c - 'a'] == 0) {
                return false;
            }
            counts[c - 'a']--;
        }

        return true;
    }*/


    public static void main(String[] args) {
        RansomNote ransomNote= new RansomNote();
        System.out.println(ransomNote.canConstruct("a","b"));

    }

}
