public class FirstUniqueCharacterInString {


    public int firstUniqChar(String s) {

        if(s.length()==1)
            return 1;
        int[] letters= new int[26];
        int left=0;
        int right=s.length()-1;
        while(left<=right){
            letters[s.charAt(left)-'a']++;
            letters[s.charAt(right)-'a']++;
            left++;
            right--;
        }
        for (int i = 0; i < s.length(); i++) {
           if(letters[s.charAt(i)-'a']==1){
               return i;
           }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueCharacterInString soln= new FirstUniqueCharacterInString();
        System.out.println(
        soln.firstUniqChar("z"));
    }
}
