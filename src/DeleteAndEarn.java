import java.util.*;


public class DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] dp = new int[n][2];
        HashMap<Integer,Integer> map= new HashMap<>();
        List<Integer> list= new ArrayList<>();
        for(int num:nums) {
            if(!map.containsKey(num)) list.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Collections.sort(list);
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        return getMax(list, 0, 0,map, dp);
    }

    public int getMax(List<Integer> nums, int index, int prevTaken,HashMap<Integer,Integer> map, int[][] dp) {
        if (index >= nums.size()) return 0;
        if (dp[index][prevTaken] != -1) return dp[index][prevTaken];

        // Check if current is adjacent to previous index
        boolean adjacentToPrev = index > 0 && nums.get(index) ==  nums.get(index - 1) + 1;

        int take = 0;
        // We can take current only if previous index wasn't taken OR they aren't adjacent
        if (!(prevTaken == 1 && adjacentToPrev)) {
            take = nums.get(index)*map.get(nums.get(index)) + getMax(nums, index + 1, 1,map, dp);
        }

        int dontTake = getMax(nums, index + 1, 0,map, dp);

        dp[index][prevTaken] = Math.max(take, dontTake);
        return dp[index][prevTaken];
    }



    public static void main(String[] args) {
        DeleteAndEarn soln= new DeleteAndEarn();

        System.out.println(soln.deleteAndEarn(new int[]{2,2,3,3,4,5}));
    }
}
