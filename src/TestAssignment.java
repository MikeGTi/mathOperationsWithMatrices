import Parser.ParserInputString;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class TestAssignment {

    public static void main(String[] args){
        final String helpString = "Evaluate matrices operations\n" +
                                  "java TestAssignment < data01.txt > result01.txt\n" +
                                  "Data sample:\n" +
                                  "A=[1 2 2; 0 3 1; -1 2 -4]   <- first matrix definition,  matrix A is 3x3\n" +
                                  "B=[2 1 0; -2 -1 -1; 1 1 2]  <- second matrix definition, matrix B is 3x3\n" +
                                  "                            <- new line\n" +
                                  "A+B                         <- matrix operation (might be +, -, *)";

        /*if (args.length == 0) {
            System.err.println("args is null");
            System.exit(0);
        }*/

        Set<String> argsSet = Arrays.stream(args).collect(Collectors.toSet());
        if (argsSet.contains("/h") || argsSet.contains("/?")) {
            System.out.println(helpString);
            System.exit(0);
        }

        String inpStringTest = "A=[5 2 4; 0 2 -1; 3 -5 -4]\n" +
                               "B=[-6 -5 -8; -1 -1 -10; 10 0 -7]\n" +
                               "C=[-1 -7 6; -2 9 -4; 6 -10 2]\n" +
                               "\n" +
                               "A+B+C";

        //String inpString = inpStringTest;
        String inpString = args[0];

        //Arrays.stream(matrixString).forEach(e -> System.out.println(e));

        ParserInputString parserInputString = new ParserInputString(inpString);
        Matrices matrices = new Matrices(parserInputString.getMatricesNames(),
                                         parserInputString.getMatricesStrings());

        CalculatorMatrix exprMatrix = new CalculatorMatrix(matrices, parserInputString.getExpression());
        Matrix resMatrix = exprMatrix.calculateExpression();
        System.out.println(resMatrix.toString());
    }

    /*private static String getStringFromFile(String _filepath){
        StringBuilder stringBuilder = new StringBuilder();
        int i;
        try (FileInputStream fileInputStream = new FileInputStream(_filepath)) {
            do {
                i = fileInputStream.read();
                if (i != -1) stringBuilder.append((char) i);
            } while (i != -1);
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Error I/O");
        }
        return stringBuilder.toString();
    }*/

}