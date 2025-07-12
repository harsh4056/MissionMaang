public class NinjasTraining {

    public static int ninjaTraining(int n, int points[][]) {

        for (int i = 1; i < points.length; i++) {
            for (int j = 0; j < 3; j++) {
                int firstJ=0;
                int secondJ=0;
                if(j==0){
                    firstJ=1;
                    secondJ=2;
                }

                else if(j==1){
                    secondJ=2;
                }
                else{
                    secondJ=1;
                }

                points[i][j]=points[i][j]+Math.max(points[i-1][firstJ],points[i-1][secondJ]);
            }
        }
        int max=Integer.MIN_VALUE;

        for (int val: points[points.length-1]) {
            max=Math.max(max,val);
        }
        return max;
    }
    public static void main(String[] args) {
        // Test case 1
        int[][] points1 = {
                {1, 2, 5},
                {3, 1, 1},
                {3, 3, 3}
        };
        // Expected result: 11 (Day 0: Task 2 -> Day 1: Task 0 -> Day 2: Task 1 or 2)
        System.out.println(NinjasTraining.ninjaTraining(3, points1));

        // Test case 2
        int[][] points2 = {
                {10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}
        };
        // Expected result: 210 (70 + 50 + 90)
        System.out.println(NinjasTraining.ninjaTraining(3, points2));

        // Test case 3
        int[][] points3 = {
                {18, 11, 19},
                {4, 13, 7},
                {1, 8, 13},
                {6, 15, 5}
        };
        // Expected result: 60 (19 + 13 + 13 + 15)
        System.out.println(NinjasTraining.ninjaTraining(4, points3));
    }

}
