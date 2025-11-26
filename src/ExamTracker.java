import java.util.*;


public class ExamTracker {
    TreeMap<Integer,Long> map;
    public ExamTracker() {
        map= new TreeMap<>();
    }

    public void record(int time, int score) {
        if(map.isEmpty()){
            map.put(time, (long) score);
            return;
        }
        long store=map.lowerEntry(time).getValue();
        map.put(time, store+score);

    }

    public long totalScore(int startTime, int endTime) {
        Map.Entry<Integer, Long> et= map.floorEntry(endTime);
        Map.Entry<Integer, Long> st= map.lowerEntry(startTime);
        if(et==st) return 0L;

        long ett=et==null?0:et.getValue();
        long stt=st==null?0:st.getValue();
        return ett-stt;
    }

    public static void main(String[] args) {

        ExamTracker examTracker = new ExamTracker();

        examTracker.record(1, 98);
        System.out.println(examTracker.totalScore(1, 1));   // Expected: 98

        examTracker.record(5, 99);
        System.out.println(examTracker.totalScore(1, 3));   // Expected: 98
        System.out.println(examTracker.totalScore(1, 5));   // Expected: 197
        System.out.println(examTracker.totalScore(3, 4));   // Expected: 0
        System.out.println(examTracker.totalScore(2, 5));   // Expected: 99
    }

}
