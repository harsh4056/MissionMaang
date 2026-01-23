import java.util.*;

public class MeetingRooms {
    public boolean canAttendMeetings(List<Interval> intervals) {
        TreeMap<Integer,Integer> treemap= new TreeMap<>();
        for(Interval interval:intervals){
            treemap.put(interval.start,treemap.getOrDefault(interval.start,0)+1);
            treemap.put(interval.end,treemap.getOrDefault(interval.end,0)-1);
        }
        int count=0;
        for(int val:treemap.values()){
            count+=val;
            if(count>1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MeetingRooms mr = new MeetingRooms();

        // Test case 1: No overlapping meetings → expected: true
        List<Interval> t1 = new ArrayList<>();
        t1.add(mr.new Interval(0, 5));
        t1.add(mr.new Interval(6, 10));
        t1.add(mr.new Interval(11, 15));
        System.out.println(mr.canAttendMeetings(t1)); // true

        // Test case 2: Overlapping meetings → expected: false
        List<Interval> t2 = new ArrayList<>();
        t2.add(mr.new Interval(0, 10));
        t2.add(mr.new Interval(5, 15));
        System.out.println(mr.canAttendMeetings(t2)); // false

        // Test case 3: Single meeting → expected: true
        List<Interval> t3 = new ArrayList<>();
        t3.add(mr.new Interval(2, 7));
        System.out.println(mr.canAttendMeetings(t3)); // true
    }

    public class Interval {
          public int start, end;
          public Interval(int start, int end) {
              this.start = start;
              this.end = end;
          }
      }
}
