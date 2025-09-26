public class MaximumDifferenceByRemappingDigits {

    public int minMaxDifference(int num) {
        String nums=num+"";
        char[]cnums= nums.toCharArray();

        int n=cnums.length;
        char[]cmin= new char[n];
        char[]cmax= new char[n];
        char selected='0';
        boolean maxFound=false;
        for(int i=0;i<n;i++){
            if(cnums[i]!='9' && !maxFound){
                maxFound=true;
                selected=cnums[i];
            }
            if(maxFound && cnums[i]==selected){

                cmax[i]='9';
            }
            else{
                cmax[i]=cnums[i];
            }
        }


            selected='9';
            boolean minFound=false;
        for(int i=0;i<n;i++){
            if(cnums[i]!='0' && !minFound){
                minFound=true;
                selected=cnums[i];
            }
            if(minFound && cnums[i]==selected){

                cmin[i]='0';
            }
            else{
                cmin[i]=cnums[i];
            }
        }
        String mins= new String(cmin,0,n);
        String maxs= new String(cmax,0,n);
        return Integer.parseInt(maxs)-Integer.parseInt(mins);
    }

    public static void main(String[] args) {
        MaximumDifferenceByRemappingDigits soln= new MaximumDifferenceByRemappingDigits();
        System.out.println(soln.minMaxDifference(11891));
        System.out.println(soln.minMaxDifference(90));
    }
}

