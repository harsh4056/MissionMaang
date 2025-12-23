import java.util.TreeMap;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer,Integer> map=  new TreeMap<>((a,b)->{
            return b-a;
        });
        for (int i = 0; i < position.length; i++) {
            map.put(position[i],speed[i]);
        }
        return 0;
    }
}
