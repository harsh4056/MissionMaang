import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {


    public String getPermutation(int n, int k) {
        List<Integer> numbers= new ArrayList<>();
        int fact=1;
        for (int i = 1; i <= n; i++) {
            fact*=i;
            numbers.add(i);
        }
        fact=fact/n;
        k=k-1;
        char[]permutation= new char[n];
        int i=0;
        while(true){
            int index=k/fact;
            permutation[i++]=(char)(numbers.get(index)+'0');
            k=k%fact;
            numbers.remove(index);


            if(numbers.isEmpty())
                break;
            fact=fact/numbers.size();
        }
        return String.valueOf(permutation,0,n);
    }

    public static void main(String[] args) {
        PermutationSequence permutationSequence= new PermutationSequence();
        System.out.println(
        permutationSequence.getPermutation(5,13));
    }

}
