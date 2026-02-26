public class ExcelSheetColumnTitle {
    public String convertToTitle(int columnNumber) {
        int n=columnNumber;
        StringBuilder sb= new StringBuilder();
        while(n>0){
            int rem=n%26;
            rem--;
            sb.append((char)('A'+rem));
            n=n/26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        ExcelSheetColumnTitle soln= new ExcelSheetColumnTitle();
        System.out.println(soln.convertToTitle(27));
    }
}
