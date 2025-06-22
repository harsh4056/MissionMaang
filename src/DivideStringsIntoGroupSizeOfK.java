public class DivideStringsIntoGroupSizeOfK {

    public String[] divideString(String s, int k, char fill) {
        StringBuilder str = new StringBuilder(s);
        while(str.length()%k!=0){
            str.append(fill);
        }
        char []sArray= str.toString().toCharArray();
        String arr[]=new String[str.length()/k];
        for(int i=0;i<sArray.length;i+=k){
            arr[i/k]=String.valueOf(sArray,i,k);
        }
        return arr;
    }

    public static void main(String[] args) {
        DivideStringsIntoGroupSizeOfK solution = new DivideStringsIntoGroupSizeOfK();

      /*  String[] result1 = solution.divideString("abcdefghi", 3, 'x');
        System.out.println(java.util.Arrays.toString(result1)); // [abc, def, ghi]*/

        String[] result2 = solution.divideString("abcdefghij", 4, 'z');
        System.out.println(java.util.Arrays.toString(result2)); // [abcd, efgh, ijzz]

        String[] result3 = solution.divideString("hello", 2, 'x');
        System.out.println(java.util.Arrays.toString(result3)); // [he, ll, ox]
    }

}
