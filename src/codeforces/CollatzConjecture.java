package codeforces;

import java.util.*;

public class CollatzConjecture {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CollatzConjecture collatzConjecture= new CollatzConjecture();
        int n = sc.nextInt();        // size
        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=collatzConjecture.findNum(a,b);
            System.out.println(c);
        }



        // Example: print array

    }
    public int findNum(int k,int n){
        while(k>0) {
            boolean divisible = (n - 1) % 3 == 0;
            int temp =  (n - 1) / 3;
            if(temp%2==1 && divisible ){
                if( k==1){
                    return temp;
                }
                else{
                    n=n*2;
                }
            }
            else{
                n=n*2;
            }
        k--;
        }
        return n;
    }

}
