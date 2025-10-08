import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveKBalancedSubstrings {

    public String removeSubstring(String s, int k) {
        StringBuilder sb= new StringBuilder(s);
        StringBuilder pattern= new StringBuilder();
        pattern.append("(".repeat(Math.max(0, k)));
        pattern.append(")".repeat(Math.max(0, k)));
        int i=0;
        while ((i+(2*k))<sb.length()){
            String temp=sb.substring(i,i+(2*k));
            if((temp).contentEquals(pattern)){
                sb.delete(i,i+2*k);
                i = Math.max(0,i-2*k);
            }
            else i++;
        }
       return sb.toString();
    }

    public static void main(String[] args) {
        RemoveKBalancedSubstrings soln= new RemoveKBalancedSubstrings();
        //System.out.println(soln.removeSubstring("(((((())))))(",3));
        System.out.println(soln.removeSubstring("((()))()()()",3));
        System.out.println(soln.removeSubstring("(((((()))(",3));

    }
}
