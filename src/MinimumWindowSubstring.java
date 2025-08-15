import java.util.*;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Set<Character> need = new HashSet<>();
        for (char c : t.toCharArray()) need.add(c);

        int left = 0, minLen = Integer.MAX_VALUE, start = 0;
        Set<Character> window = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            char rc = s.charAt(right);
            if (!need.contains(rc)) continue; // skip non-t chars

            window.add(rc);

            if (window.size() == need.size()) {
                // shrink while left char not same as right char and both are in t
                while (left < right) {
                    char lc = s.charAt(left);
                    if (!need.contains(lc)) {
                        left++;
                        continue;
                    }
                    if (lc != rc) {
                        window.remove(lc);
                        left++;
                    } else break;
                }
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        System.out.println(obj.minWindow("SDANBDCFF", "ABC"));       // ANBDC
        System.out.println(obj.minWindow("ADOBECODEBANC", "ABC"));  // BANC
    }
}
