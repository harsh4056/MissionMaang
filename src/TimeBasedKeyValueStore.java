import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class TimeMap {
    HashMap<String,TreeMap<Integer,String>> map;
    public TimeMap() {
        map= new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key,new TreeMap<>());
        map.get(key).put(timestamp,value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer,String > treeMap= map.get(key);
        if(treeMap==null) return "";

        Map.Entry<Integer,String> entry= treeMap.floorEntry(timestamp);
        if(entry==null) return "";
        return entry.getValue();
    }

    public static void main(String[] args) {
        TimeMap obj = new TimeMap();

        obj.set("love", "high", 10);
        obj.set("love", "low", 20);

        System.out.println(obj.get("love", 5));   // Expected: ""
        System.out.println(obj.get("love", 10));  // Expected: "high"
        System.out.println(obj.get("love", 15));  // Expected: "high"
        System.out.println(obj.get("love", 20));  // Expected: "low"
        System.out.println(obj.get("love", 25));  // Expected: "low"
    }

}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */