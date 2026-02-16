import java.util.*;

public class TurnOnLightBulbs {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        HashSet<Integer> set= new HashSet<>();
        for(int bulb:bulbs){
            if(set.contains(bulb)){
                set.remove(bulb);
            }
            else{
                set.add(bulb);
            }
        }
        return set.stream().toList();
    }
}
