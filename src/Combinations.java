import java.util.ArrayList;
import java.util.List;

public class Combinations {
    List<List<Integer>> combine =new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        combinate(n,k,1,new ArrayList<>());
        return combine;
    }

    public void combinate(int n, int k,int start,List<Integer>integers){

        if(k== integers.size()){
            combine.add(new ArrayList<>(integers));
            return;

        }
        for (int j = start; j <=n; j++) {
           integers.add(j);
            combinate(n,k,j+1,integers);
             integers.removeLast();

        }

    }

    public static void main(String[] args) {
        Combinations combinations= new Combinations();
        System.out.println(
        combinations.combine(4,4));
    }
}
