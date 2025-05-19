public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if(numRows==1)
            return s;
        StringBuilder[] stringBuilders= new StringBuilder[numRows];
        for (int i = 0; i < stringBuilders.length; i++) {
            stringBuilders[i]= new StringBuilder();

        }
        int rows=0;
        int length= 0;
        boolean reverse=false;
        while (length<s.length()){
            stringBuilders[rows].append(s.charAt(length));

            if(rows==0){
                reverse=false;
            }
            if(rows==numRows-1){
                reverse=true;
            }

            if(reverse){
                rows--;
            }
            else {
                rows++;
            }


            length++;
        }
        StringBuilder answer= new StringBuilder();
        for (StringBuilder stringBuilder : stringBuilders) {
            answer.append(stringBuilder);
        }

        return answer.toString();


    }

    public static void main(String[] args) {
        ZigZagConversion zigZagConversion= new ZigZagConversion();
        System.out.println(zigZagConversion.convert("PAYPALISHIRING",1));
    }
}
