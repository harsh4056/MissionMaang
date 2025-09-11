public class SortVowelsInAString {

    public String sortVowels(String s) {
        char[] original= s.toCharArray();
        int n=original.length;
        int[] letters= new int[127];
        for(int i=0;i<n;i++){
            char c= original[i];
            if(isVowel(c)){
                letters[c]++;
            }
        }
        int index=0;
        for(int i=0;i<n;i++){
            char c= original[i];
            if(isVowel(c)){
                while(letters[index]<=0){
                    index++;
                }
                letters[index]--;
                original[i]=(char)index;
            }
        }

        return new String(original,0,n);


    }
    public boolean isVowel(char c){
        int val=0;
        if(c>='A' && c<='Z'){
            val=c-'A';
        }
        else{
            val=c-'a';
        }
        return val == (0) || val == 'e' - 'a' || val == 'i' - 'a' || val == 'o' - 'a' || val == 'u' - 'a';
    }
    public static void main(String[] args) {
        SortVowelsInAString solver = new SortVowelsInAString();

        // Test case 1
        String input1 = "lEetcOde";
        String result1 = solver.sortVowels(input1);
        System.out.println("Input: " + input1 + " -> Output: " + result1);
        // Expected: "holle" (vowels 'e','o' sorted as 'e','o' but placed in order)

        // Test case 2
        String input2 = "leetcode";
        String result2 = solver.sortVowels(input2);
        System.out.println("Input: " + input2 + " -> Output: " + result2);
        // Expected: "leotcede" (vowels 'e','e','o','e' sorted as 'e','e','e','o')

        // Test case 3
        String input3 = "programming";
        String result3 = solver.sortVowels(input3);
        System.out.println("Input: " + input3 + " -> Output: " + result3);
        // Expected: "prigrammong" (vowels 'o','a','i' sorted as 'a','i','o')
    }

}
