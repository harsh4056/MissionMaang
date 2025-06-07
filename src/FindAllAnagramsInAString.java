import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {


    public List<Integer> findAnagrams(String s, String p) {


        List<Integer> result= new ArrayList<>();
        char[]sArr= s.toCharArray();
        char[]pArr=p.toCharArray();
        int[]maps= new int[26];
        int n=sArr.length;
        int k =pArr.length;

        if (n < k) return result;
        for (int i = 0; i < k; i++) {
            maps[pArr[i]-'a']++;
            maps[sArr[i]-'a']--;
        }
        int diffCount = 0;
        for (int f : maps) {
            if (f > 0) {
                diffCount++;
            }
        }
        if(diffCount==0)
            result.add(0);

        for (int i = k; i <n ; i++) {
            if(++maps[sArr[i-k]-'a']==1) diffCount++;
            if(--maps[sArr[i]-'a']==0) diffCount--;
            if(diffCount==0)
                result.add(i-k+1);
        }
        return result;


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
