class Spreadsheet {
    int[][] sheet;

    public Spreadsheet(int rows) {
        sheet = new int[rows+1][26];
    }

    public void setCell(String cell, int value) {
        int c = cell.charAt(0)-'A';
        int row = Integer.parseInt(cell.substring(1));
        sheet[row][c] = value;
    }

    public void resetCell(String cell) {
        int c = cell.charAt(0)-'A';
        int row = Integer.parseInt(cell.substring(1));
        sheet[row][c] = 0;
    }

    public int getValue(String formula) {
        String[] arr = formula.split("\\+");
        String d1 = arr[0].substring(1);
        String d2 = arr[1];
        int op1 = 0;
        if (containsLetters(d1)) {
            int c = d1.charAt(0)-'A';
            int row = Integer.parseInt(d1.substring(1));
            op1 = sheet[row][c];
        } else {
            op1 = Integer.parseInt(d1);
        }
        int op2 = 0;
        if (containsLetters(d2)) {
            int c = d2.charAt(0)-'A';
            int row = Integer.parseInt(d2.substring(1));
            op2 = sheet[row][c];
        } else {
            op2 = Integer.parseInt(d2);
        }
        return op1 + op2;

    }

    boolean containsLetters(String s) {
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                return true; // contains at least one letter
            }
        }
        return false; // only digits (or empty)
    }

    public static void main(String[] args) {
        Spreadsheet sheet = new Spreadsheet(24);

        // Test case from last executed input
        sheet.setCell("B24", 66688);
        sheet.resetCell("O15");

        // Printing values to check correctness
        System.out.println(sheet.getValue("=B24+0")); // Expected: 66688
        System.out.println(sheet.getValue("=O15+0")); // Expected: 0
    }


}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */