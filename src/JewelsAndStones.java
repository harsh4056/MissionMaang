import java.util.HashSet;

public class JewelsAndStones {

    public int numJewelsInStones(String jewels, String stones) {

        HashSet<Character> set =  new HashSet<>();
        for (int i = 0; i <jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }
        int count=0;
        for (int i = 0; i <stones.length(); i++) {
            if(set.contains(stones.charAt(i))){
                count++;
            }
        }
        return count;
    }

}
