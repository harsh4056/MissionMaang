public class CountTheNumberOfPowerfulIntegers {

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        char[]rs= String.valueOf(finish).toCharArray();
        char[]ls= String.valueOf(start).toCharArray();
        char[]cs= s.toCharArray();
        long right= solve(0,true,false,limit,rs,cs);
        long left=0;
        left= solve(0,true,false,limit,ls,cs);



        return right-left;
    }

    public long solve(int i,boolean tight,boolean started,int stop,char[]cn,char[]cs){


        if(i==cn.length){
            return 1;
        }
        int limit=tight?cn[i]-'0':9;
        long count=0;
        for (int d = 0; d <=limit; d++) {
            boolean newTight = tight && (d == cn[i] - '0');
            int diff = cn.length - cs.length;
            int matchIndex = i + diff;
                if(d<=stop) {
                    if (!started && d == 0) {
                        if (i >= diff) {
                            if ((cs[i - diff] - '0') == d) {

                                count += solve(i + 1, newTight, false, stop, cn, cs);
                            }
                        } else {
                            count += solve(i + 1, newTight, false, stop, cn, cs);
                        }
                    } else {
                        if (i >= diff) {
                            if ((cs[i - diff] - '0') == d) {
                                count += solve(i + 1, newTight, true, stop, cn, cs);

                            }
                        } else {
                            count += solve(i + 1, newTight, true, stop, cn, cs);
                        }
                    }
                }



            }


        return count;
    }

    public static void main(String[] args) {
        CountTheNumberOfPowerfulIntegers soln= new CountTheNumberOfPowerfulIntegers();
        System.out.println(soln.numberOfPowerfulInt(1,11,5,"10"));
        System.out.println(soln.numberOfPowerfulInt(1,6000,4,"124"));
        System.out.println(soln.numberOfPowerfulInt(15,215,6,"10"));
        System.out.println(soln.numberOfPowerfulInt(1000,2000,4,"3000"));
    }
}
