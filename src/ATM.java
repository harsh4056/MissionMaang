import java.util.Arrays;

class ATM {
    int[] atm;

    public ATM() {
        atm= new int[5];
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < banknotesCount.length; i++) {
            atm[i]+= banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        int[]ans= new int[5];
        if(amount>=500){
                int d=Math.min(atm[4],amount/500);
                atm[4]-=d;
                ans[4]=d;
                amount-=d*500;
        }
         if(amount>=200){
             int d=Math.min(atm[3],amount/200);
             atm[3]-=d;
             ans[3]=d;
             amount-=d*200;

        }
         if(amount>=100){
             int d=Math.min(atm[2],amount/100);
             atm[2]-=d;
             ans[2]=d;
             amount-=d*100;

        }
         if(amount>=50){
             int d=Math.min(atm[1],amount/50);
             atm[1]-=d;
             ans[1]=d;
             amount-=d*50;
        }
         if(amount>=20){
             int d=Math.min(atm[0],amount/20);
             atm[0]-=d;
             ans[0]=d;
             amount-=d*20;

        }
        if(amount==0){
            return ans;
        }
        else{
            deposit(ans);
            return new int[]{-1};
        }
    }
    public static void main(String[] args) {
        ATM atm = new ATM();

        // 20, 50, 100, 200, 500
        atm.deposit(new int[]{
                250796,638723,691758,845522,938973
        });
        atm.deposit(new int[]{
                215317,848628,182949,784609,30472
        });

        System.out.println(Arrays.toString(atm.withdraw(722349970)));
    }





}
