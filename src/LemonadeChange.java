public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int[] galla= new int[2];
        for (int i = 0; i < bills.length; i++) {
            if(bills[i]==5){
                galla[0]++;

            }
           else if(bills[i]==10 ){
               if(galla[0]>0) {
                   galla[0]--;
                   galla[1]++;
               }else{
                   return false;
               }
            }
           else{
               if(galla[0]>0 && galla[1]>0) {
                   galla[0]--;
                   galla[1]--;
               }
               else if(galla[0]>2){
                   galla[0]=galla[0]-3;
               }
               else{
                   return false;
               }
            }
        }
        return true;
    }

}
