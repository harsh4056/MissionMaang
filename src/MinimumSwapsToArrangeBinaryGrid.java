import java.util.*;

public class MinimumSwapsToArrangeBinaryGrid {

    public int minSwaps(int[][] grid) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int[] row : grid) {
            int count=0;
            for(int i= row.length-1;i>=0;i--){
                if(row[i]==0){
                    count++;
                }
                else{
                    break;
                }
            }
            if(!set.contains(count)) {
                set.add(count);
                list.add(count);
            }
            else{
                return -1;
            }
        }
        int ans= Math.toIntExact(minAdjacentSwapsToDescending(list));
        return ans;
    }

    public static long minAdjacentSwapsToDescending(List<Integer> input) {

        int n = input.size();
        int[] arr = new int[n];

        // Convert List -> array
        for (int i = 0; i < n; i++) {
            arr[i] = input.get(i);
        }

        int[] temp = new int[n];
        return mergeSort(arr, temp, 0, n - 1);
    }

    private static long mergeSort(int[] arr, int[] temp, int left, int right) {
        long count = 0;

        if (left < right) {
            int mid = left + (right - left) / 2;

            count += mergeSort(arr, temp, left, mid);
            count += mergeSort(arr, temp, mid + 1, right);
            count += merge(arr, temp, left, mid, right);
        }

        return count;
    }

    private static long merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        long swaps = 0;

        while (i <= mid && j <= right) {

            // For DESCENDING target
            if (arr[i] >= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                swaps += (mid - i + 1);
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid)
            temp[k++] = arr[i++];

        while (j <= right)
            temp[k++] = arr[j++];

        for (int x = left; x <= right; x++)
            arr[x] = temp[x];

        return swaps;
    }

    public static void main(String[] args) {
            MinimumSwapsToArrangeBinaryGrid soln= new MinimumSwapsToArrangeBinaryGrid();
            int [][]grid1= new int[][]{{0,0,1},{1,1,0},{1,0,0}};
            //[[0,0,1],[1,1,0],[1,0,0]]
        System.out.println(soln.minSwaps(grid1));
    }
}
