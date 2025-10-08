import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SwimInRisingWater {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> minHeap= new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        int n=grid.length;
        boolean[][]visited= new boolean[n][n];
        minHeap.offer(new int[]{0,0,grid[0][0]});
        int max=0;
        while(!minHeap.isEmpty()){

            int[]curr=minHeap.poll();
            visited[curr[0]][curr[1]]=true;
            max=Math.max(curr[2],max);
            if(curr[0]==n-1 && curr[1]==n-1) break;


            if(curr[0]+1<n && !visited[curr[0]+1][curr[1]]){
                minHeap.offer(new int[]{curr[0]+1,curr[1],grid[curr[0]+1][curr[1]]});
            }
            if(curr[1]+1<n && !visited[curr[0]][curr[1]+1]){
                minHeap.offer(new int[]{curr[0],curr[1]+1,grid[curr[0]][curr[1]+1]});
            }
            if(curr[0]-1>=0 && !visited[curr[0]-1][curr[1]]){
                minHeap.offer(new int[]{curr[0]-1,curr[1],grid[curr[0]-1][curr[1]]});
            }
            if(curr[1]-1>=0 && !visited[curr[0]][curr[1]-1]){
                minHeap.offer(new int[]{curr[0],curr[1]-1,grid[curr[0]][curr[1]-1]});
            }
        }
        return  max;
    }

    // -------------------------------------------------------------------------
    // PSVM with Test Cases and Expected Answers
    // -------------------------------------------------------------------------

    /**
     * Public static void main method for testing the swimInWater solution.
     */
    public static void main(String[] args) {
        SwimInRisingWater soln = new SwimInRisingWater();

        System.out.println("--- LeetCode 778: Swim in Rising Water Test Cases ---");
        System.out.println();


       /* int[][] grid1 = {{0, 1}, {2, 3}};
        int expected1 = 3;
        runTest(soln, "Test Case 1 (Simple 2x2)", grid1, expected1);

        int[][] grid2 = {
                {0, 1, 2, 3, 4},
                {24, 23, 22, 21, 5},
                {12, 13, 14, 15, 16},
                {11, 17, 18, 19, 20},
                {10, 9, 8, 7, 6}
        };
        int expected2 = 16;
        runTest(soln, "Test Case 2 (Standard 5x5)", grid2, expected2);*/

        // Test Case 3: Grid forcing an early high elevation passage
        // Expected: 10 (Must go through '10' at grid[0][1])
        int[][] grid3 = {
                {1, 10, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        int expected3 = 10;
        runTest(soln, "Test Case 3 (Forced High Elevation)", grid3, expected3);

        // Test Case 4: Grid where path requires circling back
        // Expected: 4 (The path must include the cell with elevation 4)
        int[][] grid4 = {
                {0, 3, 4},
                {1, 2, 5},
                {6, 7, 8}
        };
        int expected4 = 4;
        runTest(soln, "Test Case 4 (Zig-Zag Path)", grid4, expected4);

        // Test Case 5: 1x1 grid (Edge Case)
        // Expected: 5
        int[][] grid5 = {{5}};
        int expected5 = 5;
        runTest(soln, "Test Case 5 (Edge Case: 1x1)", grid5, expected5);

        // Test Case 6: 3x3 grid with high 'walls'
        // Expected: 10 (Path time is determined by 10 at (1,1) if it's the bottleneck)
        int[][] grid6 = {
                {0, 8, 1},
                {9, 10, 2},
                {7, 6, 3}
        };
        int expected6 = 10;
        runTest(soln, "Test Case 6 (High Walls)", grid6, expected6);
    }

    /**
     * Helper method to run a single test case and print results.
     * Note: This method is required by the psvm above.
     */
    private static void runTest(SwimInRisingWater soln, String name, int[][] grid, int expected) {
        int result = soln.swimInWater(grid);
        System.out.println(name + ":");
        // Print the grid for small cases, or a summary for large cases
        if (grid.length <= 3) {
            System.out.println("Input Grid: " + Arrays.deepToString(grid));
        } else {
            System.out.printf("Input Grid: %d x %d (e.g., %d at [0,0])\n",
                    grid.length, grid.length, grid[0][0]);
        }
        System.out.println("Expected Answer: " + expected);
        System.out.println("Actual Answer:   " + result);
        System.out.println("Result: " + (result == expected ? "✅ PASSED" : "❌ FAILED"));
        System.out.println("----------------------------------------");
    }
}
