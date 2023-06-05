package Command;


import TestAssignment.CalculatorMatrix;

public class AdditionCommand implements Command{
    private CalculatorMatrix calculateMatrix;
    private TestAssignment.Matrix[] matrices;

    public AdditionCommand(CalculatorMatrix calculateMatrix, TestAssignment.Matrix[] matrices) {
        this.calculateMatrix = calculateMatrix;
        this.matrices = matrices;
    }

    @Override
    public TestAssignment.Matrix execute() {
        calculateMatrix.multiplication(matrices);
        return null;
    }

}
