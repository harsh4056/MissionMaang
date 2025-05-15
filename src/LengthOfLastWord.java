public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        boolean found = false;
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ' ' ) {
                if(found)
                    break;
            } else {
                found=true;
                count++;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord= new LengthOfLastWord();
        System.out.println(
        lengthOfLastWord.lengthOfLastWord("count me in  count "));
    }

}
