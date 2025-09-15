import java.util.*;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int start=0;
        int n = s.length();
        char[] primary = s.toCharArray();
        int[] tFreq = new int[52];
        int[] sFreq = new int[52];
        for (char c : t.toCharArray())
        {
            if (c - 'a' < 0) {
                tFreq[c - 'A']++;
            } else {
                tFreq[c - 'a']++;
            }
        }
        int minStart = -1;
        int minEnd = -1;
        int minWindow = Integer.MAX_VALUE;
        for (int end = 0; end < n; end++) {
            char c = primary[end];
            if (c - 'a' < 0) {
                sFreq[c - 'A']++;
            } else {
                sFreq[c - 'a']++;
            }
            while (start<=end && isValidWinow(sFreq, tFreq)) {
                int current = end - start + 1;
                if (current < minWindow) {
                    minStart = start;
                    minEnd = end;
                    minWindow = current;
                }
                char cc = primary[start];
                if (cc - 'a' < 0) {
                    sFreq[cc - 'A']--;
                } else {
                    sFreq[cc - 'a']--;
                }
                start++;
            }
        }
        if(minStart==-1) return "";
        return new String(primary, minStart, minEnd - minStart + 1);
    }

    public boolean isValidWinow(int[] windowBin, int[] bin) {

        for (int i = 0; i < 52; i++) {
            if (windowBin[i] < bin[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        System.out.println(obj.minWindow("a", "b"));       // ANBDC
        System.out.println(obj.minWindow("a", "aa"));       // ANBDC
        System.out.println(obj.minWindow("SDANBDCFF", "ABC"));       // ANBDC
        System.out.println(obj.minWindow("ADOBECODEBANC", "ABC"));  // BANC
    }
}
