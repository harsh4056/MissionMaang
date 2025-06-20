import java.util.Arrays;

public class DetermineIfTwoStringsAreClose {
    public boolean closeStrings(String word1, String word2) {

        char[]w1= word1.toCharArray();
        char[]w2= word2.toCharArray();
        int l1=w1.length;
        int l2=w2.length;
        if(l1!=l2){
            return false;
        }

        int[] mapW1= new int[26];
        int[] mapW2= new int[26];

        for (int i = 0; i < l2; i++) {
            mapW2[w2[i]-'a']++;
            mapW1[w1[i]-'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (mapW1[i] <= 0 || mapW2[i] <= 0) {
                if (mapW2[i] != 0 || mapW1[i] != 0) {
                    return false;
                }
            }
        }


        Arrays.sort(mapW2);
        Arrays.sort(mapW1);





        for (int i = 0; i < 26; i++) {
           if(mapW1[i]!=mapW2[i]){
               return false;
           }
        }
        return true;
    }

    public static void main(String[] args) {
        DetermineIfTwoStringsAreClose obj = new DetermineIfTwoStringsAreClose();

        System.out.println(obj.closeStrings("abbzzca", "babzzcz")); // true
        System.out.println(obj.closeStrings("a", "aa")); // false
        System.out.println(obj.closeStrings("cabbba", "abbccc")); // true
    }

}
