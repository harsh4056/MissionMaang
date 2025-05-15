public class DefangIPAddress {


    public String defangIPaddr(String address) {

       String answer= address.replace(".","[.]");

        return answer;
    }

    public static void main(String[] args) {
        DefangIPAddress defangIPAddress= new DefangIPAddress();
        String answer =defangIPAddress.defangIPaddr("255.100.50.0");
        System.out.println(answer);

    }

}
