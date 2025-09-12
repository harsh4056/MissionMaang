public class LargestSame3DigitNumber {
    public String largestGoodInteger(String num) {
        int li=-1;
        String ls="";
        char []nums=num.toCharArray();
        StringBuilder st= new StringBuilder();
        for(int i=0;i<=nums.length-3;i++){
            char c=nums[i];
            int count=0;

            for(int j=i;j<i+3;j++){
                if(nums[j]==c && count<3){
                    st.append(c);
                    count++;
                }
                else{
                    break;
                }
            }
            if(count==3){
                String s=st.toString();
                int a=Integer.parseInt(s);
                if(a>li){
                    li=a;
                    ls=s;
                }


            }
            st= new StringBuilder();
        }
        if(li!=-1)
            return ls;
        return "";
    }

    public static void main(String[] args) {
        LargestSame3DigitNumber sol = new LargestSame3DigitNumber();

        // Test case 1
        String res1 = sol.largestGoodInteger("222");
        System.out.println(res1); // Expected: "777"

        // Test case 2
        String res2 = sol.largestGoodInteger("2300019");
        System.out.println(res2); // Expected: "000"

        // Test case 3
        String res3 = sol.largestGoodInteger("42352338");
        System.out.println(res3); // Expected: ""
    }

}
