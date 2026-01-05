import java.util.*;

public class DecodeEncode {

        public String encode(List<String> strs) {
            StringBuilder sb= new StringBuilder();
            char c = (char) 256;
            for(String s:strs){

                sb.append(s);
                sb.append(c);
            }
            return sb.toString();


        }

    public List<String> decode(String str) {
        char c = (char) 256;

        List<String> ans= new ArrayList<>();

        StringBuilder sb= new StringBuilder();
        char[]cs= str.toCharArray();
        for (char c1:cs){
            if(c1==c){
                sb.append("");
                ans.add(sb.toString());
                sb=new StringBuilder();

            }
            else {
                sb.append(c1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {


        DecodeEncode decodeEncode= new DecodeEncode();
        List<String> list= new ArrayList<>() ;
        list.add("Hello");
        list.add("World");
        String a=decodeEncode.encode(list);
        list=decodeEncode.decode(a);
        System.out.println(list);
    }


}
