import java.util.Arrays;

public class FindDistanceValuesBetweenTwoArrays {


        public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
            Arrays.sort(arr1);
            Arrays.sort(arr2);

            int count = 0;
            for (int c : arr1) {
                int left = 0;
                int right = arr2.length;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (arr2[mid] == c) {
                        break;
                    }
                    if (arr2[mid] > c) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }

                }
                if (arr2.length > 1) {
                    int a = left;
                    int b = left + 1;

                    if (left >= arr2.length-1) {
                        a = left - 2;
                        b = left - 1;
                    }

                    if (Math.abs(arr2[a] - c) <= d || Math.abs(arr2[b] - c) <= d) {
                        count++;
                    }
                } else {
                    if (left == arr2.length) {
                        left=left-1;
                    }
                    if (Math.abs(arr2[left] - c) <= d) {
                        count++;
                    }
                }
            }
            return arr1.length - count;
        }

    public static void main(String[] args) {
        FindDistanceValuesBetweenTwoArrays soln= new FindDistanceValuesBetweenTwoArrays();
        System.out.println(soln.findTheDistanceValue(new int[]{2,6},new int[]{-10,9,2,-1},2));
    }


}
