public class ShiftingLettersII {

    public String shiftingLetters(String s, int[][] shifts) {
        char[]cs= s.toCharArray();

        int []diff= new int[cs.length+1];
        for (int[] shift : shifts) {
            int st=shift[0];
            int et=shift[1];
            int dir=shift[2];
            if(dir==0){

                diff[st]--;
                diff[et+1]++;
            }
            if(dir==1){
                diff[st]++;
                diff[et+1]--;
            }
            
        }
        int prev=diff[0];
        for (int i = 1; i < diff.length; i++) {
             
            int temp=diff[i]+prev;
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
        ShiftingLettersII obj = new ShiftingLettersII();

        // Test case 1
        String s1 = "abc";
        int[][] shifts1 = {
                {0, 1, 0},
                {1, 2, 1},
                {0, 2, 1}
        };
        System.out.println(obj.shiftingLetters(s1, shifts1));
        // Expected: "ace"

        // Test case 2
        String s2 = "aaa";
        int[][] shifts2 = {
                {0, 2, 1},
                {0, 2, 1},
                {1, 1, 0}
        };
        System.out.println(obj.shiftingLetters(s2, shifts2));
        // Expected: "ccc"

        // Test case 3
        String s3 = "xyz";
        int[][] shifts3 = {
                {0, 0, 1},
                {1, 2, 1}
        };
        System.out.println(obj.shiftingLetters(s3, shifts3));
        // Expected: "yza"
    }

}
