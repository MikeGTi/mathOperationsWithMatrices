package Command;

import TestAssignment.CalculatorMatrix;
import TestAssignment.ConverterMatrix;
import TestAssignment.Matrix;

import java.util.Optional;

public class CalculateEvaluator {
    public static void main(String[] args) {
        /*shouldReturnMatrixAddition("[-2 -10 2; -3 10 -15; 19 -15 -9]","[5 2 4; 0 2 -1; 3 -5 -4]", "[-6 -5 -8; -1 -1 -10; 10 0 -7]", "[-1 -7 6; -2 9 -4; 6 -10 2]");
        shouldReturnMatrixAddition("[-2 -10 2]","[5 2 4]", "[-6 -5 -8; -1 -1 -10; 10 0 -7]", "[-1 -7 6; -2 9 -4; 6 -10 2]");
        shouldReturnMatrixAddition("[2]","[1]", "[1]");

        shouldReturnMatrixSubtraction("[12 14 6; 3 -6 13; -13 5 1]","[5 2 4; 0 2 -1; 3 -5 -4]", "[-6 -5 -8; -1 -1 -10; 10 0 -7]", "[-1 -7 6; -2 9 -4; 6 -10 2]");
        shouldReturnMatrixSubtraction("[12 14 6]","[5 2 4]", "[-6 -5 -8; -1 -1 -10; 10 0 -7]", "[-1 -7 6; -2 9 -4; 6 -10 2]");
        shouldReturnMatrixSubtraction("[0]","[1]", "[1]");*/

        //TestAssignment.TestAssignment.Matrix[] matrices = initMatrices
        Calculator calculator = new Calculator(
                new AdditionCommand(new CalculatorMatrix(), new ConverterMatrix("[5 2 4; 0 2 -1; 3 -5 -4]", "[-6 -5 -8; -1 -1 -10; 10 0 -7]", "[-1 -7 6; -2 9 -4; 6 -10 2]").convertFromString()),
                new SubtractionCommand(new CalculatorMatrix(), new ConverterMatrix("[5 2 4; 0 2 -1; 3 -5 -4]", "[-6 -5 -8; -1 -1 -10; 10 0 -7]", "[-1 -7 6; -2 9 -4; 6 -10 2]").convertFromString()),
                new MultiplicationCommand(new CalculatorMatrix(), new ConverterMatrix("[5 2 4; 0 2 -1; 3 -5 -4]", "[-6 -5 -8; -1 -1 -10; 10 0 -7]", "[-1 -7 6; -2 9 -4; 6 -10 2]").convertFromString())
        );

        Optional<Matrix> res = Optional.ofNullable(calculator.sum());
        //res.print();

    }

}
