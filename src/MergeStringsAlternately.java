public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {

        StringBuilder answer= new StringBuilder();
        int i=0;
        int j=0;
        while (i<word1.length() ||j<word2.length()){
            if(i<word1.length()){
                answer.append(word1.charAt(i++));
            }
            if(j<word2.length()){
                answer.append(word2.charAt(j++));
            }
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        MergeStringsAlternately solution = new MergeStringsAlternately();

        String result1 = solution.mergeAlternately("abc", "pqr");
        System.out.println(result1); // Expected: "apbqcr"

        String result2 = solution.mergeAlternately("ab", "pqrs");
        System.out.println(result2); // Expected: "apbqrs"

        String result3 = solution.mergeAlternately("abcd", "pq");
        System.out.println(result3); // Expected: "apbqcd"
    }

}
