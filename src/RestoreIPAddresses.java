import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RestoreIPAddresses {

        public List<String> restoreIpAddresses(String s) {
            List<String> ip = new ArrayList<>();
            findAddresses(new StringBuilder(), s.toCharArray(), 0, 0, ip);
            return ip;
        }

        public void findAddresses(StringBuilder builder, char[] s, int index, int segments, List<String> ipAddresses) {
            if (segments == 4 && index == s.length) {
                ipAddresses.add(builder.toString());
                return;
            }

            if (segments == 4 || index == s.length) return;

            for (int len = 1; len <= 3 && index + len <= s.length; len++) {
                String part = String.valueOf(s, index, len);

                if (part.length() > 1 && part.charAt(0) == '0') return;
                if (Integer.parseInt(part) > 255) return;

                int beforeAppend = builder.length();
                if (segments > 0) builder.append('.');
                builder.append(part);

                findAddresses(builder, s, index + len, segments + 1, ipAddresses);

                builder.setLength(beforeAppend); // backtrack
            }
        }



    public static void main(String[] args) {
        RestoreIPAddresses solution = new RestoreIPAddresses();

        System.out.println(solution.restoreIpAddresses("25525511135"));
        // Expected: [255.255.11.135, 255.255.111.35]

        System.out.println(solution.restoreIpAddresses("0000"));
        // Expected: [0.0.0.0]

        System.out.println(solution.restoreIpAddresses("101023"));
        // Expected: [1.0.10.23, 1.0.102.3, 10.1.0.23, 10.10.2.3, 101.0.2.3]
    }

}
