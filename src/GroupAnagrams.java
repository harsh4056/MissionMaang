import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> mainMap= new HashMap<>();
        for (String str : strs) {
            String temp=sortString(str);
            if(!mainMap.containsKey(temp)){
               mainMap.put(temp,new ArrayList<>());
            }
            mainMap.get(temp).add(str);

        }
        List<List<String>> answer = new ArrayList<>(mainMap.values());
        return answer;
    }


    public String sortString(String s){
        int[] alphabets = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabets[s.charAt(i)-'a']++;
        }
        StringBuilder sNew= new StringBuilder();
        for (int i = 0; i < alphabets.length; i++) {
            int alphabet = alphabets[i];

            while (alphabet>0) {
                sNew.append((char) (i + 'a'));
                alphabet--;
            }

        }
        return sNew.toString();
    }

    public static void main(String[] args) {
        GroupAnagrams anagrams= new GroupAnagrams();
        System.out.println(anagrams.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
        System.out.println(anagrams.groupAnagrams(new String[]{"",""}));
    }
}
