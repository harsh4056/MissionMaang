import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {



    public List<String> summaryRanges(int[] nums) {

        List<String > answer= new ArrayList<>();
        if(nums.length==0)
            return answer;
        if(nums.length==1){
            answer.add(String.valueOf(nums[0]));
            return answer;
        }
        int start=nums[0];
        int end=nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num != (end + 1)) {
                if (start != end) {
                    answer.add(start + "->" + end);
                } else {
                    answer.add(String.valueOf(start));
                }
                start = num;
            }
            end=num;
        }
        if (start != end) {
            answer.add(start + "->" + end);
        } else {
            answer.add(String.valueOf(start));
        }
        return answer;

    }

    public static void main(String[] args) {
        SummaryRanges ranges= new SummaryRanges();
        ranges.summaryRanges(new int[]{0});
    }
}
