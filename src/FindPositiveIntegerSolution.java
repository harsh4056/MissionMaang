import java.util.*;

public class FindPositiveIntegerSolution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i <= z; i++) {

            int l = 1;
            int r = z;
            while (l < r) {
                int mid = l + (r - l) / 2;

                if (customfunction.f(i, mid)>= z) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }

            if (customfunction.f(i, l) == z) {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(l);
                list.add(temp);

            }
        }
        return list;

    }

    static class CustomFunction {
        int f(int x,int y){
            return x*y;
        }
    }

    public static void main(String[] args) {
        FindPositiveIntegerSolution soln= new FindPositiveIntegerSolution();
        System.out.println(soln.findSolution(new CustomFunction(),5));
    }

}


