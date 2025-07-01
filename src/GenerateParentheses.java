import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {


    public List<String> generateParentheses(int n) {
        List<String> data= new ArrayList<>();
        generate(new StringBuilder(),n,0,data);
        return data;
    }

    public void generate(StringBuilder builder,int open,int close,List<String> answer){
        if(open<0 || close<0){
            return;
        }
        if(open==0 && close==0){
            answer.add(builder.toString());
        }
        if(open>0) {
            builder.append("(");
            generate(builder,open-1,close+1,answer);
            builder.deleteCharAt(builder.length()-1);

        }
        if(close>0){
            builder.append(")");
            generate(builder,open,close-1,answer);
            builder.deleteCharAt(builder.length()-1);
        }

    }

    public static void main(String[] args) {
        GenerateParentheses parentheses= new GenerateParentheses();
        System.out.println(parentheses.generateParentheses(5));
    }
}
