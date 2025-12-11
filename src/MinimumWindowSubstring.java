import java.util.*;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] mainFreq = new int[150];

        int[] checkFreq = new int[150];

        char[] ts = t.toCharArray();
        char[] ss = s.toCharArray();
        int k = 0;
        for (char c : ts) {
            mainFreq[c]++;
        }
        for (int i : mainFreq) {
            if (i > 0)
                k++;
        }

        int formed = 0;
        int n = ss.length;
        int l = 0;
        int min = Integer.MAX_VALUE;
        int ansL = -1;
        int ansR = -1;
        for (int r = 0; r < n; r++) {
            char currChar = ss[r];
            checkFreq[currChar]++;
            if (checkFreq[currChar] == mainFreq[currChar])
                formed++;

            while (formed == k && l <= r) {
                int diff = r - l + 1;
                if (diff < min) {
                    min = diff;
                    ansL = l;
                    ansR = r;
                }

                char currL = ss[l];
                checkFreq[currL]--;
                if (checkFreq[currL] == mainFreq[currL] - 1)
                    formed--;
                l++;
            }

        }
        if (ansL == -1)
            return "";

        return new String(ss, ansL, ansR - ansL + 1);
    }



    public static void main(String[] args) {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        System.out.println(obj.minWindow("a", "a"));       // a
        System.out.println(obj.minWindow("a", "b"));       // ""
        System.out.println(obj.minWindow("a", "aa"));       // ""
        System.out.println(obj.minWindow("SDANBDCFF", "ABC"));       // ANBDC
        System.out.println(obj.minWindow("ADOBECODEBANC", "ABC"));  // BANC
    }
}
