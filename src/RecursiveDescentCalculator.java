class RecursiveDescentCalculator {
    private int i = 0;  // global index
    private String s;

    public int calculate(String str) {
        s = str.replaceAll(" ", ""); // remove spaces
        i = 0;
        return parseExpr();
    }

    private int parseExpr() {
        int value = parseTerm();
        while (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            char op = s.charAt(i++);
            int right = parseTerm();
            if (op == '+') value += right;
            else value -= right;
        }
        return value;
    }

    private int parseTerm() {
        int value = parseFactor();
        while (i < s.length() && (s.charAt(i) == '*' || s.charAt(i) == '/')) {
            char op = s.charAt(i++);
            int right = parseFactor();
            if (op == '*') value *= right;
            else value /= right;
        }
        return value;
    }

    private int parseFactor() {
        if (s.charAt(i) == '(') {
            i++; // skip '('
            int value = parseExpr();
            i++; // skip ')'
            return value;
        } else {
            int num = 0;
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                num = num * 10 + (s.charAt(i) - '0');
                i++;
            }
            return num;
        }
    }

    public static void main(String[] args) {
        RecursiveDescentCalculator calculator= new RecursiveDescentCalculator();
        System.out.println(calculator.calculate("2 + 3 * (4 - 1)"));
    }
}
