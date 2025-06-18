public class ToLowerCase {
    public String toLowerCase(String s) {

        char []chars= s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if(aChar>= 65 && aChar<=90){
                chars[i]= (char) (aChar +32);
            }
        }
        return new String(chars);
    }
}
