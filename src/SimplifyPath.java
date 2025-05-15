import java.util.Stack;

public class SimplifyPath {

    public String simplifyPath(String path) {

        Stack<String> stack= new Stack<>();
        path=path+"/";
        StringBuilder finalAnswer= new StringBuilder();
        StringBuilder stringBuilder= new StringBuilder();

        char[] pathCharArray=path.toCharArray();
        for (char c : pathCharArray) {
            if (c == '/') {
                if (!stringBuilder.isEmpty() && !(stringBuilder.toString().equals(".")) && !(stringBuilder.toString().equals(".."))) {
                    stack.push(stringBuilder.toString());
                }
                if(!stringBuilder.isEmpty()  && (stringBuilder.toString().equals(".."))){
                    if(!stack.isEmpty())
                     stack.pop();
                }

                stringBuilder = new StringBuilder();
                continue;
            }
            stringBuilder.append(c);
        }
        while (!stack.isEmpty()){
            String s=stack.pop();
            finalAnswer.insert(0, s);
            finalAnswer.insert(0, "/");

        }
        if(finalAnswer.isEmpty())
            return "/";
        return finalAnswer.toString();

    }

    public static void main(String[] args) {
        SimplifyPath simplifyPath= new SimplifyPath();
        System.out.println(simplifyPath.simplifyPath("/a/../../b/../c//.//"));

    }


}
