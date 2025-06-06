import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

public class OpenTheLock {

    public int openLock(String[] deadends, String target) {
        boolean[] visitedAndDeadends = new boolean[10000];
        for (String dead : deadends) {
            visitedAndDeadends[Integer.parseInt(dead)] = true;
        }

        if (visitedAndDeadends[0]) return -1;

        Queue<Pair> bfsQueue = new ArrayDeque<>();
        bfsQueue.offer(new Pair(0, 0));
        visitedAndDeadends[0] = true;

        int targetInt = Integer.parseInt(target);

        while (!bfsQueue.isEmpty()) {
            Pair current = bfsQueue.poll();

            if (current.code == targetInt) return current.moves;

            for (int i = 0; i < 4; i++) {
                int pow10 = (int) Math.pow(10, i);
                int digit = (current.code / pow10) % 10;

                // rotate +1
                int up = (digit + 1) % 10;
                int nextUp = current.code + (up - digit) * pow10;
                if (!visitedAndDeadends[nextUp]) {
                    bfsQueue.offer(new Pair(nextUp, current.moves + 1));
                    visitedAndDeadends[nextUp] = true;
                }

                // rotate -1
                int down = (digit + 9) % 10;
                int nextDown = current.code + (down - digit) * pow10;
                if (!visitedAndDeadends[nextDown]) {
                    bfsQueue.offer(new Pair(nextDown, current.moves + 1));
                    visitedAndDeadends[nextDown] = true;
                }
            }
        }
        return -1;
    }

    static class Pair {
        int code;
        int moves;

        public Pair(int code, int moves) {
            this.code = code;
            this.moves = moves;
        }
    }

    public static void main(String[] args) {
        OpenTheLock lockSolver = new OpenTheLock();

        // Test Case 1: Simple target reachable
        String[] deadends1 = {"0201","0101","0102","1212","2002"};
        String target1 = "0202";
        System.out.println("Test Case 1 Output: " + lockSolver.openLock(deadends1, target1));

        // Test Case 2: Target is initial state
        String[] deadends2 = {"8888"};
        String target2 = "0000";
        System.out.println("Test Case 2 Output: " + lockSolver.openLock(deadends2, target2));

        // Test Case 3: No possible way
        String[] deadends3 = {"0000"};
        String target3 = "8888";
        System.out.println("Test Case 3 Output: " + lockSolver.openLock(deadends3, target3));


        // Test Case 4: Surrounded deadends
        String[] deadends4 = {"8887","8889","8878","8898","8788","8988","7888","9888"};
        String target4 = "8888";
        System.out.println("Test Case 4 Output: " + lockSolver.openLock(deadends4, target4));


        // Test Case 4: Surrounded deadends
        String[] deadends5 = {"8888"};
        String target5 = "0009";
        System.out.println("Test Case 4 Output: " + lockSolver.openLock(deadends5, target5));
    }
}
