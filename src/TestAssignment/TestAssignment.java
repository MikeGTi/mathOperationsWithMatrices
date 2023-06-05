package TestAssignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestAssignment {
    public static void main(String[] args){
        /*if (!(args[0].equals(""))){
            String inpString = GetStringFromFile(args[0]);
        }*/

        String inpStringTest = "A=[5 2 4; 0 2 -1; 3 -5 -4]\n" +
                               "B=[-6 -5 -8; -1 -1 -10; 10 0 -7]\n" +
                               "C=[-1 -7 6; -2 9 -4; 6 -10 2]\n" +
                               "\n" +
                               "A+B+C";

        //Arrays.stream(matrixString).forEach(e -> System.out.println(e));

        ParserInputString parserInputString = new ParserInputString(inpStringTest);
        Matrices matrices = new Matrices(parserInputString.getMatricesNames(),
                                         parserInputString.getMatricesStrings());

        CalculatorMatrix exprMatrix = new CalculatorMatrix(matrices, parserInputString.getExpression());
        Matrix resMatrix = exprMatrix.calculateExpression();
        System.out.println(resMatrix.toString());
    }

    private static String getStringFromFile(String _filepath){
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
    }

}