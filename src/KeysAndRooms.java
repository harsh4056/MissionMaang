import java.util.List;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            boolean []visited= new boolean[rooms.size()];
         final int[] data= new int[rooms.size()];
         int front = 0, rear = 0, size = 0;

         for(Integer i:rooms.getFirst()){
             data[rear] = i;
             rear = (rear + 1) % data.length;
             size++;
         }
         visited[0]=true;
         while (size!=0){


             int room = data[front];
             front = (front + 1) % data.length;
             size--;
             if(!visited[room]) {
                 visited[room]=true;
                 for (Integer i : rooms.get(room)) {
                     if(!visited[i]) {
                         data[rear] = i;
                         rear = (rear + 1) % data.length;
                         size++;
                     }
                 }
             }
         }
        for (boolean b : visited) {
            if(!b)
                return false;
        }
        return true;

    }

    public static void main(String[] args) {
        KeysAndRooms solution = new KeysAndRooms();

        List<List<Integer>> test1 = List.of(
                List.of(1),
                List.of(2),
                List.of(3),
                List.of()
        );
        System.out.println(solution.canVisitAllRooms(test1)); // true

        List<List<Integer>> test2 = List.of(
                List.of(1, 3),
                List.of(3, 0, 1),
                List.of(2),
                List.of(0)
        );
        System.out.println(solution.canVisitAllRooms(test2)); // false

        List<List<Integer>> test3 = List.of(
                List.of(1, 2, 3),
                List.of(),
                List.of(0),
                List.of()
        );
        System.out.println(solution.canVisitAllRooms(test3)); // true
    }

}
