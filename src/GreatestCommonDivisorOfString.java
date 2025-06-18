public class GreatestCommonDivisorOfString {
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int gcdLen = gcd(len1, len2);
        String candidate = str1.substring(0, gcdLen);

        if (check(candidate, str1) && check(candidate, str2)) {
            return candidate;
        }
        return "";
    }

    private boolean check(String base, String full) {
        int times = full.length() / base.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(base);
        }
        return sb.toString().equals(full);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }


}
