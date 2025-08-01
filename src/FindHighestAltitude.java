public class FindHighestAltitude {

    public int largestAltitude(int[] gain) {
        int highest=0;
        int currentPos=0;
        for (int i : gain) {
            currentPos=currentPos+i;
            highest=Math.max(highest,currentPos);
        }
        return highest;
    }
}
