import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SubstringWithConcatenationAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list= new ArrayList<>();

        HashSet<String> mainHashSet = new HashSet<>(Arrays.asList(words));




        int count= words[0].length();

        for (int i = 0; i <= s.length()-count; i++) {
            HashSet<String> tempSet = new HashSet<>(mainHashSet);
            String temp = s.substring(i,i+count);
            int idx=i;
            if(tempSet.contains(temp)) {
                while (tempSet.contains(temp) ) {
                    tempSet.remove(temp);
                    temp=s.substring(idx,idx+count);
                    idx=idx+count;

                }
                if(tempSet.isEmpty()){
                    list.add(i);
                    i=i+count;
                }
            }


        }



        return list;
    }
}
