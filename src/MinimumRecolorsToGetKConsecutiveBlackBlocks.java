public class MinimumRecolorsToGetKConsecutiveBlackBlocks {

    public int minimumRecolors(String blocks, int k) {
        int n=blocks.length();
        char[]arr=blocks.toCharArray();
        int start=0;
        int min=Integer.MAX_VALUE;
        int painted=0;
        int count=0;
        for(int end=0;end<n;end++){
            if(arr[end]=='W'){
                painted++;
            }

            count++;
            while(start<=end &&count>=k){
                min=Math.min(min,painted);
                if(arr[start]=='W'){
                    painted--;
                }
                start++;
                count--;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        MinimumRecolorsToGetKConsecutiveBlackBlocks solution = new MinimumRecolorsToGetKConsecutiveBlackBlocks();

        // Test case 1
        int result1 = solution.minimumRecolors("WBBWWBBWBW", 7);
        System.out.println(result1); // Expected output: 3

        // Test case 2
        int result2 = solution.minimumRecolors("WBWBBBW", 2);
        System.out.println(result2); // Expected output: 0

        // Test case 3
        int result3 = solution.minimumRecolors("WWBWWBWW", 3);
        System.out.println(result3); // Expected output: 2
    }


}
