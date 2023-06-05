
import TestAssignment.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class Test_TestAssignment {

    static class StorageTestData {
        private final Matrices matrices;
        private final Matrix rightAnswerMatrix;

        private String expression;

        public StorageTestData(String rightAnswerMatrix, char[] namesMatrices, String[] matrices, String expression) {
            this.matrices = new Matrices(namesMatrices, matrices);
            this.rightAnswerMatrix = new Matrix(rightAnswerMatrix);
            this.expression = expression;
        }

        public Matrices getMatrices() {
            return matrices;
        }

        public Matrix getRightAnswerMatrix() {
            return rightAnswerMatrix;
        }

        public String getExpression() {
            return expression;
        }
    }

    @Test
    public void MatrixOperationsTest(){
        StorageTestData storageTestData1 = new StorageTestData("[-2 -10 2; -3 10 -15; 19 -15 -9]",
                new char[]{'A', 'B', 'C'},
                new String[]{"[5 2 4; 0 2 -1; 3 -5 -4]", "[-6 -5 -8; -1 -1 -10; 10 0 -7]", "[-1 -7 6; -2 9 -4; 6 -10 2]"},
                "A+B+C");
        shouldReturnMatrixOperation(storageTestData1.getRightAnswerMatrix(),storageTestData1.getMatrices(),storageTestData1.getExpression());

        StorageTestData storageTestData2 = new StorageTestData("[-2 -10 2]",
                new char[]{'A', 'B', 'C'},
                new String[]{"[5 2 4]", "[-6 -5 -8; -1 -1 -10; 10 0 -7]", "[-1 -7 6; -2 9 -4; 6 -10 2]"},
                "A+B+C");
        shouldReturnMatrixOperation(storageTestData2.getRightAnswerMatrix(),storageTestData2.getMatrices(),storageTestData2.getExpression());

        StorageTestData storageTestData3 = new StorageTestData("[2]",
                new char[]{'A', 'B'},
                new String[]{"[1]", "[1]"},
                "A+B");
        shouldReturnMatrixOperation(storageTestData3.getRightAnswerMatrix(),storageTestData3.getMatrices(),storageTestData3.getExpression());
    }

    private void shouldReturnMatrixOperation(Matrix rightAnswer, Matrices matrices, String expression) {
        CalculatorMatrix calculatorMatrix = new CalculatorMatrix(matrices, expression);
        Matrix resMatrix = calculatorMatrix.calculateExpression();

        Assertions.assertNotNull(resMatrix);
        Assertions.assertEquals(rightAnswer.getRows(),resMatrix.getRows());
        Assertions.assertEquals(rightAnswer.getColumns(),resMatrix.getColumns());
        Assertions.assertEquals(rightAnswer.toString(),resMatrix.toString());
    }
}
