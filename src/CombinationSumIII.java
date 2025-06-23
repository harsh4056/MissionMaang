import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {


    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> megaList= new ArrayList<>();
        combinate(megaList,k,n,new ArrayList<>(),0);
        return megaList;

    }

    public void combinate(List<List<Integer>> megaList,int k,int n,List<Integer> list,int start){
            if(n==0 && k==0){
                megaList.add(new ArrayList<>(list));
            }
            if(n<0){
                return;
            }
        for (int i = start+1; i <=9; i++) {
            list.add(i);
            combinate(megaList,k-1,n-i,list,i);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        CombinationSumIII obj = new CombinationSumIII();

        // Test case 1
        int k1 = 3, n1 = 7;
        System.out.println(obj.combinationSum3(k1, n1)); // Expected: [[1, 2, 4]]

        // Test case 2
        int k2 = 3, n2 = 9;
        System.out.println(obj.combinationSum3(k2, n2)); // Expected: [[1, 2, 6], [1, 3, 5], [2, 3, 4]]

        // Test case 3
        int k3 = 4, n3 = 1;
        System.out.println(obj.combinationSum3(k3, n3)); // Expected: []
    }

}
