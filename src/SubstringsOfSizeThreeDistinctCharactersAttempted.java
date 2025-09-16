public class SubstringsOfSizeThreeDistinctCharactersAttempted {

        public int countGoodSubstrings(String s) {
            if (s.length() < 3) return 0;

            int[] freq = new int[26];
            char[] arr = s.toCharArray();
            int count = 0;

            // first window
            for (int i = 0; i < 3; i++) {
                freq[arr[i] - 'a']++;
            }
            if (isGood(freq)) count++;

            // sliding window
            for (int start = 0, end = 3; end < arr.length; start++, end++) {
                freq[arr[start] - 'a']--;   // remove old
                freq[arr[end] - 'a']++;     // add new
                if (isGood(freq)) count++;
            }
            return count;
        }

        private boolean isGood(int[] freq) {
            int distinct = 0;
            for (int f : freq) {
                if (f > 0) distinct++;
            }
            return distinct == 3;
        }



    public static void main(String[] args) {
        SubstringsOfSizeThreeDistinctCharactersAttempted sol= new SubstringsOfSizeThreeDistinctCharactersAttempted();
        System.out.println(sol.countGoodSubstrings("aababcabc"));
    }
}
