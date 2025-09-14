import java.util.*;

public class MinimumNumberOfPeopleToTeach {

    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        HashMap<Integer,boolean[]> hashmap= new HashMap<>();
        int totalUsers=languages.length;
        for(int user=0;user<totalUsers;user++){
            int[] speaks=languages[user];
            for(int l:speaks){
                boolean[] users;
                if(hashmap.containsKey(l)){
                    users = hashmap.get(l);
                }
                else{
                    users = new boolean[totalUsers + 1];
                }
                users[user+1]=true;
                hashmap.put(l,users);

            }
        }
        HashSet<Integer> needToFix= new HashSet<>();
        for(int[]friendship:friendships){
            int f1=friendship[0];
            int f2=friendship[1];
            needToFix.add(f1);
            needToFix.add(f2);
            for (Map.Entry<Integer, boolean[]> integerEntry : hashmap.entrySet()) {
                if((integerEntry.getValue()[f1] && integerEntry.getValue()[f2])){
                    needToFix.remove(f1);
                    needToFix.remove(f2);
                    break;
                }
            }
        }
        int max=0;
        for (Map.Entry<Integer, boolean[]> integerEntry : hashmap.entrySet()) {
            int count=0;
            for (int user : needToFix) {
                if(integerEntry.getValue()[user]){
                    count++;
                }
            }
            max=Math.max(count,max);
        }

        return needToFix.size()-max;
    }
    public static void main(String[] args) {
        MinimumNumberOfPeopleToTeach sol = new MinimumNumberOfPeopleToTeach();

        int n1 = 3;
        int[][] languages1 = {{2}, {1, 3}, {1, 2}, {3}};
        int[][] friendships1 = {{1, 4}, {1, 2}, {3, 4}, {2, 3}};
        System.out.println(sol.minimumTeachings(n1, languages1, friendships1));
        // Expected: 2

        int n2 = 2;
        int[][] languages2 = {{1}, {2}, {1, 2}};
        int[][] friendships2 = {{1, 2}, {1, 3}, {2, 3}};
        System.out.println(sol.minimumTeachings(n2, languages2, friendships2));
        // Expected: 1

        int n3 = 3;
        int[][] languages3 = {{1}, {2}, {3}};
        int[][] friendships3 = {{1, 2}, {2, 3}, {1, 3}};
        System.out.println(sol.minimumTeachings(n3, languages3, friendships3));
        // Expected: 2
    }

}
