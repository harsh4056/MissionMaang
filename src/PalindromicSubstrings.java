public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        StringBuilder sb= new StringBuilder();
        char[]cs = s.toCharArray();
        sb.append('#');
        for (char c : cs) {
            sb.append(c);
            sb.append('#');
        }
        return 0;

    }
}
