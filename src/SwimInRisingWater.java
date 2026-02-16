import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class SwimInRisingWater {
    public int swimInWater(int[][] grid) {
       PriorityQueue<int[]> minHeap= new PriorityQueue<>((a,b)->{
           return a[2]-b[2];
       });
       int n= grid.length;
       int m=grid[0].length;
       int ans=grid[0][0];
        HashSet<Integer> visited= new HashSet<>();
        minHeap.offer(new int[]{0,0,grid[0][0]});
        int[][]dirs= new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        while (!minHeap.isEmpty()){
            int[]curr= minHeap.poll();

            visited.add(curr[0]*m +curr[1]);
            ans=Math.max(ans,curr[2]);
            if(curr[0]==n-1 && curr[1]==m-1) break;
            for(int[]dir:dirs){
                int x=dir[0]+curr[0];
                int y=dir[1]+curr[1];
                if(x>=0 && x<n && y>=0 && y<m){
                    int node=(x*m)+y;
                    if(!visited.contains(node)){
                        minHeap.offer(new int[]{x,y,grid[x][y]});
                    }
                }
            }

        }

        return ans;

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


        // Test Case 4: Grid where path requires circling back
        // Expected: 4 (The path must include the cell with elevation 4)
        int[][] grid4 = {
                {0,1,2,10},
                {9,14,4,13},
                {12,3,8,15},
                {11,5,7,6}
        };

        int expected4 = 8;
        runTest(soln, "Test Case 4 (Zig-Zag Path)", grid4, expected4);

        // Test Case 3: Grid forcing an early high elevation passage
        // Expected: 10 (Must go through '10' at grid[0][1])
        int[][] grid3 = {
                {1, 10, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        int expected3 = 10;
        runTest(soln, "Test Case 3 (Forced High Elevation)", grid3, expected3);



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
