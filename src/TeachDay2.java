public class TeachDay2 {

    public static void main(String[] args) {
        int[]nums1= new int[]{5,7,8,9};
        int maximum=findMax(nums1);
        System.out.println("Maximum : "+maximum);
        int second=findSecondMax(nums1);
        System.out.println("Second Maximum : "+second);
        boolean duplicates= duplicates(nums1);
        System.out.println("Duplicates present: "+duplicates);
        findAllPairs(nums1);
        frequencyOfLetters("rohit");
    }
    public static int findMax(int []nums){
        int maximum=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(maximum<nums[i]){
                maximum=nums[i];
            }
            maximum=Math.max(maximum,nums[i]);
        }
        return maximum;
    }

    public static int findSecondMax(int[]nums){
        int maximum=Integer.MIN_VALUE;
        int secondMax=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(maximum<nums[i]){
                secondMax=maximum;
                maximum=nums[i];
            }

        }
        return secondMax;
    }
    public static boolean duplicates(int[]nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
    public static void findAllPairs(int[]nums){

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                System.out.println(nums[i]+" : "+nums[j]);
            }
        }

    }
    public static void frequencyOfLetters(String s){
        char[] cs=s.toCharArray();
        int[]fc= new int[26];
        for (int i = 0; i < cs.length; i++) {
            int c = cs[i]-'a';
            fc[c]++;
        }
        for (int i = 0; i < fc.length; i++) {
            System.out.println((char)(i+'a')+"->"+fc[i]);

        }
    }
}


