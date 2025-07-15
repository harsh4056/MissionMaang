public class FirstUniqueCharacter {

    public int firstUniqChar(String s) {
        int[]hash= new int[26];
        char []arr=s.toCharArray();
        for(int i=arr.length-1;i>=0;i--){
            hash[arr[i]-'a']++;
        }
        for (int i = 0; i < arr.length; i++) {
            if(hash[arr[i]-'a']==1){
                return i;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueCharacter solution = new FirstUniqueCharacter();
        System.out.println(solution.firstUniqChar("dddccdbba"));
    }
}
