public class NumberOfPushups {
    public static void main(String[] args) {
        NumberOfPushups soln= new NumberOfPushups();
        System.out.println(soln.calculateTotalPushups(2016));
    }
    public int calculateTotalPushups(int year){
        boolean whetherLeapYear= year%4==0;
        if(whetherLeapYear){
            return 290;
        }
        else {
            return 280;
        }
    }
}
