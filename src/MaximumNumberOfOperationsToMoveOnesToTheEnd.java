public class MaximumNumberOfOperationsToMoveOnesToTheEnd {
    public int maxOperations(String s) {
        char[] cs=s.toCharArray();
        int n=cs.length;
        int ops=0;
        int ones=0;
        boolean zeroFound=false;
        int i=0;
        while(i<n){
            int one=0;
            if(cs[i]=='1'){
                while(i<n && cs[i]=='1' ){
                    one++;
                    i++;
                }

            }
            if(i<n && cs[i]=='0'){
                ones+=one;
                while(i<n && cs[i]=='0') {
                    zeroFound=true;
                    i++;
                }
                if(zeroFound) {
                    ops += ones;
                    zeroFound=false;
                }
            }

        }

        return ops;
    }

    public static void main(String[] args) {
        MaximumNumberOfOperationsToMoveOnesToTheEnd soln= new MaximumNumberOfOperationsToMoveOnesToTheEnd();
        System.out.println(soln.maxOperations("00111"));
        System.out.println(soln.maxOperations("1001101"));
        System.out.println(soln.maxOperations("10101"));
        System.out.println(soln.maxOperations("11011011"));
    }
}
