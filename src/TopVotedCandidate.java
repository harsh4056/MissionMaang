import java.util.TreeMap;

class TopVotedCandidate {


    int[]winnerAtT;
    int[]times;
    public TopVotedCandidate(int[] persons, int[] times) {
        this.times=times;
        int[] candidates= new int[persons.length];
        int max=0;
        winnerAtT= new int[persons.length];
        winnerAtT[0]=persons[0];
        candidates[persons[0]]++;
        for (int i = 1; i < persons.length; i++) {
            int person = persons[i];
            candidates[person]++;
            max=Math.max(candidates[person],max);
            if(candidates[person]==max){
                winnerAtT[i]=person;
            }
            else{
                winnerAtT[i]=winnerAtT[i-1];
            }
        }




    }

    public int q(int t) {
        int l = 0, r = times.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (times[mid] <= t) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        int idx = r; // r is last position where times[i] ≤ t

        if (idx < 0) return -1;  // no time ≤ t
        return winnerAtT[idx];
    }


    public static void main(String[] args) {
        TopVotedCandidate soln= new TopVotedCandidate(new int[]{0, 1, 1, 0, 0, 1, 0},new int[]{0, 5, 10, 15, 20, 25, 30});
        System.out.println(soln.q(3));
        System.out.println(soln.q(12));
        System.out.println(soln.q(25));
        System.out.println(soln.q(15));

    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */