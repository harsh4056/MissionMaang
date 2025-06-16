public class GoalParserInterpretation {

    public String interpret(String command) {


        StringBuilder answer= new StringBuilder();
        for (int i = 0; i < command.length(); ) {
            char c = command.charAt(i);

            switch (c){
                case 'G':
                    answer.append('G');
                    i++;
                    break;
                case '(':
                    if(command.charAt(i+1)==')'){
                        answer.append('o');
                        i+=2;
                    }
                    else{
                        answer.append("al");
                        i+=4;
                    }
                    break;
            }
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        GoalParserInterpretation parser = new GoalParserInterpretation();

        System.out.println(parser.interpret("G()(al)")); // Expected: "Goal"
        System.out.println(parser.interpret("G()()()()(al)")); // Expected: "Gooooal"
        System.out.println(parser.interpret("(al)G(al)()()G")); // Expected: "alGalooG"
    }

}
