import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public boolean isPalindrome(String x) {

        int left=0;
        int right=x.length()-1;
        while (left<right){
            char leftChar= x.charAt(left);
            char rightChar= x.charAt(right);
            if(leftChar!=rightChar)
                return false;
            left++;
            right--;

        }
        return true;

    }



    public List<List<String>> partition(String s) {
        List<String> holder= new ArrayList<>();
        List<List<String>> answer= new ArrayList<>();

        dfs(0,1,s,holder,answer);
        return answer;
    }

    public void dfs(int start,int end,String s,List<String> holder,List<List<String>> answer){
        if(end>s.length()){
            answer.add(new ArrayList<>(holder));
            return;
        }

            for (int i = end; i <= s.length(); i++) {

                String subString= s.substring(start,i);
                if(isPalindrome(subString)){
                    holder.add(subString);
                    dfs(start+subString.length(),i+1,s,holder,answer);
                    holder.removeLast();
                }

            }

    }

    public static void main(String[] args) {
        PalindromePartitioning solution = new PalindromePartitioning();

        System.out.println(solution.partition("aab"));
        // Expected: [["a","a","b"], ["aa","b"]]

        System.out.println(solution.partition("a"));
        // Expected: [["a"]]

        System.out.println(solution.partition("racecar"));
        // Expected: [["r","a","c","e","c","a","r"], ["r","a","cec","a","r"], ["r","aceca","r"], ["racecar"]]
    }

}
