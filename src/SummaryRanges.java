import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SummaryRanges {



    public List<String> summaryRanges(int[] nums) {

        List<String> answer = new ArrayList<>();
        int n = nums.length;
        if(n==0) return answer;
        StringBuilder sb= new StringBuilder();

        answer.add("" + nums[0]);
        for (int i = 1; i < n; i++) {

            if (nums[i - 1] + 1 != nums[i]) {
                String temp = answer.getLast();
                int value = Integer.parseInt(temp);
                if (nums[i - 1] != value) {
                    temp = temp + "->" + nums[i - 1];
                    answer.set(answer.size() - 1, temp);
                }
                answer.add("" + nums[i]);
            }

        }

        String temp = answer.getLast();
        int value = Integer.parseInt(temp);
        if (nums[n - 1] != value) {
            temp = temp + "->" + nums[n - 1];
            answer.set(answer.size() - 1, temp);
        }

        return answer;

    }

    public static void main(String[] args) {
        SummaryRanges ranges= new SummaryRanges();
        ranges.summaryRanges(new int[]{0});
    }
}
