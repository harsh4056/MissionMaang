import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> mainMap= new HashMap<>();


        for(String s:strs ){
           char[]arr= s.toCharArray();
            Arrays.sort(arr);
            List<String> stringHashSet = mainMap.getOrDefault(Arrays.toString(arr), new ArrayList<>());
            stringHashSet.add(s);
            mainMap.put(Arrays.toString(arr),
                    stringHashSet);
        }

        List<List<String>> lists = new ArrayList<>(mainMap.values());


        return lists;

    }

    public static void main(String[] args) {
        GroupAnagrams anagrams= new GroupAnagrams();
        System.out.println(anagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(anagrams.groupAnagrams(new String[]{"",""}));
    }
}
