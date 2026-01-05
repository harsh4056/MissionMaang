public class ShiftingLetters {

    public String shiftingLetters(String s, int[] shifts) {
        char[]cs= s.toCharArray();
        int n = s.length();
        int[] diff = new int[n + 1];

        for (int i = 0; i < shifts.length; i++) {
            int shift = shifts[i];
            diff[0]+=((shift%26)+26)%26;
            diff[i+1]-=shift;
        }
        int prev=diff[0];
        for (int i = 1; i < diff.length; i++) {

            int temp=(((diff[i]+prev)%26)+26)%26;
            diff[i]=temp;
            prev=temp;
        }
        for (int i = 0; i < cs.length; i++) {
            int c=cs[i]-'a';
            c=(((c+diff[i])%26)+26)%26;
            cs[i]=(char)(c+'a');

        }
        return new String(cs);
    }
    public static void main(String[] args) {
        ShiftingLetters obj = new ShiftingLetters();

        // Test case 1
        String s1 = "abc";
        int[] shifts1 = {3, 5, 9};
        System.out.println(obj.shiftingLetters(s1, shifts1));
        // Expected: "rpl"

        // Test case 2
        String s2 = "aaa";
        int[] shifts2 = {1, 2, 3};
        System.out.println(obj.shiftingLetters(s2, shifts2));
        // Expected: "gfd"

        // Test case 3
        String s3 = "xyz";
        int[] shifts3 = {1, 1, 1};
        System.out.println(obj.shiftingLetters(s3, shifts3));
        // Expected: "zab"
    }

}
