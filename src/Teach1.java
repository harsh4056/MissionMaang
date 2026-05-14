import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Teach1 {
    int answer=0;
    public static void main(String[] args) {
        //-2^31 to 2^31-1
        int a=Integer.MAX_VALUE;
        //-2^63 to 2^63-1
        System.out.println(a+1);
        long b=Long.MAX_VALUE;
        System.out.println(b);
        char c= 'c';
        System.out.println(c);
        //97 to 122
        //A to Z 65 to 90
        System.out.println((int)c);

        c='c';

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list);


        char[] d= new char[4];
        d[0]='a';
        d[1]='a';
        d[2]='a';
        d[3]='a';
        String e= new String(d,0,d.length);
        System.out.println(e);

        int answer= d[3];
        char ans=(char)answer;
        char[]cs= e.toCharArray();
        boolean f=true;
        System.out.println(f);
        int g=32%17;
        System.out.println(g);
        f= a==b;
        System.out.println(f);

        f=(a==b && a<b);
        //conditional flow
        if(a==b){
            System.out.println("a==b");
        }
        else if(a<b){
            System.out.println("a<b");
        }
        for(char t='a';t<='z';){
            System.out.print(t);
            t+=2;
        }

        for (int i = 0; i < 5; i++) {
            int z=0;
             z+=i;
            System.out.println(i);
        }

        int i=0;
        /*do{

            System.out.println();
            i++;
        }while(i<5);*//*
        Scanner sc= new Scanner(System.in);
        int input1= sc.nextInt();
        int input2= sc.nextInt();
        System.out.println(input1+input2);*/

         a = 5; // 0101
         b = 3; // 0011

        System.out.println(a & b); // 1
        System.out.println(a | b); // 7
        System.out.println(a ^ b); // 6

        int sum=0;
        int product=1;
        int[] arr= new int[4];
        arr[0]=1;
        arr[1]=2;
        arr[2]=3;
        arr[3]=4;
        for (int j = 0; j < arr.length; j++) {
            sum+=arr[i];
            product*=arr[i];
        }
        System.out.println(sum);
        System.out.println(product);


    }
}
