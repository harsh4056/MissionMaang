public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder answer = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry == 1) {
            int bit1 = i >= 0 ? a.charAt(i--) - '0' : 0;
            int bit2 = j >= 0 ? b.charAt(j--) - '0' : 0;

            int sum = bit1 + bit2 + carry;
            answer.append(sum % 2);
            carry = sum / 2;
        }

        return answer.reverse().toString();
    }



    public static void main(String[] args) {
        AddBinary addBinary= new AddBinary();
        String a = "1";String b = "111";
        System.out.println(addBinary.addBinary(a,b));

    }

}
