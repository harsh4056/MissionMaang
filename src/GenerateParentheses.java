import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {


    public List<String> generateParentheses(int n) {
        List<String> data= new ArrayList<>();
        backtrack(n,0,data,0,0,new StringBuilder());
        return data;
    }

    public void backtrack(int n,int sum,List<String> para,int open,int close,StringBuilder stringBuilder){

        if(open<n) {
            stringBuilder.append("(");
            backtrack(n, sum, para, open + 1, close, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }


        if( stringBuilder.length()==(n*2)){
            para.add(stringBuilder.toString());
            return;
        }



        if(open>close) {
            stringBuilder.append(")");
            backtrack(n, sum, para, open, close+1, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }






    }

    public static void main(String[] args) {
        GenerateParentheses parentheses= new GenerateParentheses();
        System.out.println(parentheses.generateParentheses(3));
    }
}
