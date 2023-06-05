package TestAssignment;

public class ParserInputString {
    private String inputString;

    public ParserInputString(String inputString) {
        this.inputString = inputString;
    }

    public String[] getMatricesWithNames() {
        return inputString.split("\n\n")[0].split("\n");
        //Arrays.stream(matricesWithNames).forEach(e -> System.out.println(e));
    }

    public char[] getMatricesNames() {
        char[] matrixNames = new char[this.getMatricesWithNames().length];
        int i = 0;
        for (String s : this.getMatricesWithNames()) {
            matrixNames[i] = s.trim().charAt(0);
            i++;
        }
        return matrixNames;
    }

    public String getExpression() {
        return inputString.split("\n\n")[1];
    }

    public String[] getMatricesStrings() {
        String[] matrixStrings = new String[this.getMatricesWithNames().length];
        int i = 0;
        for (String s : this.getMatricesWithNames()) {
            matrixStrings[i] = s.trim().split("=")[1];
            i++;
        }
        return matrixStrings;
    }
}
