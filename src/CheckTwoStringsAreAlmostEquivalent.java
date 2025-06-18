public class CheckTwoStringsAreAlmostEquivalent {

    public boolean checkAlmostEquivalent(String word1, String word2) {
        int []w1= new int[26];
        char[]w1Array= word1.toCharArray();
        char[]w2Array= word2.toCharArray();
        int n=word1.length();
        for (int i = 0; i < n; i++) {
           w1[w1Array[i]-'a']++;
           w1[w2Array[i]-'a']--;
        }

        for (int i = 0; i< 26; i++) {
           if(Math.abs(w1[i])>3){
               return false;
           }
        }
        return true;
    }
}
