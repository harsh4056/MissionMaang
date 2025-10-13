import java.util.*;

public class MaximumTotalDamageWithSpellCasting {

    public long maximumTotalDamage(int[] power) {
        Arrays.sort(power);
        int n = power.length;
        long[][] dp = new long[n][2];
        HashMap<Integer,Integer> map= new HashMap<>();
        List<Integer> list= new ArrayList<>();
        for(int num:power) {
            if(!map.containsKey(num)) list.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Collections.sort(list);
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        return getMax(list, 0, 0,map, dp);

    }
    public long getMax(List<Integer> nums, int index, int prevTaken, HashMap<Integer,Integer> map, long[][] dp) {
        if (index >= nums.size()) return 0;
        if (dp[index][prevTaken] != -1) return dp[index][prevTaken];

        // Check if current is adjacent to previous index
        boolean adjacentToPrev = index > 0 && ((nums.get(index) ==  (nums.get(index - 1) + 1))||(nums.get(index) ==  (nums.get(index - 1) + 2)));
        boolean adjacentToPrevPrev = index > 1 && ((nums.get(index) ==  nums.get(index - 2) + 1)||(nums.get(index) ==  (nums.get(index - 2) + 2)));

        long take = 0;
        // We can take current only if previous index wasn't taken OR they aren't adjacent
        if (!(prevTaken == 1 && (adjacentToPrev)||adjacentToPrevPrev)) {
            take = nums.get(index)*(long)map.get(nums.get(index)) + getMax(nums, index + 1, 1,map, dp);
        }

        long dontTake = getMax(nums, index + 1, 0,map, dp);

        dp[index][prevTaken] = Math.max(take, dontTake);
        return dp[index][prevTaken];
    }

    public static void main(String[] args) {
        MaximumTotalDamageWithSpellCasting soln= new MaximumTotalDamageWithSpellCasting();
        /*System.out.println(soln.maximumTotalDamage(new int[]{1,1,1,1,1,1,4,3,6}));//12
        System.out.println(soln.maximumTotalDamage(new int[]{7,1,6,6}));//13*/
        System.out.println(soln.maximumTotalDamage(new int[]{5,9,2,10,2,7,10,9,3,8}));//31
    }
}
