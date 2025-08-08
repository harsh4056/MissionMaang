import java.util.HashMap;

public class IntegerToEnglishWords {
    public String numberToWords(int num) {
        if(num==0) return "Zero";

        HashMap<Integer,String> map= new HashMap<>();
        map.put(1,"One");
        map.put(2,"Two");
        map.put(3,"Three");
        map.put(4,"Four");
        map.put(5,"Five");
        map.put(6,"Six");
        map.put(7,"Seven");
        map.put(8,"Eight");
        map.put(9,"Nine");
        map.put(10,"Ten");
        map.put(11,"Eleven");
        map.put(12,"Twelve");
        map.put(13,"Thirteen");
        map.put(14,"Fourteen");
        map.put(15,"Fifteen");
        map.put(16,"Sixteen");
        map.put(17,"Seventeen");
        map.put(18,"Eighteen");
        map.put(19,"Nineteen");
        map.put(20,"Twenty");
        map.put(30,"Thirty");
        map.put(40,"Forty");
        map.put(50,"Fifty");
        map.put(60,"Sixty");
        map.put(70,"Seventy");
        map.put(80,"Eighty");
        map.put(90,"Ninety");
        map.put(100,"Hundred");
        map.put(1000,"Thousand");

        int billion=1_000_000_000;
        int million=1_000_000;
        int thousand=1_000;


        StringBuilder ans= new StringBuilder();
        if(num/billion>0){
            int value=num/billion;
            num=num%billion;
            ans.append(map.get(value));
            ans.append(" ");
            ans.append("Billion");
            if(num>0)
                ans.append(" ");

        }

        if(num/million>0){
            int value=num/million;
            num=num%million;
            ans.append(getLessThanThousand(value,map));
            ans.append(" ");
            ans.append("Million");
            if(num>0)
                ans.append(" ");

        }
        if(num/thousand>0){
            int value=num/thousand;
            num=num%1000;
            ans.append(getLessThanThousand(value,map));
            ans.append(" ");
            ans.append("Thousand");
            if(num>0)
                ans.append(" ");

        }
        ans.append(getLessThanThousand(num,map));
        return ans.toString();

    }

    public String getLessThanThousand(int n,HashMap<Integer,String> map){

        int hundred=1_00;
        int ten=1_0;
        StringBuilder str=new StringBuilder();


        int h=n/hundred;
        if(h>0){
            n=n%hundred;
            str.append(map.get(h));
            str.append(" ");
            str.append("Hundred");
            if(n>0){
                str.append(" ");
            }

        }
        if(n>20){

            int tens= (n/ten)*10;
            if(tens>0) {
                n = n % ten;
                str.append(map.get(tens));
                if(n>0)
                    str.append(" ");
            }
            if(n>0) {
                str.append(map.get(n));

            }
            return str.toString();

        }
        else{
            if(n>0)
                str.append(map.get(n));
            return str.toString();
        }



    }

    public static void main(String[] args) {
        IntegerToEnglishWords  englishWords= new IntegerToEnglishWords();
        System.out.println(englishWords.numberToWords(30));
    }
}
