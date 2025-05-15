import java.util.HashMap;
import java.util.HashSet;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {


        HashMap<Character,Integer> tMap= new HashMap<>();
        for(char c:t.toCharArray()){
            tMap.put(c,tMap.getOrDefault(c,0)+1);
        }
        int required = tMap.keySet().size();
        int formed=0;
        char[]arr= s.toCharArray();
        int left=0;


        int minLength = Integer.MAX_VALUE;
        int minLeft = 0;
        int minRight = 0;

        HashMap<Character,Integer> windowMap= new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            windowMap.put(c,windowMap.getOrDefault(c,0)+1);
            if (tMap.containsKey(c) && windowMap.get(c).intValue() == tMap.get(c).intValue()) {
                formed++;
            }
            while(formed==required){
                if(minLength>(i-left+1)){
                    minLength=Math.min(minLength,(i-left+1));
                    minLeft=left;
                    minRight=i;
                }
                char fall=arr[left];
                windowMap.put(fall,windowMap.getOrDefault(fall,0)-1);
                if (tMap.containsKey(fall) && windowMap.get(fall) < tMap.get(fall)) {
                    formed--;
                }
                left++;

            }
        }
        if (minLength == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(minLeft, minRight + 1);

    }

}
