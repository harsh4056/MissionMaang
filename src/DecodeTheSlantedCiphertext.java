public class DecodeTheSlantedCiphertext {


        public String decodeCiphertext(String encodedText, int rows) {
            char[]cs= encodedText.toCharArray();
            int c=cs.length/rows;
            int i=0;
            int j=0;
            StringBuilder sb= new StringBuilder();
            while(!(i==c-1 && j==c-1)){
                sb.append(cs[j]);
                j=c+j+1;
                if(j>=cs.length){
                    i++;
                    j=i;
                }
            }
            sb.append(cs[cs.length-1]);
            while(sb.charAt(sb.length()-1)==' '){
                sb.deleteCharAt(sb.length()-1);
            }
            return sb.toString();
        }

    public static void main(String[] args) {
        DecodeTheSlantedCiphertext soln= new DecodeTheSlantedCiphertext();
        System.out.println(soln.decodeCiphertext("ch   ie   pr",3));
    }
}
