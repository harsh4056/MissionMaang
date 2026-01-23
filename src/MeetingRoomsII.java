import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MeetingRoomsII {

    public int minMeetingRooms(List<MeetingRooms.Interval> intervals) {
        TreeMap<Integer,Integer> treemap= new TreeMap<>();
        for(MeetingRooms.Interval interval:intervals){
            treemap.put(interval.start,treemap.getOrDefault(interval.start,0)+1);
            treemap.put(interval.end,treemap.getOrDefault(interval.end,0)-1);
        }
        int count=0;
        int ans=0;
        for(int val:treemap.values()){
            count+=val;
            ans=Math.max(ans,count);
        }
        return ans;
    }
    public static void main(String[] args) {
        MeetingRoomsII mr2 = new MeetingRoomsII();
        MeetingRooms mr = new MeetingRooms();

        // Test case: intervals = [(0,40),(5,10),(15,20)] → expected: 2
        List<MeetingRooms.Interval> t1 = new ArrayList<>();
        t1.add(mr.new Interval(0, 40));
        t1.add(mr.new Interval(5, 10));
        t1.add(mr.new Interval(15, 20));

        System.out.println(mr2.minMeetingRooms(t1)); // 2

        // Test case 2: All meetings overlap → expected: 3
        List<MeetingRooms.Interval> t2 = new ArrayList<>();
        t2.add(mr.new Interval(1, 5));
        t2.add(mr.new Interval(2, 6));
        t2.add(mr.new Interval(3, 7));
        System.out.println(mr2.minMeetingRooms(t2)); // 3

        // Test case 3: No overlapping meetings → expected: 1
        List<MeetingRooms.Interval> t3 = new ArrayList<>();
        t3.add(mr.new Interval(0, 4));
        t3.add(mr.new Interval(5, 9));
        t3.add(mr.new Interval(10, 14));
        System.out.println(mr2.minMeetingRooms(t3)); // 1
    }


    public class Interval {
        public int start, end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
