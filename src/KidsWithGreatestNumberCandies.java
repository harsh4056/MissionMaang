import java.util.ArrayList;
import java.util.List;

public class KidsWithGreatestNumberCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max=Integer.MIN_VALUE;
        for (int candy : candies) {
            max=Math.max(max,candy);
        }
        int n=candies.length;
        List<Boolean> answer= new ArrayList<>();
        for (int candy : candies) {
            answer.add(candy + extraCandies >= max);

        }
        return answer;
    }
}
