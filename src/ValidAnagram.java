public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {

        int []sArr= new int[26];
        int []tArr= new int[26];

        if(s.length()!=t.length())
            return false;
        for (int i = 0; i < s.length(); i++) {


            sArr[s.charAt(i)-'a']+=1;
            tArr[t.charAt(i)-'a']+=1;
        }
        for (int i = 0; i < tArr.length; i++) {
            int i1 = tArr[i];
            int i2 = sArr[i];
            if(i1!=i2)
                return false;

        }

        return true;
    }

    public static void main(String[] args) {
        ValidAnagram.isAnagram("a","ab");
    }
}
