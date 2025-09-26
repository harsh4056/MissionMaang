public class MinimumNumberOfOperationsConvertTime {
    public int convertTime(String current, String correct) {
        int wh = Integer.parseInt(current.substring(0, 2));
        int wm = Integer.parseInt(current.substring(3, 5));
        int rh = Integer.parseInt(correct.substring(0, 2));
        int rm = Integer.parseInt(correct.substring(3, 5));
        int ops=0;
        int wmin=wh*60+wm;
        int rmin=rh*60+rm;
        int diffMins=rmin-wmin;
        ops+=diffMins/60;
        diffMins=diffMins%60;
        ops+=diffMins/15;
        diffMins=diffMins%15;
        ops+=diffMins/5;
        diffMins=diffMins%5;
        ops+=diffMins;
        return ops;
    }

    public static void main(String[] args) {
        MinimumNumberOfOperationsConvertTime sol = new MinimumNumberOfOperationsConvertTime();

        String current1 = "02:30", correct1 = "04:35";
        System.out.println(sol.convertTime(current1, correct1)); // Expected: 3 (2:30 -> 3:30 -> 4:30 -> 4:35)

        String current2 = "11:00", correct2 = "11:01";
        System.out.println(sol.convertTime(current2, correct2)); // Expected: 1 (11:00 -> 11:01)

        String current3 = "09:41", correct3 = "10:34";
        System.out.println(sol.convertTime(current3, correct3)); // Expected: 7 (23:45 -> 00:00)
    }

}
