import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {


    public List<Integer> findAnagrams(String s, String p) {
        int []pHold= new int[26];
        List<Integer> anagramPosition= new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            pHold[p.charAt(i)-'a']++;
        }

        for (int i = 0; i <= s.length() - p.length(); i++) {
            int []sHold= new int[26];
            for (int j = i; j < i+p.length(); j++) {
                sHold[s.charAt(j)-'a']++;
            }
            boolean valid=true;
            for (int j = 0; j <26 ; j++) {
                if (pHold[j] != sHold[j]) {
                    valid = false;
                    break;
                }
            }
            if(valid){
                anagramPosition.add(i);
            }
        }
        return anagramPosition;


    }

    public static void main(String[] args) {
        FindAllAnagramsInAString finder = new FindAllAnagramsInAString();



        String s2 = "abab";
        String p2 = "ab";
        printList(finder.findAnagrams(s2, p2));

        String s3 = "afdgzyxksldfm";
        String p3 = "dfg";
        printList(finder.findAnagrams(s3, p3));
    }

    public static void printList(List<Integer> list) {
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
