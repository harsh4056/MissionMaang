import java.util.ArrayDeque;
import java.util.Deque;

public class CountTheNumberOfSubstringsWithDominantOnes {

    public int numberOfSubstrings(String s) {
        int n = s.length();
        long ans = 0;

        for (int k = 1; k * k <= n; k++) {
            Deque<Integer> dq = new ArrayDeque<>();
            int lastZero = -1;
            int ones = 0;

            for (int r = 0; r < n; r++) {

                if (s.charAt(r) == '0') {
                    dq.addLast(r);

                    while (dq.size() > k) {
                        int removed = dq.removeFirst();
                        ones -= removed - lastZero - 1;
                        lastZero = removed;
                    }
                } else {
                    ones++;
                }

                if (dq.size() == k && ones >= k * k) {
                    int waysLeft = dq.peekFirst() - lastZero;
                    int waysRight = ones - k * k + 1;
                    ans += Math.min(waysLeft, waysRight);
                }
            }
        }

        int i = 0;
        while (i < n) {
            if (s.charAt(i) == '0') {
                i++;
                continue;
            }
            int len = 0;
            while (i < n && s.charAt(i) == '1') {
                len++;
                i++;
            }
            ans += (long) len * (len + 1) / 2;
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        CountTheNumberOfSubstringsWithDominantOnes soln= new CountTheNumberOfSubstringsWithDominantOnes();
        //System.out.println(soln.numberOfSubstrings("00011"));
        System.out.println(soln.numberOfSubstrings("101101"));
        System.out.println(soln.numberOfSubstrings("000001111"));
    }
}
