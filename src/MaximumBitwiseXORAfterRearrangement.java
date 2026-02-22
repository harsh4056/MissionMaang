public class MaximumBitwiseXORAfterRearrangement {
    public String maximumXor(String s, String t) {
        char[]ct= t.toCharArray();
        char[]cs=s.toCharArray();
        int z=0,one=0;
        for (char c:ct){
            if(c=='0') z++;
            else one++;
        }

        for (int i = 0; i < cs.length; i++) {
           if((cs[i]=='1' && z>0) ){
               z--;
           }
           else if(cs[i]=='0' && one>0){
               one--;
               cs[i]='1';
           }
           else{
               cs[i]='0';
           }

        }
        return new String(cs);
    }

    public static void main(String[] args) {
        MaximumBitwiseXORAfterRearrangement soln= new MaximumBitwiseXORAfterRearrangement();
        System.out.println(soln.maximumXor("101","011"));
        System.out.println(soln.maximumXor("0110","1110"));
        System.out.println(soln.maximumXor("0101","1001"));
    }
}
