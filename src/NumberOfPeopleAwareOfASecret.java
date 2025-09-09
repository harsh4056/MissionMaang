import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfPeopleAwareOfASecret {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        Queue<int[]> queue1= new ArrayDeque<>();
        Queue<int[]> queue2= new ArrayDeque<>();
        queue1.offer(new int[]{delay,forget});
        for(int i=1;i<=n;i++){
            while(!queue1.isEmpty()){
                int[]curr=queue1.poll();
                curr[0]--;
                curr[1]--;

                if(curr[0]>=0) {
                    queue2.offer(curr);
                }
                if(curr[0]<0 &&curr[1]>0){
                    queue2.offer(curr);
                    int[] person=new int[]{delay,forget};
                    person[0]--;
                    person[1]--;
                    queue2.offer(person);
                }

            }
            Queue<int[]> temp=queue1;
            queue1=queue2;
            queue2=temp;
        }
        return queue1.size();
    }
    public static void main(String[] args) {
        NumberOfPeopleAwareOfASecret sol = new NumberOfPeopleAwareOfASecret();

        System.out.println(sol.peopleAwareOfSecret(6, 2, 4)); // Expected: 5
        System.out.println(sol.peopleAwareOfSecret(4, 1, 3)); // Expected: 6
        System.out.println(sol.peopleAwareOfSecret(10, 2, 4)); // Expected: 14
    }

}
