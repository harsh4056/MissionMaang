import java.util.Scanner;

public class PopCornBuying {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t=sc.nextInt();

        for (int i = 0; i < t; i++) {
            int amount=sc.nextInt();
            amount=amount-100;
            System.out.println(amount/50);
        }
    }
}
