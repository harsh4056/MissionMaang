import java.util.*;

public class MyCalendar {
    TreeMap<Integer,Integer> map;
    public MyCalendar() {
        map= new TreeMap<>();
    }

    public boolean book(int startTime, int endTime) {
        map.put(startTime,map.getOrDefault(startTime,0)+1);
        map.put(endTime,map.getOrDefault(endTime,0)-1);
        int count=0;
        for (Integer value : map.values()) {
            count+=value;
            if(count>1){
                map.put(startTime,map.getOrDefault(startTime,0)-1);
                map.put(endTime,map.getOrDefault(endTime,0)+1);
                if(map.get(startTime)==0){
                    map.remove(startTime);
                }
                if(map.get(endTime)==0){
                    map.remove(endTime);
                }
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        MyCalendar soln= new MyCalendar();
        System.out.println(soln.book(10,20));
        System.out.println(soln.book(15,25));
        System.out.println(soln.book(20,30));
    }
}
