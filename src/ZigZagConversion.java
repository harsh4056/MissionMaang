public class ZigZagConversion {

    public String convert(String s, int numRows) {
        StringBuilder[] arr= new StringBuilder[numRows];
        int n=s.length();
        int c=0;
        int parity=1;
        while(c<n){
             for(int i=0;i<numRows &&c<n;i++){
                 if(arr[i]==null){
                     arr[i]=new StringBuilder();
                 }
                 arr[i].append(s.charAt(c));
                 c++;
             }
            for(int i=numRows-2;i>=1 &&c<n;i--){
                arr[i].append(s.charAt(c));
                c++;
            }
        }
        String res="";
        for(StringBuilder sb:arr){
            res=res+sb.toString();
        }
        return res;


    }

    public static void main(String[] args) {
        ZigZagConversion zigZagConversion= new ZigZagConversion();
        System.out.println(zigZagConversion.convert("PAYPALISHIRING",4));
    }
}
