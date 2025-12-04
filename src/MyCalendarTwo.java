import java.util.TreeMap;

class MyCalendarTwo {
    TreeMap<Integer,Integer> map;
    public MyCalendarTwo() {
        map= new TreeMap<>();
    }

    public boolean book(int startTime, int endTime) {
        map.put(startTime,map.getOrDefault(startTime,0)+1);
        map.put(endTime,map.getOrDefault(endTime,0)-1);
        int count=0;
        for (Integer value : map.values()) {
            count+=value;
            if(count>2){
                map.put(startTime,map.getOrDefault(startTime,0)-1);
                map.put(endTime,map.getOrDefault(endTime,0)+1);

                return false;
            }
        }
        return true;
    }
}