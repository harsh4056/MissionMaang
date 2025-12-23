import java.util.ArrayList;
import java.util.List;

public class NumberOfWaysToDivideLongCorridor {


    public int numberOfWays(String corridor) {
        char[]cs= corridor.toCharArray();

        int prefix=0;
        int seats=0;
        for (char c : cs) {
            if(c=='S') seats++;
        }
        if(seats%2==1) return 0;
        int suffix=0;

        int sep=0;
        List<Integer> list= new ArrayList<>();
        for (char c : cs) {
            if(c=='S') {
                prefix++;
            }
            if(prefix==2){
                sep++;
            }
            else if(prefix>2){
                prefix=1;
                list.add(sep);
                sep=0;
            }
        }
        int ans=1;
        int div= 1_000_000_007;
        for (Integer i : list) {
            ans=(ans*i)%div;
        }
        return ans;
    }

    public static void main(String[] args) {
        NumberOfWaysToDivideLongCorridor soln= new NumberOfWaysToDivideLongCorridor();
        System.out.println(soln.numberOfWays("SSPPSPS"));
        System.out.println(soln.numberOfWays("PPSPSP"));
        System.out.println(soln.numberOfWays("S"));
    }


}
