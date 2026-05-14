import java.util.Scanner;

public class PrintSquares {


    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t= sc.nextInt();
        for (int i = 0; i < t; i++) {
            int num= sc.nextInt();
            int square=num*num;
            int cube= num*num*num;
            System.out.println(square);
            System.out.println(cube);
        }
    }
}
