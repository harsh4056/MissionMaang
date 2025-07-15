public class ValidWord {
    public boolean isValid(String word) {

        char []wordArray= word.toCharArray();
        if(wordArray.length<3){
            return false;
        }
        boolean includesVowels=false;
        boolean includesConsonants=false;

        for (char c : wordArray) {
            if (c >= '0' && c <= '9') {
                continue;
            } else if (c >= 'a' && c <= 'z') {

               if(c=='a' ||c=='e'||c=='i'||c=='o'||c=='u'){
                   includesVowels=true;
               }
               else{
                   includesConsonants=true;
               }
            } else if (c >= 'A' && c <= 'Z') {
                if(c=='A' ||c=='E'||c=='I'||c=='O'||c=='U'){
                    includesVowels=true;
                }
                else{
                    includesConsonants=true;
                }

            } else {
                return false;
            }

        }
        return includesConsonants&&includesVowels;


    }

    public static void main(String[] args) {
        ValidWord validWord= new ValidWord();
        System.out.println(validWord.isValid("IS"));
    }
}
