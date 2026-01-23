public class MergeTripletsToFormTarget {

    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int []answer= new int[3];

        for (int i = 0; i < triplets.length; i++) {
            int[] t = triplets[i];
            if ((target[0] == t[0] && target[0] != answer[0]) || (target[1] == t[1] && target[1] != answer[1]) || (target[2] == t[2] && target[2] != answer[2])) {
                answer[0]=Math.max(answer[0],t[0]);
                answer[1]=Math.max(answer[1],t[1]);
                answer[2]=Math.max(answer[2],t[2]);
            }
        }
        return (target[0]==answer[0] && target[1]==answer[1] && target[2]==answer[2]);
    }

    public static void main(String[] args) {
        MergeTripletsToFormTarget obj = new MergeTripletsToFormTarget();

        int[][] triplets1 = {{1,2,3},{7,1,1}};
        int[] target1 = {7,2,3};
        System.out.println(obj.mergeTriplets(triplets1, target1)); // expected: true

        int[][] triplets2 = {{2,5,6},{1,4,4},{5,7,5}};
        int[] target2 = {5,4,6};
        System.out.println(obj.mergeTriplets(triplets2, target2)); // expected: false

        int[][] triplets3 = {{2,5,3},{1,8,4},{2,7,5}};
        int[] target3 = {2,7,5};
        System.out.println(obj.mergeTriplets(triplets3, target3)); // expected: true
    }


}
